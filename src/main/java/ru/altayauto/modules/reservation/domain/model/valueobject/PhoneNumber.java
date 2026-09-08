package ru.altayauto.modules.reservation.domain.model.valueobject;

import org.jspecify.annotations.NonNull;
import ru.altayauto.modules.shared.exception.EmptyStringValue;

public record PhoneNumber(@NonNull String value) {

    public PhoneNumber{
        if(value.isEmpty())
            throw new EmptyStringValue("PhoneNumber");
        if(value.isBlank())
            throw new EmptyStringValue("PhoneNumber");
        //TODO validate
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
