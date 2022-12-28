package models;

import java.util.List;

public class Payment {
    private List<Order> orders;
    private String customerName;
    private String date;
    private Double cash;
    private Double change;

    

    public Payment(List<Order> orders, String customerName, Double cash, Double change, String date) {
        this.orders = orders;
        this.customerName = customerName;
        this.cash = cash;
        this.change = change;
        this.date = date;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
