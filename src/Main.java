import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        CarShowroomContainer container = new CarShowroomContainer();
        Vehicle vehicle;
        List<Vehicle> search_vehicle;
        ItemCondition condition;
        String brand, model, name;
        double price, mileage, engine_capacity;
        int capacity, year;
        char c1, c2, c3, c4;
        boolean bool = true;

        while (bool) {
            while (true) {
                System.out.println("\nMenu:");
                System.out.println("[1] Dodaj salon samochodowy");
                System.out.println("[2] Przeglądaj salony samochodowe");
                System.out.println("[0] Wyjdź z programu");

                c1 = scan.next().charAt(0);

                if (c1 == '1' || c1 == '2' || c1 == '3' || c1 == '0') break;

                else
                    System.err.println("Błąd! Ponów wybór!");
            }

            switch (c1) {
                case '1' -> {
                    System.out.print("\nPodaj nazwę salonu: ");
                    name = scan.next();
                    while (true) {
                        try {
                            System.out.print("Podaj pojemność salonu: ");
                            capacity = scan.nextInt();
                            container.addCenter(name, capacity);
                            break;
                        }

                        catch (InputMismatchException exception) {}
                        scan.nextLine();
                    }

                    while (true) {
                        System.out.println("\n[1] Dodaj samochody do nowego salonu");
                        System.out.println("[0] Powrót do menu głównego");

                        c2 = scan.next().charAt(0);

                        if (c2 == '1' || c2 == '0') break;

                        else
                            System.err.println("Błąd! Ponów wybór!");
                    }

                    switch (c2) {
                        case '1':
                            do {
                                System.out.print("\nMarka: ");
                                brand = scan.next();
                                System.out.print("Model: ");
                                model = scan.next();

                                while (true) {
                                    System.out.println("Stan:\n\t[1] Nowy\n\t[2] Używany\n\t[3] Powypadkowy");
                                    int s = scan.nextInt();

                                    if (s == 1) {
                                        condition = ItemCondition.NEW;
                                        break;
                                    } else if (s == 2) {
                                        condition = ItemCondition.USED;
                                        break;
                                    } else if (s == 3) {
                                        condition = ItemCondition.DAMAGED;
                                        break;
                                    } else
                                        System.err.println("Błąd! Ponów wybór!\n");
                                }

                                while (true) {
                                    try {
                                        System.out.print("Cena: ");
                                        price = scan.nextDouble();
                                        System.out.print("Rok produkcji: ");
                                        year = scan.nextInt();
                                        System.out.print("Przebieg: ");
                                        mileage = scan.nextDouble();
                                        System.out.print("Pojemność silnika: ");
                                        engine_capacity = scan.nextDouble();

                                        vehicle = new Vehicle(brand, model, condition, price, year, mileage, engine_capacity);
                                        container.showrooms.get(name).addProduct(vehicle);
                                        vehicle = null;
                                        break;
                                    }

                                    catch (InputMismatchException exception) {}
                                    scan.nextLine();
                                }

                                while (true) {
                                    System.out.println("\n[1] Dodaj kolejny pojazd do nowego salonu");
                                    System.out.println("[0] Powrót do menu głównego");

                                    c3 = scan.next().charAt(0);

                                    if (c3 == '1' || c3 == '0') break;

                                    else
                                        System.err.println("Błąd! Ponów wybór!");
                                }
                            } while (c3 == '1');
                            break;

                        case '0':
                            break;
                    }
                }

                case '2' -> {
                    container.summary();
                    while (true) {
                        System.out.println("\n[1] Wybierz salon samochodowy");
                        System.out.println("[0] Powrót do menu głównego");

                        c2 = scan.next().charAt(0);

                        if (c2 == '1' || c2 == '0') break;

                        else
                            System.err.println("Błąd! Ponów wybór!");
                    }

                    switch (c2) {
                        case '1' -> {
                            System.out.print("Salon: ");
                            String choice = scan.next();
                            CarShowroom find_showroom = container.search(choice);
                            if (find_showroom == null) {
                                System.err.println("Nie ma takiego salonu!");
                                break;
                            }

                            while (true) {
                                System.out.println("\n[1] Dodaj nowy pojazd do salonu");
                                System.out.println("[2] Usuń pojazd z salonu");
                                System.out.println("[3] Usuń salon");
                                System.out.println("[4] Wyświetl wszystkie pojazdy");
                                System.out.println("[5] Wyszukaj po nazwie");
                                System.out.println("[6] Wyszukaj po frazie");
                                System.out.println("[7] Lista pojazdów, których jest najwięcej");
                                System.out.println("[8] Ilość pojazdów o określonym stanie");
                                System.out.println("[9] Posortuj listę pojazdów");
                                System.out.println("[0] Powrót do menu głównego");

                                c3 = scan.next().charAt(0);

                                if (c3 == '1') {
                                    do {
                                        System.out.print("\nMarka: ");
                                        brand = scan.next();
                                        System.out.print("Model: ");
                                        model = scan.next();

                                        while (true) {
                                            System.out.println("Stan:\n\t[1] Nowy\n\t[2] Używany\n\t[3] Powypadkowy");
                                            int s = scan.nextInt();

                                            if (s == 1) {
                                                condition = ItemCondition.NEW;
                                                break;
                                            } else if (s == 2) {
                                                condition = ItemCondition.USED;
                                                break;
                                            } else if (s == 3) {
                                                condition = ItemCondition.DAMAGED;
                                                break;
                                            } else
                                                System.err.println("Błąd! Ponów wybór!\n");
                                        }

                                        while (true) {
                                            try {
                                                System.out.print("Cena: ");
                                                price = scan.nextDouble();
                                                System.out.print("Rok produkcji: ");
                                                year = scan.nextInt();
                                                System.out.print("Przebieg: ");
                                                mileage = scan.nextDouble();
                                                System.out.print("Pojemność silnika: ");
                                                engine_capacity = scan.nextDouble();

                                                vehicle = new Vehicle(brand, model, condition, price, year, mileage, engine_capacity);
                                                container.showrooms.get(choice).addProduct(vehicle);
                                                vehicle = null;
                                                break;
                                            }

                                            catch (InputMismatchException exception) {}
                                            scan.nextLine();
                                        }

                                        while (true) {
                                            System.out.println("\n[1] Dodaj kolejny pojazd do salonu");
                                            System.out.println("[0] Powrót");

                                            c4 = scan.next().charAt(0);

                                            if (c4 == '1' || c4 == '0') break;

                                            else
                                                System.err.println("Błąd! Ponów wybór!");
                                        }
                                    } while (c4 == '1');

                                }

                                else if (c3 == '2') {
                                    do {
                                        while (true) {
                                            System.out.println("\n[1] Usuń wszystkie pojzady o podanej nazwie");
                                            System.out.println("[2] Usuń jeden pojazd o podanej nazwie");

                                            c4 = scan.next().charAt(0);

                                            if (c4 == '1') {
                                                System.out.print("\nMarka: ");
                                                brand = scan.next();
                                                System.out.print("Model: ");
                                                model = scan.next();

                                                container.showrooms.get(choice).getProduct(brand, model);
                                                break;
                                            }

                                            else if (c4 == '2') {
                                                System.out.print("\nMarka: ");
                                                brand = scan.next();
                                                System.out.print("Model: ");
                                                model = scan.next();

                                                container.showrooms.get(choice).removeProduct(brand, model);
                                                break;
                                            }

                                            else
                                                System.err.println("Błąd! Ponów wybór!");
                                        }

                                        while (true) {
                                            System.out.println("\n[1] Usuń kolejny pojzad");
                                            System.out.println("[0] Powrót");

                                            c4 = scan.next().charAt(0);

                                            if (c4 == '1' || c4 == '0') break;

                                            else
                                                System.err.println("Błąd! Ponów wybór!");
                                        }
                                    } while (c4 == '1');
                                }

                                else if (c3 == '3') {
                                    container.removeCenter(choice);
                                    break;
                                }

                                else if (c3 == '4')
                                    container.showrooms.get(choice).summary();

                                else if (c3 == '5') {
                                    System.out.print("\nMarka: ");
                                    brand = scan.next();
                                    System.out.print("Model: ");
                                    model = scan.next();

                                    search_vehicle = container.showrooms.get(choice).search(brand, model);

                                    if (search_vehicle.isEmpty())
                                        System.err.println("Brak wyników");

                                    else
                                        for (Vehicle v : search_vehicle) v.print();

                                    search_vehicle = null;
                                }

                                else if (c3 == '6') {
                                    System.out.println("Wpisz frazę: ");
                                    String phrase = scan.next();

                                    search_vehicle = container.showrooms.get(choice).searchPartial(phrase);

                                    if (search_vehicle.isEmpty())
                                        System.err.println("Brak wyników");

                                    else
                                        for (Vehicle v : search_vehicle) v.print();

                                    search_vehicle = null;
                                }

                                else if (c3 == '7')
                                    container.showrooms.get(choice).max();

                                else if (c3 == '8') {
                                    while (true) {
                                        System.out.println("Stan:\n\t[1] Nowy\n\t[2] Używany\n\t[3] Powypadkowy");
                                        int s = scan.nextInt();

                                        if (s == 1) {
                                            condition = ItemCondition.NEW;
                                            break;
                                        } else if (s == 2) {
                                            condition = ItemCondition.USED;
                                            break;
                                        } else if (s == 3) {
                                            condition = ItemCondition.DAMAGED;
                                            break;
                                        } else
                                            System.err.println("Błąd! Ponów wybór!\n");
                                    }

                                    int amount = container.showrooms.get(choice).countByCondition(condition);
                                    System.out.println("Ilość: " + amount);
                                }

                                else if (c3 == '9') {
                                    while (true) {
                                        System.out.println("\n[1] Sortowanie alfabetyczne");
                                        System.out.println("[2] Sortowanie względem ilości");

                                        c4 = scan.next().charAt(0);

                                        if (c4 == '1' || c4 == '2') break;

                                        else
                                            System.err.println("Błąd! Ponów wybór!");
                                    }

                                    switch (c4) {
                                        case '1' -> container.showrooms.get(choice).sortByName();
                                        case '2' -> container.showrooms.get(choice).sortByAmount();
                                    }

                                    System.out.println("Lista pojazdów została posortowana");
                                }

                                else if (c3 == '0') break;

                                else
                                    System.err.println("Błąd! Ponów wybór!");
                            }
                        }
                    }
                }
                case '0' -> bool = false;
            }
        }
    }
}