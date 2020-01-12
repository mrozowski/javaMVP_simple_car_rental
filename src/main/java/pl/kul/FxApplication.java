package pl.kul;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.kul.mainwindow.MainWindowPresenter;
import pl.kul.mainwindow.MainWindowPresenterFactory;

public class FxApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        MainWindowPresenterFactory mainWindowPresenterFactory = new MainWindowPresenterFactory();
        MainWindowPresenter mainWindowPresenter = mainWindowPresenterFactory.create(primaryStage);
    }
}
