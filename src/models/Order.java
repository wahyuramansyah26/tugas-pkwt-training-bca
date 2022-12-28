package models;

public class Order {
    private Menu menu;
    private Integer qty;

    public Order() {
    }

    
    public Order(Menu menu, Integer qty) {
        this.menu = menu;
        this.qty = qty;
    }

    public Menu getMenu() {
        return menu;
    }


    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
    public Integer getQty() {
        return qty;
    }
    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public void showOrder() {
        System.out.println(menu.getName());
        System.out.println(getQty() + " x " + menu.getPrice() + ": " + getQty()*menu.getPrice() );
        System.out.println();
    }

}
