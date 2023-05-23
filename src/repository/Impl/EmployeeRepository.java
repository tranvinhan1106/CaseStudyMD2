package src.repository.Impl;

import src.models.Employee;
import src.repository.IEmployeeRepository;
import src.utils.RAndWEmployee;

import java.io.IOException;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    RAndWEmployee randWEmployee = new RAndWEmployee();
    @Override
    public void addEmployee(Employee employee) throws IOException {
        List<Employee> employeeList =  randWEmployee.readerFileCSV();
        employeeList.add(employee);
        randWEmployee.writeCSV(employeeList);
    }

    @Override
    public void setEmployee(Employee employee, String employeeCode) throws IOException {
        List<Employee> employeeList = randWEmployee.readerFileCSV();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getEmployeeCode().equals(employeeCode)) {
                employeeList.set(i, employee);
                break;
            }
        }
        randWEmployee.writeCSV(employeeList);
    }

    @Override
    public List<Employee> findAll() throws IOException {
        return randWEmployee.readerFileCSV();
    }

    @Override
    public boolean checkID(String employeeCode) throws IOException {
        List<Employee> employeeList = randWEmployee.readerFileCSV() ;
        for (Employee employee : employeeList){
            if (employeeCode.equals(employee.getEmployeeCode())){
                return true ;
            }
        }
        return false;
    }
}
