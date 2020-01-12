package pl.kul.mainwindow;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindowView {
    private MainWindowPresenter presenter;

    public MainWindowView(Stage stage) {
        MenuItem runMenuItem = new MenuItem("Menu...");
        runMenuItem.setOnAction(event -> presenter.openWindow());

        MenuBar menuBar = new MenuBar(
                new Menu("New item", null,
                        runMenuItem
                )
        );

        VBox layout = new VBox();
        layout.setPadding(new Insets(10));
        layout.setSpacing(10);
        layout.getChildren().addAll(
                new Label("Hello world!")
        );

        Pane root = new VBox();
        root.getChildren().addAll(
                menuBar,
                layout
        );

        stage.setScene(new Scene(root));
        stage.show();
    }

    public void setPresenter(MainWindowPresenter presenter) {
        this.presenter = presenter;
    }
}
