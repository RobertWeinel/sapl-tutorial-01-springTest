package io.sapl.tutorial.command;

import lombok.experimental.UtilityClass;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@UtilityClass
public class AuktionAPI {
    public record LegeAutionAnCommand(@TargetAggregateIdentifier String id, String beschreibung){};
    public record AendereBeschreibung(@TargetAggregateIdentifier String id, String neueBeschreibung){};
    public record AutionAngelegt(@TargetAggregateIdentifier String id, String beschreibung){};
    public record BeschreibungGeaendert(@TargetAggregateIdentifier String id, String neueBeschreibung){};
}
