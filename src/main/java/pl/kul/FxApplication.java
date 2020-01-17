package pl.kul;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.kul.carreservation.CarReservationPresenterFactory;
import pl.kul.mainwindow.Cars;
import pl.kul.mainwindow.MainWindowPresenterFactory;
import pl.kul.Cardetails.CarDetailsPresenterFactory;
import pl.kul.mainwindow.Car_Item;
import pl.kul.summary.SummaryPresenterFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class FxApplication extends Application {
    @Override
    public void start(Stage primaryStage){
        Pane rootLayout = new VBox();
        Scene scene = new Scene(rootLayout);
        // List<Car_Item> items;

        //okno z podsumowaniem - do zrobienia


        //items = getCarsFromFile(); //pobranie listy samochodow z pliku

        List<Car_Item> items = new LinkedList<>(List.of(
                new Car_Item(UUID.randomUUID(), "Fiat ", "Panda ", "czerwony", "benzyna ", 1.2f, 69, 2008, 12.5f)
                // kolejne samochody
        ));
        SummaryPresenterFactory summaryPresenterFactory = new SummaryPresenterFactory();
        Cars cars = new Cars(items);

        // Presenters & views
        MainWindowPresenterFactory mainWindowPresenterFactory = new MainWindowPresenterFactory(
                rootLayout,
                new CarReservationPresenterFactory(summaryPresenterFactory),
                new CarDetailsPresenterFactory()
                //summaryPresenterFactory
        );

        mainWindowPresenterFactory.create(cars);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //metoda pobierania samochodow z pliku
    private List<Car_Item> getCarsFromFile() {
        List<Car_Item> temp = new LinkedList<>();

        Scanner plik = null;
        try {
            plik = new Scanner(new File("CarsFile.txt"));

            while ((plik.hasNextLine())) {
                String id = plik.next();
                String marka = plik.next();
                String model = plik.next();
                String color = plik.next();
                String fuel = plik.next();
                float capacity = plik.nextFloat();
                int hp = plik.nextInt();
                int year = plik.nextInt();
                float price = plik.nextFloat();

                temp.add(new Car_Item(UUID.fromString(id), marka, model, color, fuel, capacity, hp, year, price));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        temp.add(new Car_Item(UUID.fromString("1"), "Honda","Accord", "Czerwony", "ropa", 1.2f, 90, 2005, 10.5f));
        return temp;
    }
}