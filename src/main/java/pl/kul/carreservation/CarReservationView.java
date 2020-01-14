package pl.kul.carreservation;

import pl.kul.mainwindow.Car_Item;

public interface CarReservationView {
    void setPresenter(CarReservationPresenter presenter);

    void showCreator(Car_Item carItem);
}
