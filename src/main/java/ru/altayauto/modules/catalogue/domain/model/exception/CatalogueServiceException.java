package ru.altayauto.modules.catalogue.domain.model.exception;

import ru.altayauto.modules.shared.exception.AltayAutoException;

import java.util.UUID;

public class CatalogueServiceException extends AltayAutoException {
    private CatalogueServiceException(String message) {
        super(message);
    }

    public static class AutoWithUUIDNotFound extends CatalogueServiceException{
        public AutoWithUUIDNotFound(UUID id){
            super("Автомобиль с id "+id.toString()+" не найден.");
        }
    }

    public static class UncompletedCommand extends CatalogueServiceException{
        public UncompletedCommand(){
            super("Невозможно выполнить команду.");
        }
    }
}
