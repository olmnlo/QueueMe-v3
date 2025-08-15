package org.example.queuemehospitalv3.Repository;

import org.example.queuemehospitalv3.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findAdminById(Integer id);
}
