package io.sapl.tutorial.configuration;
import org.axonframework.eventhandling.tokenstore.TokenStore;
import org.axonframework.eventsourcing.EventCountSnapshotTriggerDefinition;
import org.axonframework.eventsourcing.SnapshotTriggerDefinition;
import org.axonframework.eventsourcing.Snapshotter;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.extensions.mongo.DefaultMongoTemplate;
import org.axonframework.extensions.mongo.eventsourcing.eventstore.MongoEventStorageEngine;
import org.axonframework.extensions.mongo.eventsourcing.tokenstore.MongoTokenStore;
import org.axonframework.serialization.Serializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.client.MongoClient;

@Configuration
public class AxonMongoConfiguration {

    @Bean
    public EventStorageEngine storageEngine(MongoClient client, Serializer serializer) {
        return MongoEventStorageEngine.builder().eventSerializer(serializer).snapshotSerializer(serializer)
                .mongoTemplate(DefaultMongoTemplate.builder().mongoDatabase(client).build()).build();
    }

    @Bean
    public TokenStore mongoTokenStore(MongoClient client, Serializer serializer) {
        return MongoTokenStore.builder().mongoTemplate(DefaultMongoTemplate.builder().mongoDatabase(client).build())
                .serializer(serializer).build();
    }

    @Bean
    public SnapshotTriggerDefinition giftCardSnapshotTrigger(Snapshotter snapshotter) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, 500);
    }

}