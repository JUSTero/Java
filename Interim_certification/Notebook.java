// 1. Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.

// 2. Создать множество ноутбуков.

// 3. Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:

// 4. “Введите цифру, соответствующую необходимому критерию:

// 1 - ОЗУ

// 2 - Объём ЖД

// 3 - Операционная система

// 4 - Цвет …

// Далее нужно запросить минимальные значения для указанных критериев — сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

package Interim_certification;

import java.util.*;

public class Notebook {
    private String brand;
    private String model;
    private int ram;
    private int hdd;
    private String os;
    private String color;
    private double price;
    private boolean isAvailable;

    public Notebook(String brand, String model, int ram, int hdd, String os, String color, double price,
            boolean isAvailable) {
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return brand + " " + model + " (" + os + ", " + ram + " ГБ ОЗУ, " + hdd + " ГБ ЖД, " + color + ", " + price
                + " руб., " + (isAvailable ? "в наличии" : "нет в наличии") + ")";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook("HP", "Spectre x360", 8, 512, "Windows_10", "Gray", 999.99, true));
        notebooks.add(new Notebook("Apple", "MacBook Pro", 16, 256, "macOS", "Gray space", 1999.99, true));
        notebooks.add(new Notebook("Lenovo", "ThinkPad X1 Carbon", 16, 1, "Windows_10", "Black", 1499.99, false));
        notebooks.add(new Notebook("ASUS", "ZenBook Flip S UX371", 16, 512, "Windows_10", "Blue", 1499.99, true));
        notebooks.add(new Notebook("Dell", "XPS 13", 16, 512, "Windows_10", "White", 1799.99, true));
        notebooks.add(new Notebook("Acer", "ConceptD 7 Ezel", 32, 1024, "Windows_10", "Beige", 3999.99, true));
        notebooks.add(new Notebook("MSI", "GS65 Stealth Thin", 16, 512, "Windows_10", "Black", 1499.99, true));

        Map<String, Object> filters = new HashMap<>();

        System.out.println("Введите номер критерия фильтрации:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объём ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        System.out.println("5 - Цена до");
        System.out.println("6 - Наличие");

        int criterion = scanner.nextInt();

        switch (criterion) {
            case 1:
                System.out.println("Введите минимальный объём ОЗУ (ГБ):");
                int minRam = scanner.nextInt();
                filters.put("ram", minRam);
                break;
            case 2:
                System.out.println("Введите минимальный объём ЖД (ГБ):");
                int minHdd = scanner.nextInt();
                filters.put("hdd", minHdd);
                break;
            case 3:
                System.out.println("Введите название операционной системы:");
                String os = scanner.next();
                filters.put("os", os);
                break;
            case 4:
                System.out.println("Введите цвет ноутбука:");
                String color = scanner.next();
                filters.put("color", color);
                break;
            case 5:
                System.out.println("Введите максимальную цену (руб.):");
                double maxPrice = scanner.nextDouble();
                filters.put("price", maxPrice);
                break;
            case 6:
                System.out.println("Смотреть только наличие? (true/false):");
                boolean isAvailable = scanner.nextBoolean();
                filters.put("isAvailable", isAvailable);
                break;
            default:
                System.out.println("Неверный номер критерия фильтрации.");
                scanner.close();
                return;
        }

        Set<Notebook> filteredNotebooks = filterNotebooks(notebooks, filters);

        System.out.println("Результаты фильтрации:");
        for (Notebook notebook : filteredNotebooks) {
            System.out.println(notebook.toString());
        }

        scanner.close();
    }

    public static Set<Notebook> filterNotebooks(Set<Notebook> notebooks, Map<String,

            Object> filters) {
        Set<Notebook> filteredNotebooks = new HashSet<>();

        for (Notebook notebook : notebooks) {
            boolean isMatching = true;

            for (String key : filters.keySet()) {
                Object value = filters.get(key);

                if (!checkNotebook(notebook, key, value)) {
                    isMatching = false;
                    break;
                }
            }

            if (isMatching) {
                filteredNotebooks.add(notebook);
            }
        }

        return filteredNotebooks;
    }

    public static boolean checkNotebook(Notebook notebook, String key, Object value) {
        switch (key) {
            case "ram":
                return notebook.getRam() >= (int) value;
            case "hdd":
                return notebook.getHdd() >= (int) value;
            case "os":
                return notebook.getOs().equals((String) value);
            case "color":
                return notebook.getColor().equals((String) value);
            case "price":
                return notebook.getPrice() <= (double) value;
            case "isAvailable":
                return notebook.isAvailable() == (boolean) value;
            default:
                throw new IllegalArgumentException("Неизвестный критерий фильтрации: " + key);
        }
    }
}