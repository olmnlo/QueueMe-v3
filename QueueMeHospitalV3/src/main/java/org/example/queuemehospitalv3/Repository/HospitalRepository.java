package org.example.queuemehospitalv3.Repository;

import org.example.queuemehospitalv3.Model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    Hospital findHospitalById(Integer id);
}
