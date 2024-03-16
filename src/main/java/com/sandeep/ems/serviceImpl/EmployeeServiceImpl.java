package com.sandeep.ems.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.sandeep.ems.entites.Employees;
import com.sandeep.ems.exceptions.*;
import com.sandeep.ems.repository.EmployeeRepository;
import com.sandeep.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;


@Service
@EnableCaching
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public String deleteEmployee(long id) throws EmployeeIdNotFound {
        Optional<Employees> employees = employeeRepository.findById(id);
        if(employees.isPresent()){
            employeeRepository.deleteById(id);
            return "Employee Deleted Successfully...";
        }else{
            throw new EmployeeIdNotFound("Employee Id Not Exist...");
        }
    }

    @Cacheable(cacheNames = "firstcache",key = "'#id'", unless = "#result == null")
    @Override
    public Employees findEmployeeById(long id) throws EmployeeNotExist {
        Optional<Employees> employees = employeeRepository.findById(id);
        if(employees.isPresent()){
            return employeeRepository.findById(id).get();
        }else{
            throw new EmployeeNotExist("Employee Not found In DB...");
        }
    }
    
    @Cacheable(cacheNames = "firstcache",key = "'#key'", unless = "#result == null")
    @Override
    public List<Employees> findAllEmployees() throws EmployeesNotExist {
        List<Employees> employees = employeeRepository.findAll();
        if(employees.isEmpty()){
            throw new EmployeesNotExist("Employees Not Found In DB...");
        }else{
            return employees;
        }
    }

    @Override
    public List<Employees> findByLocation(String location) throws LocatonNotFoundException {
        List<Employees> employees = employeeRepository.findByLocation(location);
        if(employees.isEmpty()){
            throw new LocatonNotFoundException("Employees Not Found in the given location");
        }
        return employees;
    }

    @Override
    public Employees saveEmployee(Employees employees) throws EmployeeAlreadyExist {

                return employeeRepository.save(employees);

    }

    @Override
    public Employees updateEmployee(long id, Employees employees) throws EmployeeIdNotFound {
        Employees employees1 = employeeRepository.findById(id).get();

        if(employees1.getId()==id){
            employees.setId(id);
            return employeeRepository.save(employees);
        }else{
            throw new EmployeeIdNotFound("Employee Id not Found in DB...");
        }
    }
}
