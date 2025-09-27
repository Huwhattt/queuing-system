/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.queiungsystem;
import java.util.LinkedHashMap;
import java.util.Map;
public class InventoryData {
    public static Map<String, Integer> quantities = new LinkedHashMap<>();

    static {
        // Initial stock
        quantities.put("The Byte Meal", 30);
        quantities.put("The Snack Stack", 30);
        quantities.put("Flamin' Firewall", 30);
        quantities.put("Cheat Code", 30);
        quantities.put("Krazy Kernel", 30);
        quantities.put("The Full Stack Meal", 30);
    }

    // Reduce stock when ordered
    public static boolean reduceStock(String product, int qty) {
        if (!quantities.containsKey(product)) return false;

        int current = quantities.get(product);
        if (current >= qty) {
            quantities.put(product, current - qty);
            return true;
        }
        return false; // Not enough stock
    }

    // Get product status
    public static String getStatus(String product) {
        Integer q = quantities.get(product);
        return (q != null && q > 0) ? "Available" : "Unavailable";
    }
}
