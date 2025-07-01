package ru.alfabeton.employee.service;

import ru.alfabeton.employee.dto.EmployeeDto;
import ru.alfabeton.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> findAll();

    EmployeeDto findById(Long id);

    EmployeeDto create(EmployeeDto employeeDto);

    EmployeeDto update(Long id, EmployeeDto employeeDto);

    void delete(Long id);
}
