package ru.alfabeton.employee.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.alfabeton.employee.dto.EmployeeDto;
import ru.alfabeton.employee.entity.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDto toDto(Employee employee);

    @Mapping(target = "id", ignore = true)
    Employee toEntity(EmployeeDto employeeDto);

    @Mapping(target = "id", ignore = true)
    void updateFromDto(EmployeeDto employeeDto, @MappingTarget Employee employee);
}
