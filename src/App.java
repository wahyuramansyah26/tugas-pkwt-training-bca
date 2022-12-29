import java.util.Scanner;

import controller.OrderController;
import controller.PaymentController;
import repository.OrderRepository;
import repository.PaymentRepository;
import service.BaseService;
import service.MenuService;

public class App {
    static Scanner input = new Scanner(System.in);
    static String opsi;
    static OrderRepository orderRepository = new OrderRepository();
    static OrderController orderController = new OrderController(orderRepository);
    static PaymentRepository paymentRepository = new PaymentRepository();
    static PaymentController paymentController = new PaymentController(orderRepository, paymentRepository);

    private static void menuApp() {
        System.out.println("======= RUMAH MAKAN =======");
        System.out.println("1. Lihat Daftar Menu");
        System.out.println("2. Pemesanan");
        System.out.println("3. Pembayaran");
        System.out.println("9. Keluar Aplikasi");
        System.out.print("Pilihan: ");
        opsi = input.nextLine();
    }

    private static void orderMenu() {
        System.out.println("======= PESAN =======");
        System.out.println("1. Makanan");
        System.out.println("2. Minuman");
        System.out.println("3. Paket");
        System.out.print("Pilihan: ");
        opsi = input.nextLine();
    }
    public static void main(String[] args) throws Exception {
        Boolean state = true;
        do {
            menuApp();
            switch (opsi) {
                case "1":
                    BaseService.clearScreen();
                    MenuService.showAllMenu();
                    break;

                case "2":
                    BaseService.clearScreen();
                    orderMenu();
                    switch (opsi) {
                        case "1":
                            MenuService.showFoodMenu();
                            orderController.addOrder("food");
                            break;

                        case "2":
                            MenuService.showDrinkMenu();
                            orderController.addOrder("drink");
                            break;

                        case "3":
                            MenuService.showPaketMenu();
                            orderController.addOrder("paket");
                            break;

                        default:
                            break;
                    }

                    
                    break;

                case "3":
                    paymentController.paymentReceipt();
                    break;

                case "9":
                    state= false;
                    break;
            
                default:
                    break;
            }
            
        } while (state);
        
    }
}
