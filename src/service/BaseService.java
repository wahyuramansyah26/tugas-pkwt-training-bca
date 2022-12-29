package service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

import models.Menu;
import models.Order;
import models.Payment;

public class BaseService {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static Order inputOrder(String label){
        Menu menu = new Menu();
        if(label.equals("food")) {
            Integer noOrderFood = QuestionService.questionInteger("Input nomor pesanan makanan: ") - 1;
            if( noOrderFood >= 0 && noOrderFood < MenuService.getFoodMenu().size()) {
                menu = MenuService.getFoodMenu().get(noOrderFood);
            } else {
                menu = null;
            }
            
        }else if (label.equals("drink")) {
            Integer noOrderDrink = QuestionService.questionInteger("Input nomor pesanan minuman: ") - 1;
            if(noOrderDrink >= 0 && noOrderDrink < MenuService.getDrinkMenu().size()) {
                menu = MenuService.getDrinkMenu().get(noOrderDrink);
            } else {
                menu = null;
            }
        }else if (label.equals("paket")) {
            Integer noOrderPaket = QuestionService.questionInteger("Input nomor pesanan paket: ") - 1;
            if(noOrderPaket >= 0 && noOrderPaket < MenuService.getPaketMenu().size()) {
                menu = MenuService.getPaketMenu().get(noOrderPaket);
            } else {
                menu = null;
            }
        }
        Order order = null;
        if(Objects.nonNull(menu)) {
            Integer qty = QuestionService.questionInteger("Input banyak pesanan: ");
            order = new Order(menu, qty);
        } else {
        }
        return order;
    }

    public static Order editOrder(Order order) {
        Integer newQty = QuestionService.questionInteger("Input kembali banyak pesanan: ");
        order.setQty(newQty);
        return order;
    }

    public static String action() {
        while (true) {
            String option = QuestionService.questionString("Ingin menambah, mengubah atau menghapus pesanan? (tambah/ubah/hapus/kembali): ");
            if (option.equalsIgnoreCase("tambah")) {
                return "tambah";
            } else if (option.equalsIgnoreCase("ubah")) {
                return "ubah";
            } else if (option.equalsIgnoreCase("hapus")) {
                return "hapus";
            } else if (option.equalsIgnoreCase("kembali")) {
                return "kembali";
            } else {
                System.out.println("Silahkan input tambah, ubah, hapus, dan kembali");
                continue;
            }
        }
    }

    public static Payment inputPayment(List<Order> orders, Double price) {
        String customerName = QuestionService.questionString("Input nama customer: ");
        customerName = (customerName.equals("")) ? "-" : customerName;
        Boolean state = true;
        Double cash = 0.;
        Double change = 0.;
        while(state) {
            cash = QuestionService.questionDouble("Input cash: ");
            if(cash < price) {
                System.out.println("Uang yang diberikan tidak mencukupi.");
            }else{
                change = cash - price;
                state = false;
            } 
        }
        LocalDateTime now = LocalDateTime.now(); 
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = now.format(format);
        Payment payment = new Payment(orders, customerName, cash, change, formatDateTime);
        return payment;
    }

}
