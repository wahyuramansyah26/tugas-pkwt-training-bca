package repository;

import java.util.ArrayList;
import java.util.List;

import models.Order;
import service.DaoService;

public class OrderRepository implements DaoService<Order, Integer> {
    List<Order> orders = new ArrayList<>();

    @Override
    public List<Order> findAll() {
        // TODO Auto-generated method stub
        return orders;
    }

    @Override
    public Order findById(Integer id) {
        // TODO Auto-generated method stub
        int size = orders.size();
        if (size <= 0 || size < id) {
            return null;
        } else {
            return orders.get(id - 1);
        }
    }

    @Override
    public void save(Order data) {
        // TODO Auto-generated method stub
        orders.add(data);
    }

    @Override
    public void update(Order data, Integer id) {
        // TODO Auto-generated method stub
        orders.set(id-1, data);
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        orders.remove(id-1);
    }

    public void deleteAll() {
        orders.clear();
    }
    
}
