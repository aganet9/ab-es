package ru.alfabeton.employee.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.alfabeton.employee.dto.EmployeeDto;
import ru.alfabeton.employee.entity.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDto toDto(Employee employee);

    Employee toEntity(EmployeeDto employeeDto);

    void updateFromDto(EmployeeDto employeeDto, @MappingTarget Employee employee);
}
