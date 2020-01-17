package pl.kul.CarSummary;

import javafx.scene.control.DatePicker;
import pl.kul.mainwindow.Car_Item;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class CarSummaryDto {


    private final String Marka;
    private final String Model;
    private final int Rocznik;
    private final float Koszt;
    private final float r1;
    private final long days;
    private final LocalDate od;
    private final LocalDate d_o;


    public CarSummaryDto(String Marka, String Model, int Rocznik, float Koszt, float r1, long days, LocalDate od, LocalDate d_o){
        this.Marka = Marka;
        this.Model = Model;
        this.Rocznik = Rocznik;
        this.Koszt = Koszt;
        this.r1 = r1;
        this.days = days;
        this.od = od;
        this.d_o = d_o;
    }

    public static CarSummaryDto fromCarDto(Car_Item item, DatePicker date1, DatePicker date2) {
        String Marka = item.getMarka();
        String Model = item.getModel();
        int Rocznik = item.getYear();
        float Koszt = item.getPrice();

        LocalDate od = date1.getValue();
        LocalDate d_o = date2.getValue();

        long days = ChronoUnit.DAYS.between(od, d_o);
        float r1 = (float) ((Koszt * 24 * 0.80) * days);

        return new CarSummaryDto(Marka, Model, Rocznik, Koszt, r1, days, od, d_o);
    }

    public String getMarka() {
        return Marka;
    }

    public String getModel() {
        return Model;
    }

    public int getRocznik() {
        return Rocznik;
    }

    public float getKoszt() {
        return Koszt;
    }

    public float getR1() {
        return r1;
    }

    public long getDays() {
        return days;
    }

    public LocalDate getOd() {
        return od;
    }

    public LocalDate getD_o() {
        return d_o;
    }
}
