package myskypro.employeebook.service;

import myskypro.employeebook.entity.Employee;
import myskypro.employeebook.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getEmployeeWithMaxSalary(Integer departmentId) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник с максимальной зарплатой не найден"));
    }

//    Свой вариант
//    public Employee getEmployeeWithMaxSalary(Integer departmentId) {
//        return employeeService.getAll().stream().filter(p -> p.getDepartmentId() == departmentId)
//                .max(Comparator.comparingInt(Employee::getSalary));
//    }

    public Employee getEmployeeWithMinSalary(Integer departmentId) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник с минимальной зарплатой не найден"));
    }

//    Свой вариант
//    public Employee getEmployeeWithMinSalary(Integer departmentId) {
//        return employeeService.getAll().stream().filter(p -> p.getDepartmentId() == departmentId)
//               .min(Comparator.comparingInt(Employee::getSalary));
//   }

    public Map<Integer, List<Employee>> getEmployeesByDepartment(Integer departmentId) {
        return employeeService.getAll().stream()
                .filter(e -> departmentId == null || e.getDepartmentId() == departmentId)
                .collect(groupingBy(Employee::getDepartmentId, toList()));
    }
}