package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // ... (uruchomienie kontekstu bez zmian)
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

// 1. Pierwszy "klient" bierze koszyk i wrzuca Mleko
        CartService cart1 = context.getBean(CartService.class);
        cart1.addProduct(new Product("Mleko", 3.50));

// 2. Drugi "klient" bierze koszyk i wrzuca Chleb
        CartService cart2 = context.getBean(CartService.class);
        cart2.addProduct(new Product("Chleb", 4.20));

// 3. Sprawdzamy, co mają w koszykach
        System.out.println("Koszyk 1: " + cart1.getProducts());
        System.out.println("Koszyk 2: " + cart2.getProducts());

        System.out.println("Cena w koszyku 1 (netto): " + cart1.getTotalPrice());
        System.out.println("Cena w koszyku 1 (brutto): " + cart1.getTotalPriceWithVAT());

    }
}