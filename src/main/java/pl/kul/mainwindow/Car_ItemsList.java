package pl.kul.mainwindow;

import javafx.geometry.HPos;

import javafx.geometry.Pos;
import javafx.scene.control.Button;

import javafx.scene.control.ListCell;

import javafx.scene.layout.*;

import javafx.scene.text.Text;

import java.util.function.Consumer;

class Car_ItemsList extends ListCell<Car_Item> {
    private final Consumer<Car_Item> onTickClicked;
    private final Consumer<Car_Item> onTitleClicked;

    public Car_ItemsList(Consumer<Car_Item> onTickClicked, Consumer<Car_Item> onTitleClicked) {
        this.onTickClicked = onTickClicked;
        this.onTitleClicked = onTitleClicked;

    }

    @Override
    protected void updateItem(Car_Item item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {

            Text marka = new Text(item.getMarka());
            Text model = new Text(item.getModel());
            Text price = new Text(item.getPrice()+ "PLN/h ");


            Button rezervation_button = new Button("Rezerwacja");

            rezervation_button.setVisible(true);
            rezervation_button.setStyle("-fx-background-color: #2e8b57; -fx-text-fill: #ffffff;" +
                    " -fx-font-weight: bold; -fx-cursor: hand;");

            rezervation_button.setMinSize(55,35);
            rezervation_button.setOnMouseClicked(event ->{
                onTickClicked.accept(item);
            });

            Button details_button = new Button("Wiecej");
            details_button.setStyle("-fx-background-color: #edfa8e; -fx-cursor: hand;");
            details_button.setVisible(true);
            details_button.setMinSize(45,35);
            details_button.setOnMouseClicked(event ->{
                onTitleClicked.accept(item);
            });


            //pojedyczny item listy
            GridPane itemGrid = new GridPane();
            GridPane.setHgrow(itemGrid, Priority.ALWAYS);
            itemGrid.setAlignment(Pos.BOTTOM_LEFT);
            // itemGrid.
            itemGrid.addColumn(itemGrid.getColumnCount(), marka );
            itemGrid.addColumn(itemGrid.getColumnCount(), model);
            itemGrid.addColumn(itemGrid.getColumnCount(), price);
            itemGrid.addColumn(itemGrid.getColumnCount(), details_button);
            itemGrid.addColumn(itemGrid.getColumnCount(), rezervation_button);
            itemGrid.getColumnConstraints().addAll(new ColumnConstraints(70), new ColumnConstraints(65));


            ColumnConstraints titleColumn = new ColumnConstraints();
            titleColumn.setHgrow(Priority.ALWAYS);
            titleColumn.setHalignment(HPos.LEFT);

            ColumnConstraints buttonsColumn = new ColumnConstraints();
            buttonsColumn.setHalignment(HPos.RIGHT);

            itemGrid.getColumnConstraints()
                    .addAll(titleColumn, buttonsColumn);

            setGraphic(itemGrid);
        }
    }
}
