package com.mycompany.queiungsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class OrderData {

    public static List<String> orders = new ArrayList<>();
    public static String orderType = "";
    public static double total = 0.0;

    // Map to store all saved orders
    private static Map<Integer, List<String>> orderHistory = new HashMap<>();
    private static Map<Integer, Double> orderTotals = new HashMap<>();

    // Auto-increment order number
    static int currentOrderNumber = 0;

    // ---- Add order ----
    public static void addOrder(String meal, double price, int qty) {
        String order = meal + " x" + qty + " - ₱" + String.format("%.2f", (price * qty));
        orders.add(order);
        total += price * qty;
    }

    // ---- Save order and return its number ----
    public static int saveOrder() {
        currentOrderNumber++;
        orderHistory.put(currentOrderNumber, new ArrayList<>(orders));
        orderTotals.put(currentOrderNumber, total);

        // Clear cart after saving
        resetOrder();

        return currentOrderNumber;
    }

    // ---- Retrieve orders by order number ----
    public static List<String> getOrderByNumber(int orderNumber) {
        return orderHistory.getOrDefault(orderNumber, new ArrayList<>());
    }

    public static double getTotalByNumber(int orderNumber) {
        return orderTotals.getOrDefault(orderNumber, 0.0);
    }

    // ---- Reset order (for Cancel button) ----
    public static void resetOrder() {
        orders.clear();
        total = 0.0;
        orderType = "";
    }

    // ---- Helpers ----
    public static String getFormattedTotal() {
        return "₱" + String.format("%.2f", total);
    }

    public static int getCurrentOrderNumber() {
        return currentOrderNumber;
    }
}
