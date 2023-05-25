package src.services.Impl;

import src.models.Customer;
import src.regex.MyRegex;
import src.repository.Impl.CustomerRepository;
import src.services.ICustomerService;
import src.utils.Myutils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    CustomerRepository customerRepository = new CustomerRepository();
    @Override
    public void addCustomer() {
        Scanner scanner = new Scanner(System.in);
        String customerCode;
        try {
            do {
                System.out.println("Enter customerCode :");
                customerCode = scanner.next();
                if (!customerCode.matches(MyRegex.REGEX_CUSTOMER_ID)) {
                    System.err.println("Vui lòng nhập đúng định dạng (KH-XXXX) !");
                }
            } while (!customerCode.matches(MyRegex.REGEX_CUSTOMER_ID));
            if (!customerRepository.checkID(customerCode)) {
                System.out.println("Enter name customer :");
                String name = scanner.next();
                String birthday = null;
                boolean check = false;
                do {
                    System.out.print("Enter birthday(dd/MM/yyyy):");
                    try {
                        birthday = scanner.next();
                        LocalDate birth = LocalDate.parse(birthday, DateTimeFormatter.ofPattern(MyRegex.REGEX_DATE));
                        LocalDate today = LocalDate.now();
                        int age = Period.between(birth, today).getYears();
                        check = Myutils.checkDate(age);
                        if (!check) {
                            System.err.println("Enter birthday is age :>= 18 or <=100");
                        }
                    } catch (DateTimeParseException e) {
                        System.err.println("Vui lòng nhập đúng định dạng (dd/MM/yyyy) !");
                    }
                } while (!check);
                String gender = Myutils.gender();
                System.out.println("Enter identityCard customer :");
                String identityCard = scanner.next();
                System.out.println("Enter numberPhone customer :");
                String numberPhone = scanner.next();
                String email;
                do {
                    System.out.print("Enter email customer:");
                    email = scanner.next();
                    if (!email.matches(MyRegex.REGEX_EMAIL)) {
                        System.err.println("Vui lòng thử lại ! ");
                    }
                } while (!email.matches(MyRegex.REGEX_EMAIL));
                System.out.println("Enter typeGuest customer :");
                System.out.println("--------------------");
                System.out.println("1. Diamond\n2. Platinum\n3. Gold\n4. Silver\n5. Member ");
                System.out.println("--------------------");
                String typeGuest = "";
                System.out.println("Please choose from 1 -> 5 :");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        typeGuest = "Diamond";
                        break;
                    case 2:
                        typeGuest = "Platinum";
                        break;
                    case 3:
                        typeGuest = "Gold";
                        break;
                    case 4:
                        typeGuest = "Silver";
                        break;
                    case 5:
                        typeGuest = "Member";
                        break;
                }
                System.out.println("Enter address customer :");
                String address = scanner.next();
                Customer customer = new Customer(customerCode, name, birthday, gender, identityCard, numberPhone, email, typeGuest, address);
                customerRepository.addCustomer(customer);
            } else {
                System.err.println("Enter the same customer code! Please try again .");
            }
        } catch (NumberFormatException e) {
            System.err.println("Vui lòng thử lại và nhập số !");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void findAll() throws IOException {
        List<Customer> customerList = customerRepository.findAll();
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }
    @Override
    public void setCustomer() {
        Scanner scanner = new Scanner(System.in);
        try {
            String customerCode;
            do {
                System.out.println("enter the customer code to edit:");
                customerCode = scanner.next();
                if (!customerCode.matches(MyRegex.REGEX_CUSTOMER_ID)) {
                    System.out.println("Vui lòng nhập đúng định dạng (KH-XXXX) !");
                }
            } while (!customerCode.matches(MyRegex.REGEX_CUSTOMER_ID));
            if (customerRepository.checkID(customerCode)) {
                System.out.print("Enter new  CustomerName:");
                String name = scanner.next();
                String birthday = null;
                boolean check = false;
                do {
                    System.out.print("Enter birthday(dd/MM/yyyy):");
                    try {
                        birthday = scanner.next();
                        LocalDate birth = LocalDate.parse(birthday, DateTimeFormatter.ofPattern(MyRegex.REGEX_DATE));
                        LocalDate today = LocalDate.now();
                        int age = Period.between(birth, today).getYears();
                        check = Myutils.checkDate(age);
                        if (!check) {
                            System.out.println("Enter birthday is age :>= 18 or <=100");
                        }
                    } catch (DateTimeParseException e) {
                        System.err.println("Vui lòng nhập đúng định dạng (dd/MM/yyyy) !");
                    }
                } while (!check);
                String gender = Myutils.gender();
                String identityCard;
                do {
                    System.out.print("Enter new identityCard Customer");
                     identityCard = scanner.next();
                     if (!identityCard.matches(MyRegex.REGEX_CMND)){
                         System.err.println("Vui lòng nhập đủ 9 hoặc 12 số !");
                     }
                }while (!identityCard.matches(MyRegex.REGEX_CMND));
                String numberPhone ;
                do {
                    System.out.print("Enter new numberPhone Customer:");
                     numberPhone = scanner.next();
                     if (!numberPhone.matches(MyRegex.REGEX_PHONE)){
                         System.err.println("Vui lòng nhập đủ 10 số !");
                     }
                }while (!numberPhone.matches(MyRegex.REGEX_PHONE));
                String email;
                do {
                    System.out.print("Enter new email Customer:");
                    email = scanner.next();
                    if (!email.matches(MyRegex.REGEX_EMAIL)) {
                        System.err.println("Vui lòng thử lại ! ");
                    }
                } while (!email.matches(MyRegex.REGEX_EMAIL));
                System.out.print("Enter new CustomerType:");
                System.out.println();
                System.out.println("--------------------");
                System.out.println("1. Diamond\n2. Platinum\n3. Gold\n4.Silver\n5.Member ");
                System.out.println("--------------------");
                String typeGuest = "";
                System.out.println("Please choose from 1 -> 5 :");
                int choice2 = scanner.nextInt();
                switch (choice2) {
                    case 1:
                        typeGuest = "Diamond";
                        break;
                    case 2:
                        typeGuest = "Platinum";
                        break;
                    case 3:
                        typeGuest = "Gold";
                        break;
                    case 4:
                        typeGuest = "Silver";
                        break;
                    case 5:
                        typeGuest = "Member";
                        break;
                }
                System.out.print("Enter new Address Customer:");
                String address = scanner.next();
                customerRepository.setCustomerList(new Customer(customerCode, name, birthday, gender, identityCard, numberPhone, email, typeGuest, address), customerCode);
            } else {
                System.err.println("Enter the wrong customer code ! Please try again !");
            }

        } catch (NumberFormatException e) {
            System.err.println("Vui lòng thử lại và nhập số !");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public boolean checkID() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id nhân viên :");
        String employeeCode = scanner.nextLine();
        customerRepository.checkID(employeeCode);
        return true;
    }
}
