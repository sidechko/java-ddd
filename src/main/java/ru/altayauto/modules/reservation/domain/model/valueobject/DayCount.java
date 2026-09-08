package ru.altayauto.modules.reservation.domain.model.valueobject;


import org.jspecify.annotations.NonNull;
import ru.altayauto.modules.shared.exception.NumberLessThanZeroException;

public record DayCount(int count) implements Comparable<DayCount> {
    public DayCount {
        if(count < 0)
            throw new NumberLessThanZeroException("Количество дней не может быть отрицательным.");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DayCount dayCount = (DayCount) o;
        return count == dayCount.count;
    }

    @Override
    public int hashCode() {
        return count;
    }

    @Override
    public int compareTo(@NonNull DayCount o) {
        return this.count - o.count;
    }
}
