package pl.pjatk.shop.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private List<Product> boughtProducts = new ArrayList<>();

    public Customer(int id) {
        this.id = id;
    }

    public List<Product> getBoughtProducts() {
        return boughtProducts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
