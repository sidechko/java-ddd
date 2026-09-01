package ru.altayauto.modules.catalogue.domain.model.exception;

import ru.altayauto.modules.shared.exception.AltayAutoException;

public class GovernmentRegistrationNumberException extends AltayAutoException {
    private GovernmentRegistrationNumberException(String message) {
        super(message);
    }

    public static class ValueIsEmptyException extends GovernmentRegistrationNumberException{
        public ValueIsEmptyException(){
            super("Регистрационный номер не может быть пустым.");
        }
    }

    public static class ValueNotMatchedSizeException extends GovernmentRegistrationNumberException{
        public ValueNotMatchedSizeException(){
            super("Регистрационный номер не соответствует размеру.");
        }
    }

    public static class InvalidCharExceptionException extends GovernmentRegistrationNumberException{
        public InvalidCharExceptionException(){
            super("Регистрационный номер не соответствует размеру.");
        }
    }
}
