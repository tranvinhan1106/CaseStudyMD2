package src.services.Impl;

import src.models.Employee;
import src.regex.MyRegex;
import src.repository.Impl.EmployeeRepository;
import src.services.IEmployeeService;
import src.utils.Myutils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();
    @Override

    public void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        try {
            String employeeCode;
            do {
                System.out.print("Enter EmployeeCode:");
                employeeCode = scanner.next();
                if (!employeeCode.matches(MyRegex.REGEX_EMPLOYEE_ID)) {
                    System.err.println("Vui lòng nhập đúng định dạng (NV-XXXX) !");
                }
            } while (!employeeCode.matches(MyRegex.REGEX_EMPLOYEE_ID));
            if (!employeeRepository.checkID(employeeCode)) {
                System.out.print("Enter name Employee:");
                String name = scanner.next();
                String birthday = null;
                boolean check = false;
                do {
                    System.out.print("Enter new birthday(dd/MM/yyyy):");
                    try {
                        birthday = scanner.next();
                        LocalDate birth = LocalDate.parse(birthday, DateTimeFormatter.ofPattern(MyRegex.REGEX_DATE));
                        LocalDate today = LocalDate.now();
                        int age = Period.between(birth, today).getYears();
                        check = Myutils.checkDate(age);
                        if (!check) {
                            System.out.println("Enter birthday is age >= 18 or <= 100");
                        }
                    } catch (DateTimeParseException e) {
                        System.err.println("Vui lòng nhập đúng định dạng (dd/MM/yyyy) !");
                    }
                } while (!check);
                String gender = Myutils.gender();
                String identityCard;
                do {
                    System.out.print("Enter identityCard Employee:");
                    identityCard = scanner.next();
                    if (!identityCard.matches(MyRegex.REGEX_CMND)) {
                        System.err.println("Vui lòng nhập đủ 9 hoặc 12 số !");
                    }
                    ;
                } while (!identityCard.matches(MyRegex.REGEX_CMND));
                String numberPhone;
                do {
                    System.out.print("Enter numberPhone Employee:");
                    numberPhone = scanner.next();
                    if (!numberPhone.matches(MyRegex.REGEX_PHONE)) {
                        System.out.println("Vui lòng nhập đủ 10 số và bắt đầu bằng số 0 !");
                    }
                } while (!numberPhone.matches(MyRegex.REGEX_PHONE));
                String email;
                do {
                    System.out.print("Enter email employee:");
                    email = scanner.next();
                    if (!email.matches(MyRegex.REGEX_EMAIL)) {
                        System.err.println("Email cần đảm bảo gồm A-z , số , gmail.com ! ");
                    }
                } while (!email.matches(MyRegex.REGEX_EMAIL));
                System.out.print("Enter level Employee:");
                System.out.println();
                System.out.println("------------------------");
                System.out.println("1.Trung cấp\n2.Cao đẳng\n3.Đại học\n4.Sau đại học");
                System.out.println("------------------------");
                String levelChoice = "";
                System.out.print("Enter number 1 --> 4:");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        levelChoice = "Trung cấp";
                        break;
                    case 2:
                        levelChoice = "Cao đẳng";
                        break;
                    case 3:
                        levelChoice = "Đại học";
                        break;
                    case 4:
                        levelChoice = "Sau đại học";
                        break;
                }
                System.out.print("Enter location Employee:");
                System.out.println();
                System.out.println("-------------------------------");
                System.out.println("1.Lễ tân\n2.Phục vụ\n3.Chuyên viên\n4.Giám sát\n5.Quản lý\n6.Giám đốc");
                System.out.println("-------------------------------");
                System.out.println("Enter number 1-->7:");
                choice = scanner.nextInt();
                String location = "";
                switch (choice) {
                    case 1:
                        location = "Lễ tân";
                        break;
                    case 2:
                        location = "Phục vụ";
                        break;
                    case 3:
                        location = "Chuyên viên";
                        break;
                    case 4:
                        location = "Giám sát";
                        break;
                    case 5:
                        location = "Quản lý";
                        break;
                    case 6:
                        location = "Giám đốc";
                        break;
                }
                System.out.print("Enter wage Employee:");
                long wage = scanner.nextLong();
                Employee employee = new Employee(employeeCode, name, birthday, gender, identityCard, numberPhone, email, levelChoice, location, wage);
                employeeRepository.addEmployee(employee);

            } else {
                System.err.println("Incorrect customer code entered ! Please try again !");
            }
        } catch (NumberFormatException e) {
            System.err.println("Vui lòng nhập số !");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void findAll() throws IOException {
        List<Employee> employeeList = employeeRepository.findAll();
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
    @Override
    public boolean checkID() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id nhân viên :");
        String employeeCode = scanner.nextLine();
        employeeRepository.checkID(employeeCode);
        return true;
    }
    @Override
    public void setEmployee() {
        Scanner scanner = new Scanner(System.in);
        try {
            String employeeCode;
            do {
                System.out.print("Enter the employee code to edit :");
                employeeCode = scanner.next();
                if (!employeeCode.matches(MyRegex.REGEX_EMPLOYEE_ID)) {
                    System.err.println("Vui lòng nhập đúng định dạng (NV-XXXX) !");
                }
            } while (!employeeCode.matches(MyRegex.REGEX_EMPLOYEE_ID));
            if (employeeRepository.checkID(employeeCode)) {
                System.out.print("Enter new name Employee:");
                String name = scanner.next();
                String birthday = null;
                boolean check = false;
                do {
                    System.out.print("Enter new birthday(dd/MM/yyyy):");
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
                System.out.print("Enter new identityCard Employee:");
                String identityCard = scanner.next();
                System.out.print("Enter new numberPhone Employee:");
                String numberPhone = scanner.next();
                String email;
                do {
                    System.out.print("Enter new email customer:");
                    email = scanner.next();
                    if (!email.matches(MyRegex.REGEX_EMAIL)) {
                        System.err.println("Vui lòng thử lại ! ");
                    }
                } while (!email.matches(MyRegex.REGEX_EMAIL));
                System.out.print("Enter new level Employee:");
                System.out.println();
                System.out.println("------------------------");
                System.out.println("1.Trung cấp\n2.Cao đẳng\n3.Đại học\n4.Sau đại học");
                System.out.println("------------------------");
                String levelChoice2 = "";
                System.out.print("Enter number 1 --> 4:");
                int choice2 = scanner.nextInt();
                switch (choice2) {
                    case 1:
                        levelChoice2 = "Trung cấp";
                        break;
                    case 2:
                        levelChoice2 = "Cao đẳng";
                        break;
                    case 3:
                        levelChoice2 = "Đại học";
                        break;
                    case 4:
                        levelChoice2 = "Sau đại học";
                        break;
                }
                System.out.print("Enter location Employee:");
                System.out.println();
                System.out.println("-------------------------------");
                System.out.println("1.Lễ tân\n2.Phục vụ\n3.Chuyên viên\n4.Giám sát\n5.Quản lý\n6.Giám đốc");
                System.out.println("-------------------------------");
                System.out.println("Enter number 1-->7:");
                int choice = scanner.nextInt();
                String location1 = "";
                switch (choice) {
                    case 1:
                        location1 = "Lễ tân";
                        break;
                    case 2:
                        location1 = "Phục vụ";
                        break;
                    case 3:
                        location1 = "Chuyên viên";
                        break;
                    case 4:
                        location1 = "Giám sát";
                        break;
                    case 5:
                        location1 = "Quản lý";
                        break;
                    case 6:
                        location1 = "Giám đốc";
                        break;
                }
                System.out.print("Enter new wage Employee:");
                long wage;
                do {
                     wage = scanner.nextLong();
                    if (wage<0){
                        System.err.println("Vui lòng nhập lương lớn hơn 0 !");
                    }
                }while (wage<0);
                employeeRepository.setEmployee(new Employee(employeeCode, name, birthday, gender, identityCard, numberPhone, email, levelChoice2, location1, wage), employeeCode);
            } else {
                System.err.println("Incorrect customer code entered ! Please try again !");
            }
        } catch (NumberFormatException | IOException e) {
            System.err.println("Vui lòng nhập số !");
        }
    }

}
