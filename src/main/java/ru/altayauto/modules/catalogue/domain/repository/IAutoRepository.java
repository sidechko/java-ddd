package ru.altayauto.modules.catalogue.domain.repository;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import ru.altayauto.modules.catalogue.domain.model.entity.Auto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface IAutoRepository {
    Auto findById(@NonNull UUID id);
    List<Auto> search(
            @Nullable String[] producer,
            @Nullable String[] model,
            @Nullable String[] transmission,
            @Nullable BigDecimal minEngineVolume,
            @Nullable BigDecimal minEnginePower,
            @Nullable BigDecimal maxEngineVolume,
            @Nullable BigDecimal maxEnginePower
    );
    List<Auto> getAll();
    List<Auto> getRange(int size, int offset);
    void save(@NonNull Auto auto);
    void delete(@NonNull Auto auto);
}
