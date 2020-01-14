package pl.kul.summary;

import pl.kul.carreservation.CarReservationPresenter;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class SummaryPresenter {
    private final SummaryView summaryView;
    private final CarReservationPresenter carReservationPresenter;

    public SummaryPresenter(SummaryView summaryView, CarReservationPresenter carReservationPresenter) {
        this.summaryView = summaryView;
        this.carReservationPresenter = carReservationPresenter;
    }

    public void showSummary(String car, LocalDate[] reservation, float price){
        summaryView.showSummary(car, reservation, price);
    }

    public float getReservationCost(LocalDate[] reservation, float price) {
        long days = ChronoUnit.DAYS.between(reservation[0], reservation[1]);
        return (float)(price * 24 * 0.80) * days; // price - cena za godzine. Cena za dobe to cena_za_godzine * 24 - 20%
    }
}
