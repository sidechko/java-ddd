package ru.altayauto.modules.reservation.domain.model.valueobject;

import org.jspecify.annotations.NonNull;
import ru.altayauto.modules.shared.exception.DecimalScaleOutOfRangeException;
import ru.altayauto.modules.shared.exception.NumberLessThanZeroException;

import java.math.BigDecimal;

public record Money(@NonNull BigDecimal value) {
    public Money{
        if(BigDecimal.ZERO.compareTo(value) > 0)
            throw new NumberLessThanZeroException("Денежные единицы не могут быть менее 0");
        if(value.scale() > 2 || value.scale() < 0)
            throw new DecimalScaleOutOfRangeException("Денежные единицы не могут иметь значение меньше копеек, верный формат 1.99 ");
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
