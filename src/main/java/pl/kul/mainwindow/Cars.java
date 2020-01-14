package pl.kul.mainwindow;



import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private final Map<UUID, Car_Item> items;

    public Cars(List<Car_Item> items) {
        this.items = items.stream()
                .collect(
                        LinkedHashMap::new,
                        (map, itemDto) -> map.put(itemDto.getId(), itemDto),
                        HashMap::putAll
                );
    }

    public List<Car_Item> getItems() {
        return items.values()
                .stream()
                .collect(Collectors.toUnmodifiableList());
    }

    public void addReservation(UUID id, LocalDate[] date) {
        if (date == null || date.length != 2) {
            throw new NullPointerException("Data nie może być pusta");
        }
        else if(date[0].equals(LocalDate.MIN) || date[1].equals(LocalDate.MIN)){
            throw new NullPointerException("Nie podano pelnej daty");
        }
        //druga data nie moze być mniejsza niż piersza
        if((date[1].compareTo(date[0]))<0){
            throw new NullPointerException("Data oddania nie moze być wczesniejsza od daty wypozyczenia");
        }

        Car_Item itemToUpdate = Optional.ofNullable(items.get(id))
                .orElseThrow(() -> new IllegalStateException(String.format("Nie ma takiego samochodu %s", id)));

        itemToUpdate.getReservation().add(date[0]);
        itemToUpdate.getReservation().add(date[1]);
    }

    public Car_Item getItem(UUID id) {
        return Optional.ofNullable(items.get(id))
                .orElseThrow(() -> new IllegalStateException(String.format("There is no item with id of %s", id)));
    }

}

