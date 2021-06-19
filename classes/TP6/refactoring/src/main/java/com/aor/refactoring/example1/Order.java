package com.aor.refactoring.example1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderLine> lines;
    private double total;

    public Order() {
        lines = new ArrayList<>();
        total = 0.0;
    }

    public void add(Product product, int quantity) {
        OrderLine o=new OrderLine(product, quantity);
        lines.add(o);
        total+=o.getTotal();
    }

    public double getTotal(){
        return total;
    }

    public boolean isElegibleForFreeDelivery() {
        if (getTotal() > 100) return true;
        return false;
    }

    public String printOrder() {
        StringBuffer printBuffer = new StringBuffer();

        for (OrderLine line : lines)
            printBuffer.append(line);

        printBuffer.append("Total: " + getTotal());

        return printBuffer.toString();
    }
}