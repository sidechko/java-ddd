package ru.altayauto.modules.catalogue.domain.service.command;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import ru.altayauto.modules.catalogue.domain.model.valueobject.*;
import ru.altayauto.modules.shared.service.ICommand;

import java.util.UUID;

public record EditAutoInfoCommand(
        @NonNull UUID id,
        @Nullable GovernmentRegistrationNumber governmentRegistrationNumber,
        @Nullable Description description,
        @Nullable Title producer,
        @Nullable Title model,
        @Nullable Title transmission,
        @Nullable PositiveDecimalWithHundredths engineVolume,
        @Nullable PositiveDecimalWithHundredths enginePower
) implements ICommand {
    @Override
    public String getName() {
        return "EditAutoInfoCommand";
    }

    public boolean isEmpty() {
        return description == null &&
                enginePower == null &&
                producer == null &&
                model == null &&
                transmission == null &&
                engineVolume == null &&
                governmentRegistrationNumber == null;
    }

    public AutoInfo buildFrom(AutoInfo info) {
        Title producer = this.producer() != null
                ? this.producer()
                : info.producer();
        Title model = this.model() != null
                ? this.model()
                : info.model();
        Title transmission = this.transmission() != null
                ? this.transmission()
                : info.transmission();
        PositiveDecimalWithHundredths engineVolume = this.engineVolume() != null
                ? this.engineVolume()
                : info.engineVolume();
        PositiveDecimalWithHundredths enginePower = this.enginePower() != null
                ? this.enginePower()
                : info.enginePower();
        return new AutoInfo(producer, model, transmission, engineVolume, enginePower);
    }
}
