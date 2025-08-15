package org.example.queuemehospitalv3.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.queuemehospitalv3.Api.ApiResponse;
import org.example.queuemehospitalv3.DTO.DepartmentDTO;
import org.example.queuemehospitalv3.Model.Department;
import org.example.queuemehospitalv3.Service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<Department>> getDepartments(){
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.getAllDepartments());
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addDepartment(@Valid @RequestBody DepartmentDTO departmentDTO){
        departmentService.addNewDepartment(departmentDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("department added successfully"));
    }
}
