package pl.kul.mainwindow;

import javafx.scene.layout.Pane;
import pl.kul.Cardetails.CarDetailsPresenterFactory;
import pl.kul.carreservation.CarReservationPresenterFactory;

public class MainWindowPresenterFactory {
    private final Pane rootLayout;
    private final CarReservationPresenterFactory carReservationPresenterFactory;
    private final CarDetailsPresenterFactory carDetailsPresenterFactory;
   // private final SummaryPresenterFactory summaryPresenterFactory;

    public MainWindowPresenterFactory(Pane rootLayout, CarReservationPresenterFactory carReservationPresenterFactory, CarDetailsPresenterFactory carDetailsPresenterFactory ) {
        this.rootLayout = rootLayout;
        this.carReservationPresenterFactory = carReservationPresenterFactory;
        this.carDetailsPresenterFactory = carDetailsPresenterFactory;
        //summarywindow
       // this.summaryPresenterFactory = summaryPresenterFactory;
    }

    public MainWindowPresenter create(Cars cars) {
        MainWindowView mainWindowView = new FxMainWindowView(rootLayout);
        MainWindowPresenter presenter = new MainWindowPresenter(cars, mainWindowView, carReservationPresenterFactory, carDetailsPresenterFactory);
        mainWindowView.setPresenter(presenter);

        return presenter;
    }
}
