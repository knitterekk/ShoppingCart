package org.example;

import org.springframework.stereotype.Component;

@Component
public class ShopRuner {
    private final CartService cartService;

    public ShopRuner(CartService cartService) {
        this.cartService = cartService;
    }

    public CartService getCartService() {
        return cartService;
    }

}


