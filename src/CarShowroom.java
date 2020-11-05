import java.util.*;

public class CarShowroom {
    String showroom_name;
    List<Vehicle> vehicle_list;
    int max_capacity;

    CarShowroom(String showroom_name, int max_capacity) {
        this.showroom_name = showroom_name;
        this.max_capacity = max_capacity;
        vehicle_list = new ArrayList<Vehicle>();
    }

    public void addProduct(Vehicle new_vehicle) {
        int comp;

        if (vehicle_list.size() < max_capacity) {
            for (Vehicle vehicle : vehicle_list) {
                comp = new_vehicle.compareTo(vehicle);

                if (comp == 0) 
                    vehicle.amount++;
            }
            
            new_vehicle.amount = vehicle.amount;
            vehicle_list.add(new_vehicle);
            System.out.println("Dodano samochód!");
        }

        else
            System.err.println("Nie można dodać nowego samochodu!");
    }

    public void getProduct(Vehicle vehicle) {
        for (Vehicle v : vehicle_list){
            if (vehicle.compareTo(v) == 0) {
                v.amount--;
            }
        }
        for (Vehicle v : vehicles){
            if (vehicle.compareTo(v) == 0) {
                vehicle_list.remove(v);
                break;
            }
        }
        System.out.println("Pojazd został usunięty!");
    }

    public void removeProduct(String brand, String model) {
        int comp;
        Vehicle remove_vehicle = new Vehicle(brand, model, null, 0, 0, 0, 0);

        for (int i = 0; i < vehicle_list.size(); i++) {
            comp = remove_vehicle.compareTo(vehicle_list.get(i));

            if (comp == 0)
                vehicle_list.remove(i);
        }
    }

    public List<Vehicle> search(String brand, String model) {
        int comp;
        Vehicle search_vehicle = new Vehicle(brand, model, null, 0, 0, 0, 0);
        List<Vehicle> temp_list = new ArrayList<Vehicle>();

        for (Vehicle vehicle : vehicle_list) {
            comp = search_vehicle.compareTo(vehicle);

            if (comp == 0)
                temp_list.add(vehicle);
        }

        return temp_list;
    }

    public List<Vehicle> searchPartial(String name) {
        List<Vehicle> temp_list = new ArrayList<Vehicle>();

        for (Vehicle vehicle : vehicle_list) {
            if (name.contains(vehicle.brand) || name.contains(vehicle.model))
                temp_list.add(vehicle);
        }

        return temp_list;
    }

    public int countByCondition(ItemCondition x) {
        int counter = 0;

        for (Vehicle vehicle : vehicle_list) {
            if (vehicle.condition.equals(x))
                counter++;
        }

        return counter;
    }

    public void summary() {
        for (Vehicle vehicle : vehicle_list) vehicle.print();
    }

    public void sortByName() {
        int change = 1;
        int comp;
        Vehicle temp;

        while (change > 0) {
            change = 0;

            for (int i = 0; i < vehicle_list.size() - 1; i++) {
                comp = vehicle_list.get(i).compareTo(vehicle_list.get(i + 1));

                if (comp > 0) {
                    temp = vehicle_list.get(i + 1);
                    vehicle_list.set(i + 1, vehicle_list.get(i));
                    vehicle_list.set(i, temp);
                    change = 1;
                }
            }
        }
    }

    public void sortByAmount() {
        int change = 1;
        Vehicle temp;

        while (change > 0) {
            change = 0;

            for (int i = 0; i < vehicle_list.size() - 1; i++) {
                if (vehicle_list.get(i).amount > vehicle_list.get(i + 1).amount) {
                    temp = vehicle_list.get(i + 1);
                    vehicle_list.set(i + 1, vehicle_list.get(i));
                    vehicle_list.set(i, temp);
                    change = 1;
                }
            }
        }
    }

    public void max() {
        Collection col = new ArrayList<Object>();

        for (Vehicle vehicle : vehicle_list) col.add(vehicle.amount);

        try {
            int max = (int) Collections.max(col);

            for (int i = 0; i < vehicle_list.size(); i++) {
                if (vehicle_list.get(i).amount == max)
                    vehicle_list.get(i).print();
            }
        }

        catch (ClassCastException | NoSuchElementException e) {
            System.err.println("Exception thrown : " + e);
        }
    }
}
