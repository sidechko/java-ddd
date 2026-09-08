package ru.altayauto.modules.reservation.domain.model.exception;

import ru.altayauto.modules.shared.exception.AltayAutoException;

public class AutoRentMinHigherMaxException extends AltayAutoException {
    public AutoRentMinHigherMaxException() {
        super("Минимальное количество дней не может быть больше чем максимальное.");
    }
}
