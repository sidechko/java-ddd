package ru.altayauto.modules.catalogue.domain.model.valueobject;

import org.jspecify.annotations.NonNull;

import java.util.Objects;

public record AutoInfo(
        @NonNull Title producer,
        @NonNull Title model,
        @NonNull Title transmission,
        @NonNull PositiveDecimalWithHundredths engineVolume,
        @NonNull PositiveDecimalWithHundredths enginePower
) {
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj==null || this.getClass() != obj.getClass()) return false;
        AutoInfo autoInfo = (AutoInfo) obj;
        if (!autoInfo.producer.equals(producer)) return false;
        if(!autoInfo.model.equals(model)) return false;
        if(!autoInfo.transmission.equals(transmission)) return false;
        if(!autoInfo.engineVolume.equals(engineVolume)) return false;
        return autoInfo.enginePower.equals(enginePower);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producer,model,transmission,engineVolume,enginePower);
    }
}
