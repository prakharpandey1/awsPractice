package org.example.awsec2practice.Controller;

import org.example.awsec2practice.dto.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

import static java.util.Locale.filter;

@RestController
@RequestMapping(path="/api2/newemployee")
public class EmployeeController {

    private final ArrayList<Employee> employees =new ArrayList<Employee>();

    @GetMapping()
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    @PostMapping()
    public Employee addEmployee(@RequestBody Employee employee) {
        this.employees.add(employee);
        return employee;
    }

    @PutMapping(path="/update/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee2){
        Optional<Employee> employeeOptional = employees.stream()
                .filter(res -> res.getEmployeeId() == id).findFirst();

        if (employeeOptional.isPresent()) {
            Employee employee1 = employeeOptional.get();
            employee1.setFirstName(employee2.getFirstName());
            employee1.setLastName(employee2.getLastName());
            employee1.setDepartment(employee2.getDepartment());
            employee1.setPosition(employee2.getPosition());
            employee1.setSalary(employee2.getSalary());
            employee1.setEmail(employee2.getEmail());
            employee1.setPhoneNumber(employee2.getPhoneNumber());
            employee1.setHireDate(employee2.getHireDate());
            employee1.setFullTime(employee2.isFullTime());
            return employee1;
        } else {
            throw new RuntimeException("Employee not found");
        }
    }

    // Delete an employee by ID (DELETE)
    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        boolean removed = employees.removeIf(employee -> employee.getEmployeeId() == employeeId);
        if (removed) {
            return "Employee with ID " + employeeId + " has been deleted.";
        } else {
            throw new RuntimeException("Employee not found");
        }
    }
}
