package ru.altayauto.modules.catalogue.domain.model.exception;

import ru.altayauto.modules.shared.exception.AltayAutoException;

public class ImagePathException extends AltayAutoException {
    private ImagePathException(String message) {
        super(message);
    }

    public static class AlreadyLinked extends ImagePathException{
        public AlreadyLinked() {
            super("Данное изображение уже привязано к этому автомобилю");
        }
    }

    public static class NotLinked extends ImagePathException{
        public NotLinked() {
            super("Данное изображение не привязано к этому автомобилю");
        }
    }
}
