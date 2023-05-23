package src.controllers;

import java.io.IOException;
import java.util.Scanner;

public class FuramaController {
    public void displayMainMenu() throws IOException {
        EmployeeManagement employeeManagement = new EmployeeManagement();
        CustomerManagement customerManagement = new CustomerManagement();
        FacilityManagement facilityManagement = new FacilityManagement();
        BookingManagement bookingManagement = new BookingManagement();
        PromotionManagement promotionManagement = new PromotionManagement();
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        do {
            try {
                int choice;
                System.out.println("=====FuramaResort=====" + "\n" +
                        "1. Employee Management " + "\n" +
                        "2. Customer Management " + "\n" +
                        "3. Facility Management " + "\n" +
                        "4. Booking Management " + "\n" +
                        "5. Promotion Management " + "\n" +
                        "6. Exit " + "\n" +
                        "Vui lòng chọn chức năng từ 1 -> 6 !");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        employeeManagement.displayEmployeeManagement();
                        break;
                    case 2:
                        customerManagement.displayCustomerManagement();
                        break;
                    case 3:
                        facilityManagement.displayFacilityManagement();
                        break;
                    case 4:
                        bookingManagement.displayBookingManagement();
                        break;
                    case 5:
                        promotionManagement.displayPromotionManagement();
                        break;
                    case 6:
                        check = false;
                }
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số !");
            }
        } while (check);
    }
}
