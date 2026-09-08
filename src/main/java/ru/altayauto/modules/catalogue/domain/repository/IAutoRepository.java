package ru.altayauto.modules.catalogue.domain.repository;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import ru.altayauto.modules.catalogue.domain.model.entity.Auto;
import ru.altayauto.modules.catalogue.domain.model.valueobject.PositiveDecimalWithHundredths;
import ru.altayauto.modules.catalogue.domain.model.valueobject.Tag;
import ru.altayauto.modules.catalogue.domain.model.valueobject.Title;

import java.util.List;
import java.util.UUID;

public interface IAutoRepository {
    @Nullable
    Auto findById(@NonNull UUID id);
    int getCount();

    @NonNull
    List<Auto> search(
            @Nullable Title[] producer,
            @Nullable Title[] model,
            @Nullable Title[] transmission,
            @Nullable PositiveDecimalWithHundredths minEngineVolume,
            @Nullable PositiveDecimalWithHundredths minEnginePower,
            @Nullable PositiveDecimalWithHundredths maxEngineVolume,
            @Nullable PositiveDecimalWithHundredths maxEnginePower
    );
    @NonNull
    List<Auto> getAll();

    @NonNull
    List<Auto> searchRange(
            @Nullable Title[] producer,
            @Nullable Title[] model,
            @Nullable Title[] transmission,
            @Nullable PositiveDecimalWithHundredths minEngineVolume,
            @Nullable PositiveDecimalWithHundredths minEnginePower,
            @Nullable PositiveDecimalWithHundredths maxEngineVolume,
            @Nullable PositiveDecimalWithHundredths maxEnginePower,
            int size,
            int offset
    );
    @NonNull
    List<Auto> getRange(int size, int offset);

    @NonNull
    List<Tag> getAvailableTags();
    @NonNull
    PositiveDecimalWithHundredths getMaxEnginePower();
    @NonNull
    PositiveDecimalWithHundredths getMaxEngineVolume();

    void save(@NonNull Auto auto);
    void delete(@NonNull Auto auto);
}
