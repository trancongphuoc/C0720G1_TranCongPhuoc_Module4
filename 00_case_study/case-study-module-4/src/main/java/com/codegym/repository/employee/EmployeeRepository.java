package com.codegym.repository.employee;

import com.codegym.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
