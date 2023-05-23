package src.controllers;

import java.util.Scanner;

public class PromotionManagement {
    public void displayPromotionManagement() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean check = false;
        do {
            System.out.println("=====Promotion Management=====" + "\n" +
                    "1. Display list customers use service " + "\n" +
                    "2. Displat list customers get voucher " + "\n" +
                    "3. Return main menu " + "\n" +
                    "Vui lòng chọn chức năng từ 1->3 !");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    check = false;
            }
        } while (check);
    }
}
