package src.repository;

import src.models.Employee;

import java.io.IOException;
import java.util.List;

public interface IEmployeeRepository {
    void addEmployee(Employee employee) throws IOException;

    void setEmployee(Employee employee, String employeeCode) throws IOException;

    List<Employee> findAll() throws IOException;

    boolean checkID(String employeeCode) throws IOException;
}
