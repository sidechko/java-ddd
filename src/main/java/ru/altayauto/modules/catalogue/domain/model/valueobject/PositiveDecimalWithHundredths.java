package ru.altayauto.modules.catalogue.domain.model.valueobject;

import org.jspecify.annotations.NonNull;
import ru.altayauto.modules.shared.exception.DecimalScaleOutOfRangeException;
import ru.altayauto.modules.shared.exception.NumberLessThanZeroException;

import java.math.BigDecimal;

public record PositiveDecimalWithHundredths(@NonNull BigDecimal value) {
    public PositiveDecimalWithHundredths {
        if(BigDecimal.ZERO.compareTo(value) > 0)
            throw new NumberLessThanZeroException();
        if(value.scale() > 2 || value.scale() < 0)
            throw new DecimalScaleOutOfRangeException();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        return value.equals(((PositiveDecimalWithHundredths) obj).value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
