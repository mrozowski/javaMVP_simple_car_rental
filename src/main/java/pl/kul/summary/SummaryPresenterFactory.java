package pl.kul.summary;

import pl.kul.carreservation.CarReservationPresenter;

public class SummaryPresenterFactory {

    public SummaryPresenter create(CarReservationPresenter carReservationPresenter){
        SummaryView summaryView = new FxSummaryView();
        SummaryPresenter presenter = new SummaryPresenter(summaryView, carReservationPresenter);
        summaryView.setPresenter(presenter);

        return presenter;
    }
}
