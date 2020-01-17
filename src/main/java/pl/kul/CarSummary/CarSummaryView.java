package pl.kul.CarSummary;

import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CarSummaryView {
    private CarSummaryPresenter presenter;

    public void setPresenter(CarSummaryPresenter presenter) {this.presenter = presenter;}


    public void showCarSummary(CarSummaryDto carSummaryDto){
        GridPane gridPane = new GridPane();
        gridPane.minWidth(450);
        gridPane.setMinWidth(350);
        gridPane.setPadding(new Insets(5));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        gridPane.addRow(0, new Label("Dane auta:"), new Label(carSummaryDto.getMarka() + carSummaryDto.getModel() + carSummaryDto.getRocznik() + " rok."));
        gridPane.addRow(1, new Label("Koszt wypożyczenia: "), new Label(String.valueOf((carSummaryDto.getKoszt()*24*0.80) + "zł/dzień")));
        gridPane.addRow(2, new Label("Okres wypożyczenia od: "), new Label(carSummaryDto.getOd() + " do " + carSummaryDto.getD_o()));
        gridPane.addRow(3, new Label("Koszt rezerwacji za " + carSummaryDto.getDays() + "dni:"), new Label(String.valueOf(carSummaryDto.getR1())));

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Podsumowanie rezerwacji");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK);
        dialog.getDialogPane().setContent(gridPane);
        dialog.show();
    }
}
