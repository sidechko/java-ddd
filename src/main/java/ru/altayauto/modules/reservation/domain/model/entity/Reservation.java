package ru.altayauto.modules.reservation.domain.model.entity;

import ru.altayauto.modules.reservation.domain.model.exception.ReservationException;
import ru.altayauto.modules.reservation.domain.model.valueobject.Name;
import ru.altayauto.modules.reservation.domain.model.valueobject.PhoneNumber;
import ru.altayauto.modules.reservation.domain.model.valueobject.ReservationStatus;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class Reservation {
    private final UUID id;
    private UUID autoId;
    private LocalDate reservedFrom;
    private LocalDate reservedTo;
    private PhoneNumber reserverPhoneNumber;
    private Name reserverName;
    private ReservationStatus status;

    public Reservation(
            UUID id,
            UUID autoId,
            LocalDate reservedFrom,
            LocalDate reservedTo,
            PhoneNumber reserverPhoneNumber,
            Name reserverName,
            ReservationStatus status
    ) {
        this.id = id;
        this.autoId = autoId;
        if (reservedFrom.isAfter(reservedTo))
            throw new ReservationException.StartDateAfterEndDate();
        this.reservedFrom = reservedFrom;
        this.reservedTo = reservedTo;
        this.reserverPhoneNumber = reserverPhoneNumber;
        this.reserverName = reserverName;
        this.status = status;
    }

    public Reservation approve() {
        if (this.status.isUnmodifiable())
            throw new ReservationException.TryEditVerifiedReservation();
        this.status = ReservationStatus.APPROVED;
        return this;
    }

    public Reservation deny() {
        if (this.status.isUnmodifiable())
            throw new ReservationException.TryEditVerifiedReservation();
        this.status = ReservationStatus.DENIED;
        return this;
    }

    public Reservation startRectification() {
        this.status = ReservationStatus.WAIT_TO_CHECK;
        return this;
    }

    public int getDayCount() {
        return Period.between(reservedFrom, reservedTo).getDays();
    }

    public UUID getId() {
        return id;
    }

    public UUID getAutoId() {
        return this.autoId;
    }

    public void setAutoId(UUID autoId) {
        if (this.status.isUnmodifiable())
            throw new ReservationException.TryEditVerifiedReservation();
        this.autoId = autoId;
    }

    public LocalDate getReservedFrom() {
        return this.reservedFrom;
    }

    public void setReservedFrom(LocalDate reservedFrom) {
        if (this.status.isUnmodifiable())
            throw new ReservationException.TryEditVerifiedReservation();
        this.reservedFrom = reservedFrom;
    }

    public LocalDate getReservedTo() {
        return reservedTo;
    }

    public void setReservedTo(LocalDate reservedTo) {
        if (this.status.isUnmodifiable())
            throw new ReservationException.TryEditVerifiedReservation();
        this.reservedTo = reservedTo;
    }

    public PhoneNumber getReserverPhoneNumber() {
        return this.reserverPhoneNumber;
    }

    public void setReserverPhoneNumber(PhoneNumber reserverPhoneNumber) {
        if (this.status.isUnmodifiable())
            throw new ReservationException.TryEditVerifiedReservation();
        this.reserverPhoneNumber = reserverPhoneNumber;
    }

    public Name getReserverName() {
        return this.reserverName;
    }

    public void setReserverName(Name reserverName) {
        if (this.status.isUnmodifiable())
            throw new ReservationException.TryEditVerifiedReservation();
        this.reserverName = reserverName;
    }
}
