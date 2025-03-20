package com.example;

import java.util.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class ShoppingCart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale locale = selectLanguage(scanner);
        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);

        System.out.println(messages.getString("enter_items"));
        int numItems = scanner.nextInt();
        double totalCost = 0;

        for (int i = 0; i < numItems; i++) {
            System.out.println(messages.getString("enter_price") + " (Item " + (i + 1) + "):");
            double price = scanner.nextDouble();
            System.out.println(messages.getString("enter_quantity") + " (Item " + (i + 1) + "):");
            int quantity = scanner.nextInt();
            totalCost += price * quantity;
        }
        
        System.out.println(messages.getString("total_cost") + totalCost);
        scanner.close();
    }


    private static Locale selectLanguage(Scanner scanner) {
        System.out.println("Select language: 1 - English, 2 - Finnish, 3 - Swedish, 4 - Japanese");
        int choice = scanner.nextInt();
        return switch (choice) {
            case 2 -> new Locale("fi", "FI");
            case 3 -> new Locale("sv", "SE");
            case 4 -> new Locale("ja", "JP");
            default -> new Locale("en", "US");
        };
    }
}
