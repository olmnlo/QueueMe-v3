package org.example.queuemehospitalv3.Service;

import lombok.RequiredArgsConstructor;
import org.example.queuemehospitalv3.Api.ApiException;
import org.example.queuemehospitalv3.DTO.DoctorDTO;
import org.example.queuemehospitalv3.Model.Department;
import org.example.queuemehospitalv3.Model.Doctor;
import org.example.queuemehospitalv3.Repository.DepartmentRepository;
import org.example.queuemehospitalv3.Repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    private final DepartmentRepository departmentRepository;


    public List<Doctor> findAllDoctors(){
        List<Doctor> doctors = doctorRepository.findAll();
        if (doctors.isEmpty()){
            throw new ApiException("doctors not found");
        }
        return doctors;
    }

    public void addNewDoctor(DoctorDTO doctorDTO){
        Department department = departmentRepository.findDepartmentById(doctorDTO.getDepartmentId());
        if (department == null){
            throw new ApiException("department not found");
        }
        Doctor doctor = new Doctor(null,doctorDTO.getName(),doctorDTO.getSpecialization(),false,department);
        department.getDoctors().add(doctor);
        departmentRepository.save(department);
    }

    public void updateDoctor(Integer doctorId,DoctorDTO doctorDTO){
        Department department = departmentRepository.findDepartmentById(doctorDTO.getDepartmentId());
        if (department == null){
            throw new ApiException("department not found");
        }
        Doctor oldDoctor = doctorRepository.findDoctorById(doctorId);
        if (oldDoctor == null){
            throw new ApiException("doctor not found");
        }
        oldDoctor.setDepartment(department);
        oldDoctor.setName(doctorDTO.getName());
        oldDoctor.setName(doctorDTO.getName());
        oldDoctor.setSpecialization(doctorDTO.getSpecialization());
        oldDoctor.setIsLeave(doctorDTO.getIsLeave());
        doctorRepository.save(oldDoctor);


    }

    public void deleteDoctor(Integer doctorId){
        Doctor doctor = doctorRepository.findDoctorById(doctorId);
        if (doctor == null){
            throw new ApiException("doctor not found");
        }
        Department department = departmentRepository.findDepartmentById(doctor.getDepartment().getId());
        if (department == null){
            throw new ApiException("department not found");
        }

        doctor.setDepartment(null);
        doctorRepository.delete(doctor);
        department.getDoctors().remove(doctor);
        departmentRepository.save(department);

    }

}
