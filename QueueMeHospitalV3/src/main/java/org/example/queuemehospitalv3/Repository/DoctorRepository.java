package org.example.queuemehospitalv3.Repository;

import org.example.queuemehospitalv3.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Doctor findDoctorById(Integer id);
}
