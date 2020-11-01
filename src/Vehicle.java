public class Vehicle implements Comparable<Vehicle> {
    String brand, model;
    ItemCondition condition;
    double price, mileage, engine_capacity;
    int year, amount;

    Vehicle(String brand,
            String model,
            ItemCondition condition,
            double price,
            int year,
            double mileage,
            double engine_capacity)
    {
        this.brand = brand;
        this.model = model;
        this.condition = condition;
        this.price = price;
        this.year = year;
        this.mileage = mileage;
        this.engine_capacity = engine_capacity;
        amount = 1;
    }

    public void print() {
        System.out.println("Marka: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Stan: " + condition);
        System.out.println("Cena(PLN): " + price);
        System.out.println("Rok produkcji: " + year);
        System.out.println("Przebieg: " + mileage);
        System.out.println("Pojemność silnika(dm3): " + engine_capacity);
         System.out.println("Ilość: " + amount + "\n");
    }

    public int compareTo(Vehicle o) {
        int result = CharSequence.compare(brand, o.brand);

        if (result == 0)
            result = CharSequence.compare(model, o.model);

        return result;
    }
}