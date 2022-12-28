package controller;

import repository.OrderRepository;
import service.BaseService;
import service.order.OrderService;
import service.order.OrderServiceImpl;

public class OrderController {
    private OrderService orderService;

    public OrderController(OrderRepository orderRepository) {
        this.orderService = new OrderServiceImpl(orderRepository);
    }

    public void addOrder(String label) {
        Boolean state = true;
        String act = "tambah";
        while(state) {
            if(act.equals("tambah")) {
                orderService.addOrder(label);
                orderService.showOrder();
                act = BaseService.action();
            } else if (act.equals("ubah")) {
                orderService.updateOrder();
                orderService.showOrder();
                act = BaseService.action();
            } else if (act.equals("hapus")) {
                orderService.removeOrder();
                orderService.showOrder();
                act = BaseService.action();
            } else if (act.equals("kembali")) {
                state = false;
            }
        }
        
    }

}