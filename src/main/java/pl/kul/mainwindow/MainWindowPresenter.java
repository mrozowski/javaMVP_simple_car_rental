package pl.kul.mainwindow;

import pl.kul.CarSummary.CarSummaryPresenter;
import pl.kul.CarSummary.CarSummaryPresenterFactory;
import pl.kul.carreservation.CarReservationPresenterFactory;
import pl.kul.Cardetails.CarDetailsPresenterFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class MainWindowPresenter {
    private final Cars cars;
    private final MainWindowView mainWindowView;
    private final CarReservationPresenterFactory carReservationPresenterFactory;
    private final CarDetailsPresenterFactory carDetailsPresenterFactory;


    public MainWindowPresenter(
            Cars cars,
            MainWindowView mainWindowView,
            CarReservationPresenterFactory carReservationPresenterFactory,
            CarDetailsPresenterFactory carDetailsPresenterFactory) {
        this.cars = cars;
        this.mainWindowView = mainWindowView;
        this.carReservationPresenterFactory = carReservationPresenterFactory;
        this.carDetailsPresenterFactory = carDetailsPresenterFactory;


        mainWindowView.displayCarItems(cars.getItems());
        this.sortListByPrice(cars.getItems());
    }
    public void setReservation(Car_Item carItem) {
        carReservationPresenterFactory.create(this)
                .showCarReservationCreator(carItem);
    }

    public void setReservation(UUID id, LocalDate[] date) {
        cars.addReservation(id, date);

    }

    public void sortListByPrice(List<Car_Item> items) {
        List<Car_Item> sortedItems = items.stream()
                .sorted(new CarPriceComparator())
                .collect(Collectors.toList());

        mainWindowView.displayCarItems(sortedItems);
    }


    public void showDetails(UUID id) {
        carDetailsPresenterFactory.create(this)
                .showItemDetails(cars.getItem(id));
    }
}
