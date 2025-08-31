package com.mycompany.queiungsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class OrderData {

    public static List<String> orders = new ArrayList<>();
    public static String orderType = "";
    public static double total = 0.0;

    
    private static Map<Integer, List<String>> orderHistory = new HashMap<>();
    private static Map<Integer, Double> orderTotals = new HashMap<>();
     private static Map<Integer, String> orderTypes = new HashMap<>(); 


    static int currentOrderNumber = 0;

    public static void addOrder(String meal, double price, int qty) {
        String order = meal + " x" + qty + " - ₱" + String.format("%.2f", (price * qty));
        orders.add(order);
        total += price * qty;
    }


    public static int lastSavedOrderNumber = 0;
    
    public static int saveOrder() {
        
        currentOrderNumber++;
        
        orderHistory.put(currentOrderNumber, new ArrayList<>(orders));
        orderTotals.put(currentOrderNumber, total);
        orderTypes.put(currentOrderNumber, orderType);

        lastSavedOrderNumber = currentOrderNumber;

        resetOrder();

        return currentOrderNumber;
        
    }


    public static List<String> getOrderByNumber(int orderNumber) {
        return orderHistory.getOrDefault(orderNumber, new ArrayList<>());
    }

    public static double getTotalByNumber(int orderNumber) {
        return orderTotals.getOrDefault(orderNumber, 0.0);
    }
    
    public static String getOrderTypeByNumber(int orderNumber) {
        return orderTypes.getOrDefault(orderNumber, "");
    }

    public static void resetOrder() {
        orders.clear();
        total = 0.0;
        orderType = "";
    }


    public static String getFormattedTotal() {
        return "₱" + String.format("%.2f", total);
    }

    public static int getCurrentOrderNumber() {
        return currentOrderNumber;
    }
    public static Set<Integer> getAllOrderNumbers() {
        return orderHistory.keySet();
    }

    // NEW: Get order history map (for table display)
    public static Map<Integer, List<String>> getOrderHistory() {
        return orderHistory;
    }

    // NEW: Get order totals map
    public static Map<Integer, Double> getOrderTotals() {
        return orderTotals;
    }

    // NEW: Get order types map
    public static Map<Integer, String> getOrderTypes() {
        return orderTypes;
    }
}
