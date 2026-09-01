package ru.altayauto.modules.catalogue.domain.service;

import ru.altayauto.modules.catalogue.domain.repository.IAutoRepository;
import ru.altayauto.modules.shared.IGeneratorUUID;

public class CatalogueService {
    private final IAutoRepository autoRepository;
    private final IGeneratorUUID generatorUUID;

    public CatalogueService(IAutoRepository repository, IGeneratorUUID generatorUUID){
        this.autoRepository = repository;
        this.generatorUUID = generatorUUID;
    }


}
