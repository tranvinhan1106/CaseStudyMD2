package src.controllers;

import src.services.Impl.EmployeeService;

import java.io.IOException;
import java.util.Scanner;

public class EmployeeManagement {
    EmployeeService employeeService = new EmployeeService();
    public void displayEmployeeManagement() throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        int choice;
        do {
            System.out.println("=====Employee Management=====" + "\n" +
                    "1. Display list " + "\n" +
                    "2. Add new employee " + "\n" +
                    "3. Edit employee " + "\n" +
                    "4. Return main menu" + "\n" +
                    "Vui lòng chọn chức năng từ 1->4 !");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    employeeService.findAll();
                    break;
                case 2:
                    employeeService.addEmployee();
                    break;
                case 3:
                    employeeService.setEmployee();
                    break;
                case 4:
                    check = false;
            }
        } while (check);
    }
}
