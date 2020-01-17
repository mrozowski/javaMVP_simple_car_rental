package pl.kul.carreservation;

import java.time.LocalDate;

import java.util.UUID;

class CarReservation {
    private final UUID id;
    private final LocalDate reservationDate_start;
    private final LocalDate reservationDate_finish;

    public CarReservation(UUID id, LocalDate date, LocalDate date2) {
        this.id = id;
        this.reservationDate_start = date;
        this.reservationDate_finish = date2;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getReservationDate_start() {
        return reservationDate_start;
    }

    public LocalDate getReservationDate_finish() {
        return reservationDate_finish;
    }

    public LocalDate[] getReservation() {
        return new LocalDate[]{this.reservationDate_start, this.reservationDate_finish};
    }
}
