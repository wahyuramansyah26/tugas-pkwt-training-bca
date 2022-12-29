package service.order;

import java.util.List;
import java.util.Objects;

import models.Order;
import repository.OrderRepository;
import service.BaseService;
import service.QuestionService;

public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void addOrder(String label) {
        // TODO Auto-generated method stub
        Order orderSave = new Order();
        orderSave = BaseService.inputOrder(label);
        if (Objects.nonNull(orderSave)) {
            orderRepository.save(orderSave);
        } else {
            System.out.println("Menu tidak tersedia");
        }
        
    }

    @Override
    public void removeOrder() {
        // TODO Auto-generated method stub
        Integer idData = QuestionService.questionInteger("Masukkan no pesanan yang ingin dihapus: ");
        Order o = orderRepository.findById(idData);
        if (Objects.nonNull(o)) {
            orderRepository.delete(idData);
        } else {
            System.out.println("Pesanan tidak ditemukan.");
        }
    }

    @Override
    public void updateOrder() {
        // TODO Auto-generated method stub
        Integer idData = QuestionService.questionInteger("Masukkan no pesanan yang ingin diubah: ");
        Order o = orderRepository.findById(idData);
        if (Objects.nonNull(o)) {
            o = BaseService.editOrder(o);
            orderRepository.update(o, idData);
        } else {
            System.out.println("Pesanan tidak ditemukan.");
        }
    }

    @Override
    public void showOrder() {
        // TODO Auto-generated method stub
        List<Order> orders = orderRepository.findAll();
        System.out.println("=== PESANAN ===");
        Integer iterasi = 1;
        Double totalPrice = 0.;
        for (Order order : orders) {
            System.out.println(iterasi + ".\t" + order.getMenu().getName());
            System.out.println("\t" + order.getQty() + " x " + order.getMenu().getPrice() + ": " + (order.getQty()*order.getMenu().getPrice()) );
            totalPrice = totalPrice + (order.getMenu().getPrice() * order.getQty());
            iterasi++;
        }
        Double priceAfterPpn = ((11 * totalPrice)/100) + totalPrice;

        System.out.println("Total harga setelah PPN (11%) : " + priceAfterPpn);
        
    }

}
