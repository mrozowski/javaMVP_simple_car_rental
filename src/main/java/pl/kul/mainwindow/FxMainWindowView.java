package pl.kul.mainwindow;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.List;

class FxMainWindowView implements MainWindowView {
    private final ListView<Car_Item> itemListView;

    private MainWindowPresenter presenter;

    public FxMainWindowView(Pane parent) {

        itemListView = new ListView<>();
        itemListView.setMinHeight(250);   //wysokość głównego okna
        itemListView.setCellFactory(param -> new Car_ItemsList(
                carItem -> presenter.setReservation(carItem),
                carDetails -> presenter.showDetails(carDetails.getId())
        ));

        VBox layout = new VBox();
        VBox header = new VBox();
        Label _text = new Label("Wypozyczalnia samochodow");
        _text.setFont(new Font(24));
        _text.setPadding(new Insets(5));
        header.getChildren().add(_text);

        VBox.setVgrow(layout, Priority.ALWAYS);
        layout.setPadding(new Insets(5));
        layout.setSpacing(10);
        layout.getChildren().add(itemListView);

        parent.getChildren().add(header);
        parent.getChildren().add(layout); //lista pojazdow
    }

    @Override
    public void setPresenter(MainWindowPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayCarItems(List<Car_Item> cars) {
        itemListView.setItems(FXCollections.observableList(cars));
    }
}
