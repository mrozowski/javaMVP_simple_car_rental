package pl.kul.mainwindow;

import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
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
            Text CarName = new Text(item.toString());
            CarName.setOnMouseClicked(event -> {
                if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2) {
                    onTitleClicked.accept(item);
                }
            });

            //mozna  dodac w tym miejscu guzik wybierz
            Label tickLabel = new Label("\u039e");

            tickLabel.setFont(new Font(tickLabel.getFont().getName(), 32));

            tickLabel.setVisible(true);
            //tickLabel.setMinSize(40,40);
            tickLabel.setOnMouseClicked(event -> {
                    onTickClicked.accept(item);
            });

            //pojedyczny item listy
            GridPane itemGrid = new GridPane();
            GridPane.setHgrow(itemGrid, Priority.ALWAYS);
            itemGrid.addRow(

                    itemGrid.getRowCount(),
                    CarName,
                    tickLabel
            );

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
