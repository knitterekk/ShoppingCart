package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope("prototype")
public class CartService {
    private List<Product> products;
    private static final double VAT_RATE = 0.23;

    public CartService() {
        this.products = new ArrayList<>();
    }
    public void addProduct(Product product) {
        products.add(product);
    }
    public List<Product> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public double getTotalPriceWithVAT() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice() * (1 + VAT_RATE);
        }
        return total;
    }
}
