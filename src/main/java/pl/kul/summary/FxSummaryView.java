package pl.kul.summary;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.time.LocalDate;

public class FxSummaryView implements SummaryView {
    private SummaryPresenter presenter;

    @Override
    public void setPresenter(SummaryPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showSummary(String car, LocalDate[] reservation, float price) {
        ColumnConstraints leftColumn = new ColumnConstraints();
        leftColumn.setMinWidth(ColumnConstraints.CONSTRAIN_TO_PREF);
        leftColumn.setHalignment(HPos.RIGHT);

        ColumnConstraints rightColumn = new ColumnConstraints();
        rightColumn.setHgrow(Priority.ALWAYS);

        //okno szczegołów
        GridPane content = new GridPane();
        content.setMinWidth(450);
        content.getColumnConstraints().addAll(leftColumn, rightColumn);
        content.setPadding(new Insets(5));
        content.setHgap(5);
        content.setVgap(5);
        content.addRow(0, new Label("Samochod: "), new Label(car));
        content.addRow(1, new Label("Data: "), new Label(reservation[0].toString() + " - " + reservation[1].toString()));
        content.addRow(2, new Label("Oplata: "), new Label(String.valueOf(presenter.getReservationCost(reservation, price))));
    }
}
