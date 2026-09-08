package ru.altayauto.modules.catalogue.domain.service.command;

import org.jspecify.annotations.NonNull;
import ru.altayauto.modules.catalogue.domain.model.valueobject.Tag;
import ru.altayauto.modules.shared.service.ICommand;

import java.util.UUID;

/** @param delete if true, command for remove tag, else command for append tag */
public record EditAutoTag (
        @NonNull UUID autoId,
        @NonNull Tag tag,
        boolean delete
) implements ICommand {
    @Override
    public String getName() {
        return "EditAutoTag";
    }
}
