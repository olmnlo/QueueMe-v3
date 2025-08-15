package org.example.queuemehospitalv3.Repository;

import org.example.queuemehospitalv3.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
