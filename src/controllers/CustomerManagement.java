package src.controllers;

import src.services.Impl.CustomerService;

import java.io.IOException;
import java.util.Scanner;

public class CustomerManagement {
    public void displayCustomerManagement() throws IOException {
        CustomerService customerService = new CustomerService();
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean check = true;
        do {
            System.out.println("=====Customer Management=====" + "\n" +
                    "1. Display list customers " + "\n" +
                    "2. Add new customer " + "\n" +
                    "3. Edit customer " + "\n" +
                    "4. Return main menu " + "\n" +
                    "Vui lòng chọn chức năng từ 1-> 4 !");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    customerService.findAll();
                    break;
                case 2:
                    customerService.addCustomer();
                    break;
                case 3:
                    customerService.setCustomer();
                    break;
                case 4:
                    check = false;
            }
        } while (check);
    }
}
