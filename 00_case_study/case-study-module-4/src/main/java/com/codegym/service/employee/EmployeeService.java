package com.codegym.service.employee;

import com.codegym.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Employee findByCode(String code);

    Employee findByEmail(String email);

    Employee findByIdCard(String idCard);

    Employee findByPhoneNumber(String phone);

    void save(Employee employee);
}
