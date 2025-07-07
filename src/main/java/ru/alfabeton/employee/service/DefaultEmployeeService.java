package ru.alfabeton.employee.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.alfabeton.employee.dto.EmployeeDto;
import ru.alfabeton.employee.exception.EmployeeNotFoundException;
import ru.alfabeton.employee.mapper.EmployeeMapper;
import ru.alfabeton.employee.repository.EmployeeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class DefaultEmployeeService implements EmployeeService {

    private final EmployeeRepository repo;
    private final EmployeeMapper mapper;

    @Override
    public List<EmployeeDto> findAll() {
        return repo.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public EmployeeDto findById(Long id) {
        return repo.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(id));
    }

    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {
        return mapper.toDto(repo.save(mapper.toEntity(employeeDto)));
    }

    @Override
    public EmployeeDto update(Long id, EmployeeDto employeeDto) {
        var existing = repo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        mapper.updateFromDto(employeeDto, existing);
        return mapper.toDto(repo.save(existing));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Page<EmployeeDto> findAllPaged(Pageable pageable) {
        return repo.findAll(pageable).map(mapper::toDto);
    }
}
