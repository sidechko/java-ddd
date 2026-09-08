package ru.altayauto.modules.reservation.domain.model.valueobject;

import org.jspecify.annotations.NonNull;
import ru.altayauto.modules.shared.exception.EmptyStringValue;

public record Name(@NonNull String value) {
    public Name{
        if(value.isEmpty())
            throw new EmptyStringValue("Name");
        if(value.isBlank())
            throw new EmptyStringValue("Name");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Name that = (Name) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
