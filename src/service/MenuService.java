package service;

import java.util.ArrayList;
import java.util.List;

import models.Menu;

public class MenuService {
    private static List<Menu> foodMenu = new ArrayList<>() {{
        add(new Menu("Nasi Putih", 3000.));
        add(new Menu("Ayam Goreng", 12000.));
        add(new Menu("Ayam Bakar", 14000.));
        add(new Menu("Bebek Goreng", 20000.));
        add(new Menu("Bebek Bakar", 22000.));
        add(new Menu("Tahu", 2000.));
        add(new Menu("Tempe", 2000.));
        add(new Menu("Nasi Goreng Biasa", 15000.));
        add(new Menu("Nasi Goreng Special", 20000.));
    }};
    private static List<Menu> drinkMenu = new ArrayList<>() {{
        add(new Menu("Air Mineral", 5000.));
        add(new Menu("Es Teh", 5000.));
        add(new Menu("Es Jeruk", 7000.));
        add(new Menu("Jus Alpukat", 10000.));
        add(new Menu("Jus Mangga", 10000.));
        add(new Menu("Kopi Hitam", 8000.));
    }};
    private static List<Menu> paketMenu = new ArrayList<>() {{
        add(new Menu("Paket A : Nasi Putih + Ayam Goreng/Bakar + Sambal + Jus", 25000.));
        add(new Menu("Paket B : Nasi Putih + Bebek Goreng/Bakar + Sambal + Jus", 33000.));
        add(new Menu("Paket C : Nasi Putih + Ayam Goreng/Bakar + Sambal + Tahu + Tempe + Es Teh", 24000.));
        add(new Menu("Paket D : Nasi Putih + Bebek Goreng/Bakar + Sambal + Tahu + Tempe + Es Teh", 32000.));
    }};

    public static void showAllMenu(){
        showFoodMenu();
        showDrinkMenu();
        showPaketMenu();
    }

    public static void showFoodMenu(){
        System.out.println("===== MAKANAN =====");
        Integer iterasi =  1;
        for (Menu menu : foodMenu) {
            System.out.println(iterasi + ". " + menu.getName() + " - " + menu.getPrice());
            iterasi++;
        }
        System.out.println();
    }

    public static void showDrinkMenu(){
        System.out.println("===== MINUMAN =====");
        Integer iterasi =  1;
        for (Menu menu : drinkMenu) {
            System.out.println(iterasi + ". " + menu.getName() + " - " + menu.getPrice());
            iterasi++;
        }
        System.out.println();
    }

    public static void showPaketMenu(){
        System.out.println("===== PAKET =====");
        Integer iterasi =  1;
        for (Menu menu : paketMenu) {
            System.out.println(iterasi + ". " + menu.getName() + " - " + menu.getPrice());
            iterasi++;
        }
        System.out.println();
    }

    public static List<Menu> getFoodMenu() {
        return foodMenu;
    }

    public static List<Menu> getDrinkMenu() {
        return drinkMenu;
    }

    public static List<Menu> getPaketMenu() {
        return paketMenu;
    }

    
    
}
