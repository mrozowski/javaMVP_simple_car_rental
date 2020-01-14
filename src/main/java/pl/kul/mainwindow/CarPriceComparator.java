package pl.kul.mainwindow;

import java.util.Comparator;

class CarPriceComparator implements Comparator<Car_Item> {
    @Override
    public int compare(Car_Item o1, Car_Item o2) {
        return Float.compare(o2.getPrice(), o1.getPrice());

    }
}
