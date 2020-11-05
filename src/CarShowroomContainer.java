import java.util.*;
import java.util.Map.Entry;

public class CarShowroomContainer {
    Map<String, CarShowroom> showrooms;

    CarShowroomContainer() {
        showrooms = new HashMap<String, CarShowroom>();
    }

    public void addCenter(String A, int x) {
        CarShowroom showroom = new CarShowroom(A, x);
        showrooms.put(A, showroom);
        System.out.println("Dodano salon " + A);
    }

    public void removeCenter(String A) {
        showrooms.remove(A);
        System.out.println("Usunięto salon " + A);
    }

    public List<CarShowroom> findEmpty() {
        Set<Entry<String, CarShowroom>> entrySet = showrooms.entrySet();
        List<CarShowroom> list = new ArrayList<CarShowroom>();

        for(Entry<String, CarShowroom> entry: entrySet) {
            if (entry.getValue().vehicle_list.size() == 0)
                list.add(entry.getValue());
        }

        return list;
    }

    public CarShowroom search(String A) {
        Set<Entry<String, CarShowroom>> entrySet = showrooms.entrySet();

        for(Entry<String, CarShowroom> entry: entrySet) {
            if (entry.getKey().equals(A))
                return entry.getValue();
        }

        return null;
    }

    public void summary() {
        Set<Entry<String, CarShowroom>> entrySet = showrooms.entrySet();
        double percent;

        System.out.println("\nNazwa\t:\tWypełnienie");

        for(Entry<String, CarShowroom> entry: entrySet) {
            percent = (double) (entry.getValue().vehicle_list.size() / entry.getValue().max_capacity) * 100;
            System.out.println(entry.getKey() + "\t:\t" + percent + "%");
        }
    }
}
