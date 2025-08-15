package org.example.queuemehospitalv3.Service;

import lombok.RequiredArgsConstructor;
import org.example.queuemehospitalv3.Api.ApiException;
import org.example.queuemehospitalv3.Model.Hospital;
import org.example.queuemehospitalv3.Repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public List<Hospital> getAllHospitals(){
        List<Hospital> hospitals = hospitalRepository.findAll();
        if (hospitals.isEmpty()){
            throw new ApiException("hospitals not found");
        }
        return hospitals;
    }

    public void addNewHospital(Hospital hospital){
        hospitalRepository.save(hospital);
    }

    public void updateHospital(Integer hospitalId, Hospital hospital){
        Hospital oldHospital = hospitalRepository.findHospitalById(hospitalId);
        if (oldHospital == null){
            throw new ApiException("hospital not found");
        }
        oldHospital.setName(hospital.getName());
        oldHospital.setLatitude(hospital.getLatitude());
        oldHospital.setLongitude(hospital.getLongitude());
        hospitalRepository.save(oldHospital);
    }


    public void deleteHospital(Integer hospitalId){
        Hospital hospital = hospitalRepository.findHospitalById(hospitalId);
        if (hospital == null){
            throw new ApiException("hospital not found");
        }
        hospitalRepository.delete(hospital);
    }

}
