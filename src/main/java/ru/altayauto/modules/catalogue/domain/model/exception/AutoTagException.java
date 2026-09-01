package ru.altayauto.modules.catalogue.domain.model.exception;

import ru.altayauto.modules.shared.exception.AltayAutoException;

public class AutoTagException extends AltayAutoException {
    private AutoTagException(String message) {
        super(message);
    }

    public static class AlreadyLinked extends AutoTagException{
        public AlreadyLinked() {
            super("Данный тэг уже привязан к этому автомобилю");
        }
    }

    public static class NotLinked extends AutoTagException{
        public NotLinked() {
            super("Данное тэг не привязан к этому автомобилю");
        }
    }
}
