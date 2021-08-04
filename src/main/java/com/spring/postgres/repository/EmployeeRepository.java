package com.spring.postgres.repository;

import com.spring.postgres.modal.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Long> {

    public Employees findByEmail(String email);
}
