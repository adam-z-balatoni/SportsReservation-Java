package hu.elte.sportfoglalas.application.exception;

public class ReservationNotFoundException extends Throwable {
    public ReservationNotFoundException(String message) {
        super(message);
    }
}
