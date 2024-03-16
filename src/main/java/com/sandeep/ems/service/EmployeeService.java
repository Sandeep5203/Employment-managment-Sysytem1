package com.sandeep.ems.service;

import com.sandeep.ems.entites.Employees;
import com.sandeep.ems.exceptions.*;

import java.util.List;
public interface EmployeeService {

    Employees saveEmployee(Employees employees) throws EmployeeAlreadyExist;
    Employees updateEmployee(long id, Employees employees) throws EmployeeIdNotFound;
    String deleteEmployee(long id) throws EmployeeIdNotFound;
    Employees findEmployeeById(long id) throws EmployeeNotExist;
    List<Employees> findAllEmployees() throws EmployeesNotExist;
    List<Employees> findByLocation(String location) throws LocatonNotFoundException;
}
