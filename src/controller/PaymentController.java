package controller;

import repository.OrderRepository;
import repository.PaymentRepository;
import service.payment.PaymentService;
import service.payment.PaymentServiceImpl;

public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.paymentService = new PaymentServiceImpl(orderRepository, paymentRepository);
    }

    public void paymentReceipt(){
        paymentService.paymentReceipt();
    }
}
