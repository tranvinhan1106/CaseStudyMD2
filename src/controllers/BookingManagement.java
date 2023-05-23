package src.controllers;

import java.util.Scanner;

public class BookingManagement {
    public void displayBookingManagement() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean check = true;
        do {
            System.out.println("=====Booking Management=====" + "\n" +
                    "1. Add new booking " + "\n" +
                    "2. Display list booking " + "\n" +
                    "3. Create new contracts " + "\n" +
                    "4. Display list contracts " + "\n" +
                    "5. Edit contracts" + "\n" +
                    "6. Return main menu " + "\n" +
                    "Vui lòng chọn chức năng từ 1->6 !");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    check = false;
            }
        } while (check);
    }
}
