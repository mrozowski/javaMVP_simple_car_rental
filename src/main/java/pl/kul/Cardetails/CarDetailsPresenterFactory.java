package pl.kul.Cardetails;

import pl.kul.mainwindow.MainWindowPresenter;

public class CarDetailsPresenterFactory {


    public CarDetailsPresenter create(MainWindowPresenter mainWindowPresenter) {
        CarDetailsView carDetailsView = new FxCarDetailsView();
        CarDetailsPresenter presenter = new CarDetailsPresenter(carDetailsView);
        carDetailsView.setPresenter(presenter);

        return presenter;
    }
}
