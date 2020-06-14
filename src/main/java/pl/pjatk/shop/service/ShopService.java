package pl.pjatk.shop.service;

import pl.pjatk.shop.model.Customer;
import pl.pjatk.shop.model.Product;
import pl.pjatk.shop.model.Shop;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class ShopService {

    private final Shop shop;

    public ShopService(Shop shop) {
        this.shop = shop;
    }

    public List<Product> sellProduct(int productId, Customer customer) {
        Optional<Product> productInShop = findProductInShop(productId);
        productInShop.ifPresent(product -> {
            transferProduct(product);
            customer.getBoughtProducts().add(product);
        });
        return customer.getBoughtProducts();
    }

    private Optional<Product> findProductInShop(int productId) {
        return shop.getAvailableProducts().stream().filter(product -> product.getId() == productId).findFirst();
    }

    private void transferProduct(Product product) {
        shop.getAvailableProducts().remove(product);
        shop.getSoldProducts().add(product);
    }

    public BigDecimal getSoldProductsReport() {
        return shop.getSoldProducts().stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Product> returnProduct(int productId, Customer customer) {
        Product product = findProductInCustomer(productId, customer);
        shop.getSoldProducts().remove(product);
        shop.getAvailableProducts().add(product);
        customer.getBoughtProducts().remove(product);
        return shop.getAvailableProducts();
    }

    private Product findProductInCustomer(int productId, Customer customer) {
        return customer.getBoughtProducts().stream().filter(prod -> prod.getId() == productId).findFirst().get();
    }


}
