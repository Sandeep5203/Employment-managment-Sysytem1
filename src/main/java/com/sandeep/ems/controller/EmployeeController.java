package com.sandeep.ems.controller;

import com.sandeep.ems.entites.Employees;
import com.sandeep.ems.exceptions.*;
import com.sandeep.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping({"/employees","/"})
    public ModelAndView findAllEmployees() throws EmployeesNotExist {
        ModelAndView modelAndView;
            modelAndView = new ModelAndView("employees-list");
            modelAndView.addObject("employees", employeeService.findAllEmployees());
        return modelAndView;
    }

    @GetMapping("/employees/new")
    public ModelAndView createEmployeeForm(){
        ModelAndView modelAndView = new ModelAndView("createEmployeeForm");
        Employees employees = new Employees();
        modelAndView.addObject("employee",employees);
        return modelAndView;
    }

    @PostMapping("/saveEmployees")
    public String saveEmployee(@ModelAttribute Employees employees) throws EmployeeAlreadyExist {
            employeeService.saveEmployee(employees);
        return "redirect:/employees";
    }

    @GetMapping("/updateEmployees")
    public ModelAndView showUpdateEmployeeForm(@RequestParam long employeeId) throws EmployeeNotExist {
        ModelAndView modelAndView = new ModelAndView("createEmployeeForm");
        modelAndView.addObject("employee",employeeService.findEmployeeById(employeeId));
        return modelAndView;
    }

    @GetMapping("/employees/{location}")
    public String findEmployeesByLocation(Model model, @PathVariable String location) throws LocatonNotFoundException {
            model.addAttribute("employees", employeeService.findByLocation(location));
        return "redirect:/employees";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam long id) throws EmployeeIdNotFound {
            employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

//    @GetMapping("/findEmployee")
//    public String findEmployeeById(@RequestParam long id, Model model){
//        try{
//            Employees employee = employeeService.findEmployeeById(id);
//            model.addAttribute("employee", employee);
//        }catch (EmployeeNotExist e){
//            model.addAttribute("errorMessage", e.getMessage());
//            return "error";
//        }
//        return "employeeDetails";
//    }





}
