package ru.altayauto.modules.catalogue.domain.model.valueobject;

import org.jspecify.annotations.NonNull;
import ru.altayauto.modules.catalogue.domain.model.exception.GovernmentRegistrationNumberException;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;

public record GovernmentRegistrationNumber(@NonNull String value) {
    private static final HashSet<Character> ALLOWED_SET = new HashSet<>(
            Arrays.asList('A', 'B', 'E', 'K', 'M', 'H', 'O', 'P', 'C', 'T', 'Y', 'X')
    );

    public GovernmentRegistrationNumber {
        if (value.isEmpty())
            throw new GovernmentRegistrationNumberException.ValueIsEmptyException();
        if (value.length() > 9 || value.length() < 8)
            throw new GovernmentRegistrationNumberException.ValueNotMatchedSizeException();
        if (!ALLOWED_SET.contains(value.charAt(0)) || !ALLOWED_SET.contains(value.charAt(4)) || !ALLOWED_SET.contains(value.charAt(5)))
            throw new GovernmentRegistrationNumberException.InvalidCharExceptionException();
        try {
            Integer.parseInt(value.substring(1, 4));
            Integer.parseInt(value.substring(6));
        } catch (NumberFormatException ignore) {
            throw new GovernmentRegistrationNumberException.InvalidCharExceptionException();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj==null || this.getClass() != obj.getClass()) return false;
        return ((GovernmentRegistrationNumber)obj).value.equals(this.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
