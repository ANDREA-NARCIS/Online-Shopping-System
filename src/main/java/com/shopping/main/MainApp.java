package com.shopping.main;

import com.shopping.service.ShoppingService;
import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        ShoppingService service = new ShoppingService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Place Order");
            System.out.println("2. View Orders");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Customer ID: ");
                    int cid = sc.nextInt();

                    System.out.print("Enter Product IDs (comma separated): ");
                    sc.nextLine();
                    String input = sc.nextLine();

                    List<Integer> productIds = new ArrayList<>();
                    for (String s : input.split(",")) {
                        productIds.add(Integer.parseInt(s.trim()));
                    }

                    service.placeOrder(cid, productIds);
                    break;

                case 2:
                    System.out.print("Enter Customer ID: ");
                    int id = sc.nextInt();
                    service.getCustomerOrders(id);
                    break;

                case 3:
                    System.exit(0);
            }
        }
    }
}