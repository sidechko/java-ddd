package ru.altayauto.modules.shared.exception;

public class EmptyStringValue extends AltayAutoException {
    public EmptyStringValue(String valueName) {
        super("Значение обязано присутствовать. "+valueName);
    }
}
