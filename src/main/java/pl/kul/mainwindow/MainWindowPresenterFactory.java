package pl.kul.mainwindow;

import javafx.stage.Stage;

public class MainWindowPresenterFactory {
    public MainWindowPresenter create(Stage primaryStage) {
        MainWindowView view = new MainWindowView(primaryStage);
        MainWindowPresenter presenter = new MainWindowPresenter(view);

        view.setPresenter(presenter);

        return presenter;
    }
}
