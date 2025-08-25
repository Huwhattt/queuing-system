package com.mycompany.queiungsystem;

import java.util.ArrayList;
import java.util.List;

public class OrderData {

    public static String orderNumber = "";
    public static double total = 0.0;
    public static List<String> orders = new ArrayList<>();

    public static String orderType = "Not Selected";

    public static void addOrder(String mealName, int price, int quantity) {
        int subtotal = price * quantity;
        total += subtotal;
        orders.add(mealName + " x" + quantity + " = ₱" + subtotal);
    }

    public static String getFormattedTotal() {
        return "₱ " + total;
    }

    public static void resetOrder() {
        total = 0.0;
        orders.clear();
        orderType = "Not Selected";
    }

}
