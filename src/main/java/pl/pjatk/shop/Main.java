package pl.pjatk.shop;

import pl.pjatk.shop.model.Customer;
import pl.pjatk.shop.model.Product;
import pl.pjatk.shop.model.Shop;
import pl.pjatk.shop.service.ShopService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop(1, "Nikeds1");
        Product product = new Product(1, "Buty", BigDecimal.TEN);
        Product product2 = new Product(2, "Buty", BigDecimal.TEN);
        Product product3 = new Product(3, "Buty", BigDecimal.TEN);
        Customer customer = new Customer(1);
        ShopService shopService = new ShopService(shop);

        shop.getAvailableProducts().add(product);
        shop.getAvailableProducts().add(product2);
        shop.getAvailableProducts().add(product3);

        shopService.sellProduct(1, customer);
        shopService.sellProduct(2, customer);
        shopService.sellProduct(3, customer);
        System.out.println(shopService.getSoldProductsReport());
        List<Product> products = shopService.returnProduct(1, customer);
        System.out.println(products);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Shop>> violations = validator.validate(shop);
        System.out.println("Violations: " + violations);

    }
}
