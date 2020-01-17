package pl.kul.mainwindow;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Car_Item {

    private final UUID id;
    private final String marka;
    private final String model;
    private final String color;
    private final String fueltype;       //benzyna, ropa, gaz, elektryk
    private final float capacity;        //pojemnosc silnika
    private final int hp;                //horse power
    private final int year;              //rocznik
    private final float price;           // cena za godzine
    private List<LocalDate> reservation; //daty rezerwacji samochodu

    public Car_Item(UUID id, String marka, String model, String color, String fueltype, float capacity, int hp, int year, float price) {
        this.id = UUID.fromString(String.valueOf(id));
        this.marka = marka;
        this.model = model;
        this.color = color;
        this.fueltype = fueltype;
        this.capacity = capacity;
        this.hp = hp;
        this.year = year;
        this.price = price;
        reservation = new LinkedList<>(); // kazda rezerwacja zuzywa 2 miejsca data wypzyczenia - data oddania
    }

    public UUID getId() {
        return id;
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public String getFueltype() {
        return fueltype;
    }

    public float getCapacity() {
        return capacity;
    }

    public int getHp() {
        return hp;
    }

    public List<LocalDate> getReservation() {
        return reservation;
    }


    @Override
    public String toString() {
        return getMarka() + " " + getModel() + " " + getPrice() + "zl/h";
    }
}
