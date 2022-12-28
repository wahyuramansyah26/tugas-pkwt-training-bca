package service.payment;

import java.util.List;

import models.Order;
import models.Payment;
import repository.OrderRepository;
import repository.PaymentRepository;
import service.BaseService;

public class PaymentServiceImpl implements PaymentService {
    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public PaymentServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void paymentReceipt() {
        // TODO Auto-generated method stub
        List<Order> orders = orderRepository.findAll();
        if (orders.size() >= 1) {
            Double totalPrice = 0.;
            for (Order order : orders) {
                totalPrice = totalPrice + order.getMenu().getPrice() * order.getQty();
            }
            Double pricePpn = 11 * totalPrice / 100;
            Double priceAfterPpn = pricePpn + totalPrice;
            Payment payment = BaseService.inputPayment(orders, priceAfterPpn);
            paymentRepository.save(payment);

            System.out.println("======= BUKTI PEMBAYARAN =======");
            System.out.println("Tanggal : " + payment.getDate());
            System.out.println("Nama Customer : " + payment.getCustomerName());

            System.out.println("====== PESANAN ======");
            Integer iterasi = 1;
            for (Order order : payment.getOrders()) {
                System.out.println(iterasi + ".\t" + order.getMenu().getName());
                System.out.println("\t" + order.getQty() + " x " + order.getMenu().getPrice() + ": "
                        + (order.getQty() * order.getMenu().getPrice()));
                iterasi++;
            }
            System.out.println("Total harga setelah PPN (11%) : " + priceAfterPpn);
            System.out.println("Total harga : " + totalPrice);
            System.out.println("Biaya PPN (11%) : " + pricePpn);
            System.out.println("Total Harga Pembelian : " + totalPrice);
            System.out.println("Uang tunai : " + payment.getCash());
            System.out.println("Kembalian : " + payment.getChange());
            System.out.println("Terima kasih sudah makan disini.");
            orderRepository.deleteAll();
        } else {
            System.out.println("Belum ada pemesanan");
        }

    }

}
