package pl.kul.CarSummary;

public class CarSummaryPresenterFactory {
    public CarSummaryPresenter create(){
        CarSummaryView view = new CarSummaryView();
        CarSummaryPresenter presenter = new CarSummaryPresenter(view);
        view.setPresenter(presenter);

        return presenter;
    }
}
