package pl.kul.carreservation;

import pl.kul.mainwindow.MainWindowPresenter;


public class CarReservationPresenterFactory {


    public CarReservationPresenter create(MainWindowPresenter mainWindowPresenter) {
        CarReservationView carReservationView = new FxCarReservationView();
        CarReservationPresenter presenter = new CarReservationPresenter(carReservationView, mainWindowPresenter);
        carReservationView.setPresenter(presenter);

        return presenter;
    }
}
