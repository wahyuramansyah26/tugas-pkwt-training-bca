package service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
            menu = MenuService.getFoodMenu().get((QuestionService.questionInteger("Input nomor pesanan makanan: ")) - 1);
        }else if (label.equals("drink")) {
            menu = MenuService.getDrinkMenu().get((QuestionService.questionInteger("Input nomor pesanan minuman: ")) - 1);
        }else if (label.equals("paket")) {
            menu = MenuService.getPaketMenu().get((QuestionService.questionInteger("Input nomor pesanan paket: ")) - 1);
        }
        
        Integer qty = QuestionService.questionInteger("Input banyak pesanan: ");
        Order order = new Order(menu, qty);
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
