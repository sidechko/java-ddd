package ru.altayauto.modules.catalogue.domain.service.command;

import org.jspecify.annotations.NonNull;

import java.math.BigDecimal;

public record CreateNewAutoCommand(
        @NonNull String governmentRegistrationNumber,
        @NonNull String description,
        @NonNull String producer,
        @NonNull String model,
        @NonNull String transmission,
        @NonNull BigDecimal engineVolume,
        @NonNull BigDecimal enginePower
) {}
