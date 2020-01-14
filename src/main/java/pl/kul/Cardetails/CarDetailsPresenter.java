package pl.kul.Cardetails;

import pl.kul.mainwindow.Car_Item;

public class CarDetailsPresenter {
    private final CarDetailsView carDetailsView;

    public CarDetailsPresenter(CarDetailsView carDetailsView) {
        this.carDetailsView = carDetailsView;
    }

    public void showItemDetails(Car_Item carItem) {
        carDetailsView.showItemDetails(new CarDetails(
                carItem.getMarka(),
                carItem.getModel(),
                carItem.getColor(),
                carItem.getFueltype(),
                carItem.getCapacity(),
                carItem.getHp(),
                carItem.getYear(),
                carItem.getPrice()
        ));
    }
}
