package src.controllers;

import java.util.Scanner;

public class FacilityManagement {
    public void displayFacilityManagement() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean check = true;
        do {
            System.out.println("=====Facility Management" + "\n" +
                    "1. Display list facility " + "\n" +
                    "2. Add new facility " + "\n" +
                    "3. Display list facility maintenance " + "\n" +
                    "4. Return main menu " + "\n" +
                    "Vui lòng chọn chức năng từ 1->4 !");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    check = false;
            }
        } while (check);
    }
}
