package ru.altayauto.modules.reservation.domain.model.valueobject;

public enum ReservationStatus {
    WAIT_TO_CHECK,
    APPROVED,
    DENIED;

    public boolean isUnmodifiable(){
        return this != WAIT_TO_CHECK;
    }
}
