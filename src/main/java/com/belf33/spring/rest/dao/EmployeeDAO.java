package com.belf33.spring.rest.dao;

import com.belf33.spring.rest.entity.Employee;
import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployee();

    void addEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int employee);
}
