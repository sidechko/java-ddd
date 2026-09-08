package ru.altayauto.modules.reservation.domain.model.exception;

import ru.altayauto.modules.shared.exception.AltayAutoException;

public class ReservationException extends AltayAutoException {

    private ReservationException(String message){
        super(message);
    }

    public static class StartDateAfterEndDate extends ReservationException {
        public StartDateAfterEndDate(){
            super("Дата начала бронирования не может быть позже даты конца аренды.");
        }
    }

    public static class TryEditVerifiedReservation extends ReservationException{
        public TryEditVerifiedReservation(){
            super("Нельзя изменять заявки, которые уже были обработаны.");
        }
    }
}
