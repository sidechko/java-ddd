package ru.altayauto.modules.reservation.domain.model.exception;

import ru.altayauto.modules.shared.exception.AltayAutoException;

public class RentsException extends AltayAutoException {
    private RentsException(String message) {
        super(message);
    }

    public static class RentsCollision extends RentsException {
        public RentsCollision() {
            super("Границы срока аренды имеют коллизию с существующими сроками.");
        }
    }

    public static class NotFoundForAuto extends RentsException {
        public NotFoundForAuto() {
            super("Таких сроков аренды не существует.");
        }
    }
}
