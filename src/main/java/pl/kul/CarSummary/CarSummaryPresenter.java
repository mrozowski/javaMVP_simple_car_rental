package pl.kul.CarSummary;

import javafx.scene.control.DatePicker;
import pl.kul.mainwindow.Car_Item;

import java.time.LocalDate;

public class CarSummaryPresenter {
    private final CarSummaryView view;

    public CarSummaryPresenter(CarSummaryView view) {this.view = view;}

    public void showCarSummary(Car_Item item, DatePicker date1, DatePicker date2){
        CarSummaryDto carSummaryDto = CarSummaryDto.fromCarDto(item, date1, date2);

        view.showCarSummary(carSummaryDto);
    }
}
