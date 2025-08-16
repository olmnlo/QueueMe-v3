package org.example.queuemehospitalv3.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.queuemehospitalv3.Api.ApiResponse;
import org.example.queuemehospitalv3.DTO.DoctorDTO;
import org.example.queuemehospitalv3.Model.Doctor;
import org.example.queuemehospitalv3.Service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<Doctor>> getDoctors(){
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.findAllDoctors());
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addDoctor(@Valid@RequestBody DoctorDTO doctorDTO){
        doctorService.addNewDoctor(doctorDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("doctor added successfully"));
    }

    @PutMapping("/{doctorId}")
    public ResponseEntity<ApiResponse> updateDoctor(@PathVariable Integer doctorId,@Valid@RequestBody DoctorDTO doctorDTO){
        doctorService.updateDoctor(doctorId,doctorDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("doctor updated successfully"));
    }

    @DeleteMapping("/{doctorId}")
    public ResponseEntity<ApiResponse> deleteDoctor(@PathVariable Integer doctorId){
        doctorService.deleteDoctor(doctorId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("doctor deleted successfully"));
    }
}
