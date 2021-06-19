package com.aor.refactoring.example3;

public class SimpleOrder {
    private Discount discount;
    private double price;

    public SimpleOrder(double price, Discount discount) {
        this.price = price;
        this.discount=discount;
    }

    public double getTotal() {
        return discount.applyDiscount(price);
    }
}
