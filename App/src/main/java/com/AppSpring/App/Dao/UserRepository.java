package com.AppSpring.App.Dao;

import com.AppSpring.App.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Employee, Integer> {
}
