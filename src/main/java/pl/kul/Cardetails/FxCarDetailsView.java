package pl.kul.Cardetails;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

class FxCarDetailsView implements CarDetailsView {
    //private CarDetailsPresenter presenter;

    @Override
    public void setPresenter(CarDetailsPresenter presenter) {
       // this.presenter = presenter;
    }

    @Override
    public void showItemDetails(CarDetails carDetails) {
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
        content.addRow(0, new Label("Samochod:"), new Label(carDetails.getMarka() + " " + carDetails.getModel()));
        content.addRow(1, new Label("Rocznik"), new Label(String.valueOf(carDetails.getYear())));
        content.addRow(2, new Label("Kolor:"), new Label(carDetails.getColor()));
        content.addRow(3, new Label("Silnik:"), new Label(carDetails.getCapacity() + "L  "
                        + carDetails.getHp() + "KM  " + carDetails.getFueltype()));
        content.addRow(4, new Label("Cena za godzine:"), new Label(String.valueOf(carDetails.getPrice() + "PLN")));
        content.addRow(5, new Label("Cena za dobe:"), new Label(String.valueOf(carDetails.getDayPrice() + "PLN")));


        VBox summaryLabelLayout = new VBox(new Label("Detale:"));
        summaryLabelLayout.setAlignment(Pos.TOP_RIGHT);


        Dialog<CarDetails> itemDialog = new Dialog<>();
        itemDialog.setTitle("Szczegoly samochodu");
//
        itemDialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        itemDialog.getDialogPane().setContent(content);

        itemDialog.show();
    }
}