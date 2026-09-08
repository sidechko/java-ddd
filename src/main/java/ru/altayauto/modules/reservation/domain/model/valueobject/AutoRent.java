package ru.altayauto.modules.reservation.domain.model.valueobject;

import org.jspecify.annotations.NonNull;
import ru.altayauto.modules.reservation.domain.model.exception.AutoRentMinHigherMaxException;

import java.util.Objects;

public record AutoRent(@NonNull DayCount minDayCount, @NonNull DayCount maxDayCount, @NonNull Money perDay) {
    public AutoRent {
        if (minDayCount.compareTo(maxDayCount) > 0)
            throw new AutoRentMinHigherMaxException();
    }
    public boolean collide(AutoRent rent) {
        if (rent.minDayCount.compareTo(this.maxDayCount) > 0)
            return false;
        return rent.maxDayCount.compareTo(this.minDayCount) >= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AutoRent autoRent = (AutoRent) o;
        return perDay.equals(autoRent.perDay) && minDayCount.equals(autoRent.minDayCount) && maxDayCount.equals(autoRent.maxDayCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(minDayCount, maxDayCount, perDay);
    }
}
