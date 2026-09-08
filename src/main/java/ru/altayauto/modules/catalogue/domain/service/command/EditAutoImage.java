package ru.altayauto.modules.catalogue.domain.service.command;

import org.jspecify.annotations.NonNull;
import ru.altayauto.modules.catalogue.domain.model.valueobject.ImagePath;
import ru.altayauto.modules.shared.service.ICommand;

import java.util.UUID;

/** @param delete if true, command for remove image, else command for append image */
public record EditAutoImage(
        @NonNull UUID autoId,
        @NonNull ImagePath imagePath,
        boolean delete
) implements ICommand {
    @Override
    public String getName() {
        return "EditAutoImage";
    }
}
