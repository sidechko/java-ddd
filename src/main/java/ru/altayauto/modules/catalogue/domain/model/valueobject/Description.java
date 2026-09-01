package ru.altayauto.modules.catalogue.domain.model.valueobject;

import org.jspecify.annotations.NonNull;
import ru.altayauto.modules.shared.exception.EmptyStringValue;

public record Description(@NonNull String value){
    public Description {
        if(value.isEmpty())
            throw new EmptyStringValue("Title");
        if(value.isBlank())
            throw new EmptyStringValue("Description");
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj==null || this.getClass() != obj.getClass()) return false;
        return ((Description) obj).value().equals(value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}