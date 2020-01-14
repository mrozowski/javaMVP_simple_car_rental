package pl.kul.carreservation;

import pl.kul.mainwindow.Car_Item;
import pl.kul.mainwindow.MainWindowPresenter;
import pl.kul.summary.SummaryPresenterFactory;

import java.time.LocalDate;
import java.util.List;

public class CarReservationPresenter {
    private final CarReservationView carReservationView;
    private final MainWindowPresenter mainWindowPresenter;
    private final SummaryPresenterFactory summaryPresenterFactory;

    public CarReservationPresenter(CarReservationView carReservationView, MainWindowPresenter mainWindowPresenter, SummaryPresenterFactory summaryPresenterFactory) {
        this.carReservationView = carReservationView;
        this.mainWindowPresenter = mainWindowPresenter;
        this.summaryPresenterFactory = summaryPresenterFactory;
    }


    public void showCarReservationCreator(Car_Item carItem) {
        carReservationView.showCreator(carItem);
    }

    public void addReservation(CarReservation carReservation) {
        mainWindowPresenter.setReservation(carReservation.getId(), carReservation.getReservation());
    }

    public void showSummaryOfReservation(String car, LocalDate[] reservation, float price){
        System.out.println("showSummaryofReservation");
        summaryPresenterFactory.create(this)
                .showSummary(car, reservation, price);
    }

    boolean checkReservationAvailability(List<LocalDate> reservation, LocalDate value, LocalDate value1) {
        LocalDate borrow, toReturn;

        if(reservation.contains(value) || reservation.contains(value1)) return true; // data rezerwacji jest zajeta

        for (int i=0; i<reservation.size(); i+=2){
            borrow = reservation.get(i);
            toReturn = reservation.get(i+1);
            if(borrow.isBefore(value) && toReturn.isAfter(value)) return true;
            else if(borrow.isBefore(value1) && toReturn.isAfter(value1)) return true;
            else if(borrow.isAfter(value) && toReturn.isBefore(value1)) return true;
        }

        return false;
    }
}
