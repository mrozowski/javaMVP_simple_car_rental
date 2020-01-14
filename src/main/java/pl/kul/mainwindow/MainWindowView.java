package pl.kul.mainwindow;

import java.util.List;

public interface MainWindowView {
    void setPresenter(MainWindowPresenter presenter);

    void displayCarItems(List<Car_Item> cars);
}
