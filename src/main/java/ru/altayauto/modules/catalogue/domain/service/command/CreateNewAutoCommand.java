package ru.altayauto.modules.catalogue.domain.service.command;

import org.jspecify.annotations.NonNull;
import ru.altayauto.modules.catalogue.domain.model.valueobject.Description;
import ru.altayauto.modules.catalogue.domain.model.valueobject.GovernmentRegistrationNumber;
import ru.altayauto.modules.catalogue.domain.model.valueobject.PositiveDecimalWithHundredths;
import ru.altayauto.modules.catalogue.domain.model.valueobject.Title;
import ru.altayauto.modules.shared.service.ICommand;

import java.util.UUID;

public record CreateNewAutoCommand(
        @NonNull UUID id,
        @NonNull GovernmentRegistrationNumber governmentRegistrationNumber,
        @NonNull Description description,
        @NonNull Title producer,
        @NonNull Title model,
        @NonNull Title transmission,
        @NonNull PositiveDecimalWithHundredths engineVolume,
        @NonNull PositiveDecimalWithHundredths enginePower
) implements ICommand {
    @Override
    public String getName() {
        return "CreateNewAutoCommand";
    }
}
