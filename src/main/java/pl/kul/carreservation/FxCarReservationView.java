package pl.kul.carreservation;

import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import pl.kul.mainwindow.Car_Item;

import java.time.LocalDate;

class FxCarReservationView implements CarReservationView {
    private CarReservationPresenter presenter;
    private ListView<Car_Item> abc;
    @Override
    public void setPresenter(CarReservationPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showCreator(Car_Item carItem) {
        DatePicker datePicker = new DatePicker();
        DatePicker datePicker2 = new DatePicker();



        ColumnConstraints leftColumn = new ColumnConstraints();
        leftColumn.setMinWidth(ColumnConstraints.CONSTRAIN_TO_PREF);
        leftColumn.setHalignment(HPos.RIGHT);

        ColumnConstraints rightColumn = new ColumnConstraints();
        rightColumn.setHgrow(Priority.ALWAYS);

        GridPane content = new GridPane();
        content.getColumnConstraints().addAll(leftColumn, rightColumn);
        content.setPadding(new Insets(5));
        content.setHgap(5);
        content.setVgap(5);


        VBox summaryLabelLayout = new VBox(new Label("Od kiedy:"));
        summaryLabelLayout.setAlignment(Pos.TOP_RIGHT);
        VBox summaryLabelLayout2 = new VBox(new Label("Do kiedy:"));
        summaryLabelLayout.setAlignment(Pos.TOP_RIGHT);

        content.addRow(0, summaryLabelLayout, datePicker);
        content.addRow(1, summaryLabelLayout2, datePicker2);

        Dialog<CarReservation> itemDialog = new Dialog<>();
        itemDialog.setTitle("Zarezerwuj");
        itemDialog.getDialogPane().setContent(content);
        itemDialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        itemDialog.setResultConverter(buttonPressed -> (buttonPressed == ButtonType.OK)
                ? new CarReservation(carItem.getId(), datePicker.getValue(), datePicker2.getValue()) //obsluga rezerwacji
                : null);

        itemDialog.getDialogPane().lookupButton(ButtonType.OK).addEventFilter(ActionEvent.ACTION, event -> {
            String errorMessage = null;

            if(datePicker.getValue() == null || datePicker2.getValue() == null){
                errorMessage = "Podaj wszystkie daty";
            }

            else if (datePicker.getValue().compareTo(datePicker2.getValue()) > 0) {
                errorMessage = "Data oddania nie moze byc wczesniejsza \nod daty wypozyczenia";
            }

            else if (datePicker.getValue().isBefore(LocalDate.now())){
                errorMessage = "Podano nie wlasciwa date";
            }

            //sprawdzenie czy podana data nie jest zajeta : true - zajeta
            else if(presenter.checkReservationAvailability(carItem.getReservation(), datePicker.getValue(), datePicker2.getValue())){
                errorMessage = "Przepraszamy podana data jest juz zajeta :(";

            }

            //jesli pojawil sie blad
            if (errorMessage != null) {
                event.consume();

                new Alert(Alert.AlertType.ERROR, errorMessage, ButtonType.OK)
                        .showAndWait();
            }


        });

        itemDialog.showAndWait()
                .ifPresent(carReservation -> presenter.addReservation(carReservation));
    }


}