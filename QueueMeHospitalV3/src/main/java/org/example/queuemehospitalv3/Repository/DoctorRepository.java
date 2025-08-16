package org.example.queuemehospitalv3.Repository;

import org.example.queuemehospitalv3.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Doctor findDoctorById(Integer id);

    @Query("select s.availableDay from Scheduler s where s.doctor.id =:id")
    List<LocalDate> findDoctorAvailableDay(@Param("id")Integer id);
}
