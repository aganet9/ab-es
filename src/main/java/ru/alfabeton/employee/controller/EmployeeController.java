package ru.alfabeton.employee.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.alfabeton.employee.dto.EmployeeDto;
import ru.alfabeton.employee.service.EmployeeService;

import java.util.List;

@Tag(name = "Employees API", description = "Работа с сотрудниками")
@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
@Validated
public class EmployeeController {

    private final EmployeeService employeeService;

    @Operation(summary = "Получить список сотрудников")
    @GetMapping
    public List<EmployeeDto> findAll() {
        return employeeService.findAll();
    }

    @Operation(summary = "Получить список сотрудников с пагинацией")
    @GetMapping("/paged")
    public Page<EmployeeDto> findAllPaged(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size) {
        return employeeService.findAllPaged(PageRequest.of(page, size));
    }

    @Operation(summary = "Получить сотрудника по идентификатору")
    @GetMapping("/{id}")
    public EmployeeDto findById(@PathVariable long id) {
        return employeeService.findById(id);
    }

    @Operation(summary = "Создать нового сотрудника")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto create(@Valid @RequestBody EmployeeDto employeeDto) {
        return employeeService.create(employeeDto);
    }

    @Operation(summary = "Обновить данные сотрудника")
    @PutMapping("/{id}")
    public EmployeeDto update(@PathVariable long id,
                              @Valid @RequestBody EmployeeDto employeeDto) {
        return employeeService.update(id, employeeDto);
    }

    @Operation(summary = "Удалить сотрудника по идентификатору")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        employeeService.delete(id);
    }
}
