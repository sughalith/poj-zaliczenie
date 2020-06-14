package pl.pjatk.shop.model;

import pl.pjatk.shop.validator.ShopName;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private int id;
    @ShopName
    private String name;
    private List<Product> availableProducts = new ArrayList<>();
    private List<Product> soldProducts = new ArrayList<>();

    public Shop(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Product> getAvailableProducts() {
        return availableProducts;
    }

    public void setAvailableProducts(List<Product> availableProducts) {
        this.availableProducts = availableProducts;
    }

    public List<Product> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<Product> soldProducts) {
        this.soldProducts = soldProducts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
