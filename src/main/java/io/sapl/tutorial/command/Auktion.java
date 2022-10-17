package io.sapl.tutorial.command;

import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
public class Auktion {
    @AggregateIdentifier
    String id;

    @CommandHandler
    public Auktion(AuktionAPI.LegeAutionAnCommand cmd){
        apply(new AuktionAPI.AutionAngelegt(cmd.id(), cmd.beschreibung()));
    }
}
