package ru.altayauto.modules.catalogue.domain.model.valueobject;

import org.jspecify.annotations.NonNull;
import ru.altayauto.modules.shared.exception.EmptyStringValue;

import java.util.Objects;

public record ImagePath(@NonNull String path) {
    public ImagePath{
        if(path.isEmpty())
            throw new EmptyStringValue("ImagePath");
        if(path.isBlank())
            throw new EmptyStringValue("ImagePath");
        //TODO validate url
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        return ((ImagePath) obj).path.equals(this.path);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(path);
    }

}
