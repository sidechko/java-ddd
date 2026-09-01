package ru.altayauto.modules.reservation.domain.model.valueobject;

import org.jspecify.annotations.NonNull;
import ru.altayauto.modules.shared.exception.DecimalScaleOutOfRangeException;
import ru.altayauto.modules.shared.exception.NumberLessThanZeroException;

import java.math.BigDecimal;

public record Money(@NonNull BigDecimal value) {
    public Money{
        if(BigDecimal.ZERO.compareTo(value) > 0)
            throw new NumberLessThanZeroException();
        if(value.scale() > 2 || value.scale() < 0)
            throw new DecimalScaleOutOfRangeException();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        return value.equals(((Money) obj).value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
