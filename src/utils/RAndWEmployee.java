package src.utils;

import src.models.Employee;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class RAndWEmployee {
    public static final String FILE_PATH ="D:\\V.An\\FuramaResort\\src\\data\\employee.csv";
    public List<Employee> readerFileCSV() throws IOException {
        FileReader fileReader = new FileReader(FILE_PATH);
        BufferedReader br = new BufferedReader(fileReader);
        List<Employee> employeeList = new LinkedList<>();
        Employee employee ;
        String line;
        String[] temp;
        while ((line = br.readLine()) != null) {
            temp = line.split(",");
            String employeeCode = temp[0];
            String name = temp[1];
            String birthday = temp[2];
            String gender = temp[3];
            String identityCard = temp[4];
            String numberPhone = temp[5];
            String email = temp[6];
            String level = temp[7];
            String location = temp[8];
            long wage = Long.parseLong(temp[9]);
            employee = new Employee(employeeCode, name, birthday, gender, identityCard, numberPhone, email, level, location, wage);
            employeeList.add(employee);
        }
        br.close();
        return employeeList;
    }

    public void writeCSV(List<Employee> employees) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_PATH);
        BufferedWriter buff = new BufferedWriter(fileWriter);
        for (Employee employee : employees) {
            buff.write(employee.getEmployeeCode() + "," + employee.getName() + "," + employee.getBirthday() + "," + employee.getGender()
                    + "," + employee.getIdentityCard() + "," + employee.getPhoneNumber() + "," + employee.getEmail()
                    + "," + employee.getLevel() + "," + employee.getLocation() + "," + employee.getWage());
            buff.newLine();
        }
        buff.close();
    }
}
