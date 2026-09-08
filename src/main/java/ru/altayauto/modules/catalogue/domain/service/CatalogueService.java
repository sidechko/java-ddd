package ru.altayauto.modules.catalogue.domain.service;

import ru.altayauto.modules.catalogue.domain.model.entity.Auto;
import ru.altayauto.modules.catalogue.domain.model.exception.CatalogueServiceException;
import ru.altayauto.modules.catalogue.domain.model.valueobject.*;
import ru.altayauto.modules.catalogue.domain.repository.IAutoRepository;
import ru.altayauto.modules.catalogue.domain.service.command.CreateNewAutoCommand;
import ru.altayauto.modules.catalogue.domain.service.command.EditAutoImage;
import ru.altayauto.modules.catalogue.domain.service.command.EditAutoInfoCommand;
import ru.altayauto.modules.catalogue.domain.service.command.EditAutoTag;
import ru.altayauto.modules.catalogue.domain.service.query.SearchAutosByInfoQuery;
import ru.altayauto.modules.catalogue.domain.service.query.SearchAutosRangeByInfoQuery;
import ru.altayauto.modules.shared.IGeneratorUUID;
import ru.altayauto.modules.shared.service.IEventPublisher;

import java.math.BigDecimal;
import java.util.*;

public class CatalogueService {
    private final IAutoRepository autoRepository;
    private final IGeneratorUUID generatorUUID;
    private final IEventPublisher eventPublisher;

    public CatalogueService(IAutoRepository repository, IGeneratorUUID generatorUUID, IEventPublisher eventPublisher) {
        this.autoRepository = repository;
        this.generatorUUID = generatorUUID;
        this.eventPublisher = eventPublisher;
    }

    public Auto createAuto(CreateNewAutoCommand command) {
        AutoInfo autoInfo = new AutoInfo(
                command.producer(),
                command.model(),
                command.transmission(),
                command.engineVolume(),
                command.enginePower()
        );
        Auto newAuto = new Auto(
                generatorUUID.generate(),
                command.governmentRegistrationNumber(),
                autoInfo,
                command.description()
        );
        autoRepository.save(newAuto);
        return newAuto;
    }

    public Auto editAutoInfo(EditAutoInfoCommand command) {
        if (command.isEmpty())
            throw new CatalogueServiceException.UncompletedCommand();
        Auto editableAuto = autoRepository.findById(command.id());
        if (editableAuto == null)
            throw new CatalogueServiceException.AutoWithUUIDNotFound(command.id());
        boolean edited = false;
        if (command.governmentRegistrationNumber() != null) {
            editableAuto.changeGovernmentRegistrationNumber(
                    command.governmentRegistrationNumber()
            );
            edited = true;
        }
        if (command.description() != null) {
            editableAuto.changeDescription(command.description());
            edited = true;
        }
        //INFO
        editableAuto.editInfo(command.buildFrom(editableAuto.getInfo()));
        if (edited)
            autoRepository.save(editableAuto);
        return editableAuto;
    }

    public List<Auto> searchAuto(SearchAutosByInfoQuery query) {
        PositiveDecimalWithHundredths maxPower = query.maxEnginePower() == null ?
                autoRepository.getMaxEnginePower() : query.maxEnginePower();
        PositiveDecimalWithHundredths maxVolume = query.maxEngineVolume() == null ?
                autoRepository.getMaxEngineVolume() : query.maxEngineVolume();
        return autoRepository.search(
                query.producers(),
                query.models(),
                query.transmissions(),
                query.minEngineVolume() == null ? new PositiveDecimalWithHundredths(new BigDecimal(0)) : query.minEngineVolume(),
                query.minEnginePower() == null ? new PositiveDecimalWithHundredths(new BigDecimal(0)) : query.minEnginePower(),
                maxVolume,
                maxPower
        );
    }

    public List<Auto> searchRangeAuto(SearchAutosRangeByInfoQuery query) {
        PositiveDecimalWithHundredths maxPower = query.maxEnginePower() == null ?
                autoRepository.getMaxEnginePower() : query.maxEnginePower();
        PositiveDecimalWithHundredths maxVolume = query.maxEngineVolume() == null ?
                autoRepository.getMaxEngineVolume() : query.maxEngineVolume();
        return autoRepository.searchRange(
                query.producers(),
                query.models(),
                query.transmissions(),
                query.minEngineVolume() == null ? new PositiveDecimalWithHundredths(new BigDecimal(0)) : query.minEngineVolume(),
                query.minEnginePower() == null ? new PositiveDecimalWithHundredths(new BigDecimal(0)) : query.minEnginePower(),
                maxVolume,
                maxPower,
                query.size(),
                query.offset()
        );
    }

    public List<Tag> getAvailableTags() {
        return autoRepository.getAvailableTags();
    }

    public Auto editAutoTag(EditAutoTag command) {
        Auto auto = autoRepository.findById(command.autoId());
        if (auto == null)
            throw new CatalogueServiceException.AutoWithUUIDNotFound(command.autoId());

        if (!command.delete())
            auto.addTag(command.tag());
        else
            auto.removeTag(command.tag());

        autoRepository.save(auto);
        return auto;
    }

    public Set<ImagePath> getAutoImages(UUID id) {
        Auto auto = autoRepository.findById(id);
        if (auto == null)
            throw new CatalogueServiceException.AutoWithUUIDNotFound(id);
        return auto.getImages();
    }

    public Auto editAutoImages(EditAutoImage command) {
        Auto auto = autoRepository.findById(command.autoId());
        if (auto == null)
            throw new CatalogueServiceException.AutoWithUUIDNotFound(command.autoId());

        if (!command.delete())
            auto.addImage(command.imagePath());
        else
            auto.removeImage(command.imagePath());

        autoRepository.save(auto);
        return auto;
    }
}
