package org.example.queuemehospitalv3.Repository;

import org.example.queuemehospitalv3.Model.Scheduler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulerRepository extends JpaRepository<Scheduler, Integer> {
    Scheduler findSchedulerById(Integer id);
}
