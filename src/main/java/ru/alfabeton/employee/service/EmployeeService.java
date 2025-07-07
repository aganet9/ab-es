package ru.alfabeton.employee.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.alfabeton.employee.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> findAll();

    EmployeeDto findById(Long id);

    EmployeeDto create(EmployeeDto employeeDto);

    EmployeeDto update(Long id, EmployeeDto employeeDto);

    void delete(Long id);

    Page<EmployeeDto> findAllPaged(Pageable pageable);
}
