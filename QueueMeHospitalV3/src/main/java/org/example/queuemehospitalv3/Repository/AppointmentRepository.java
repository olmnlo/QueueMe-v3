package org.example.queuemehospitalv3.Repository;

import org.example.queuemehospitalv3.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    Appointment findAppointmentById(Integer id);
}
