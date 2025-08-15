package org.example.queuemehospitalv3.Controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.queuemehospitalv3.Api.ApiResponse;
import org.example.queuemehospitalv3.Model.Hospital;
import org.example.queuemehospitalv3.Service.HospitalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/hospital")
public class HospitalController {

    private final HospitalService hospitalService;

    @GetMapping
    public ResponseEntity<List<Hospital>> getHospitals(){
        return ResponseEntity.status(HttpStatus.OK).body(hospitalService.getAllHospitals());
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addHospital(@Valid@RequestBody Hospital hospital){
        hospitalService.addNewHospital(hospital);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("hospital added successfully"));
    }

    @PutMapping("/{hospitalId}")
    public ResponseEntity<ApiResponse> updateHospital(@PathVariable Integer hospitalId, @Valid@RequestBody Hospital hospital){
        hospitalService.updateHospital(hospitalId,hospital);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("hospital updated successfully"));
    }

    @DeleteMapping("/{hospitalId}")
    public ResponseEntity<ApiResponse> deleteHospital(@PathVariable Integer hospitalId){
        hospitalService.deleteHospital(hospitalId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("hospital deleted successfully"));
    }


}
