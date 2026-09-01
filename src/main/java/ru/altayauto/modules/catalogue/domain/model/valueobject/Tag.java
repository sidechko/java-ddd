package ru.altayauto.modules.catalogue.domain.model.valueobject;

import org.jspecify.annotations.NonNull;

public record Tag(@NonNull String value) {

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj==null || this.getClass() != obj.getClass()) return false;
        return ((Tag) obj).value().equals(value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
