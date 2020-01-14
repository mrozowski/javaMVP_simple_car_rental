package pl.kul.carreservation;

import pl.kul.mainwindow.MainWindowPresenter;
import pl.kul.summary.SummaryPresenterFactory;

public class CarReservationPresenterFactory {

    private final SummaryPresenterFactory summaryPresenterFactory;

    public CarReservationPresenterFactory(SummaryPresenterFactory summaryPresenterFactory) {
        this.summaryPresenterFactory = summaryPresenterFactory;
    }

    public CarReservationPresenter create(MainWindowPresenter mainWindowPresenter) {
        CarReservationView carReservationView = new FxCarReservationView();
        CarReservationPresenter presenter = new CarReservationPresenter(carReservationView, mainWindowPresenter, summaryPresenterFactory);
        carReservationView.setPresenter(presenter);

        return presenter;
    }
}
