package ru.altayauto.modules.catalogue.domain.service.query;

import org.jspecify.annotations.Nullable;
import ru.altayauto.modules.catalogue.domain.model.valueobject.PositiveDecimalWithHundredths;
import ru.altayauto.modules.catalogue.domain.model.valueobject.Tag;
import ru.altayauto.modules.catalogue.domain.model.valueobject.Title;
import ru.altayauto.modules.shared.service.ICommand;

public record SearchAutosRangeByInfoQuery(
        @Nullable Title[] producers,
        @Nullable Title[] models,
        @Nullable Title[] transmissions,
        @Nullable PositiveDecimalWithHundredths minEngineVolume,
        @Nullable PositiveDecimalWithHundredths minEnginePower,
        @Nullable PositiveDecimalWithHundredths maxEngineVolume,
        @Nullable PositiveDecimalWithHundredths maxEnginePower,
        @Nullable Tag[] tags,
        int size,
        int offset
) implements ICommand {
    @Override
    public String getName() {
        return "SearchAutosRangeByInfoQuery";
    }
}
