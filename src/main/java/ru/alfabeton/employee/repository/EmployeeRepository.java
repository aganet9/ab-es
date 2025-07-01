package ru.alfabeton.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alfabeton.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
