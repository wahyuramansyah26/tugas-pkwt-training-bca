package repository;

import java.util.ArrayList;
import java.util.List;

import models.Payment;
import service.DaoService;

public class PaymentRepository implements DaoService<Payment, Integer>{
    List<Payment> payments = new ArrayList<>();

    @Override
    public List<Payment> findAll() {
        // TODO Auto-generated method stub
        return payments;
    }

    @Override
    public Payment findById(Integer id) {
        // TODO Auto-generated method stub
        int size = payments.size();
        if (size <= 0 || size < id) {
            return null;
        } else {
            return payments.get(id - 1);
        }
    }

    @Override
    public void save(Payment data) {
        // TODO Auto-generated method stub
        payments.add(data);
    }

    @Override
    public void update(Payment data, Integer id) {
        // TODO Auto-generated method stub
        payments.set(id-1, data);
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        payments.remove(id-1);
    }
    
}
