package org.example.queuemehospitalv3.Service;

import lombok.RequiredArgsConstructor;
import org.example.queuemehospitalv3.Api.ApiException;
import org.example.queuemehospitalv3.DTO.DepartmentDTO;
import org.example.queuemehospitalv3.Model.Department;
import org.example.queuemehospitalv3.Model.Hospital;
import org.example.queuemehospitalv3.Repository.DepartmentRepository;
import org.example.queuemehospitalv3.Repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final HospitalRepository hospitalRepository;


    public List<Department> getAllDepartments(){
        List<Department> departments = departmentRepository.findAll();
        if (departments.isEmpty()){
            throw new ApiException("departments not found");
        }
        return departments;
    }


    public void addNewDepartment(DepartmentDTO departmentDTO){
        Hospital hospital = hospitalRepository.findHospitalById(departmentDTO.getHospitalId());
        if (hospital == null){
            throw new ApiException("hospital not found");
        }
        Department department = new Department(null, departmentDTO.getName(), departmentDTO.getDescription(), new ArrayList<>() ,hospital);
        hospital.getDepartments().add(department);
        departmentRepository.save(department);
    }

    public void updateDepartment(Integer departmentId,DepartmentDTO departmentDTO){
        Department oldDepartment = departmentRepository.findDepartmentById(departmentId);
        if (oldDepartment == null){
            throw new ApiException("department not found");
        }
        Hospital hospital = hospitalRepository.findHospitalById(departmentDTO.getHospitalId());
        if (hospital == null){
            throw new ApiException("hospital not found");
        }
        oldDepartment.setName(departmentDTO.getName());
        oldDepartment.setDescription(departmentDTO.getDescription());
        oldDepartment.setHospital(hospital);
        departmentRepository.save(oldDepartment);

    }

    public void deleteDepartment(Integer departmentId){
        Department department = departmentRepository.findDepartmentById(departmentId);
        if (department == null){
            throw new ApiException("department not found");
        }
        Hospital hospital = hospitalRepository.findHospitalById(department.getHospital().getId());
        if (hospital == null){
            throw new ApiException("hospital not found");
        }
        department.setHospital(null);
        departmentRepository.delete(department);
        hospital.getDepartments().remove(department);
        hospitalRepository.save(hospital);

    }
}
