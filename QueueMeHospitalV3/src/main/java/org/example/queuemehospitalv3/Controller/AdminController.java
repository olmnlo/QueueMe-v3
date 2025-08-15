package org.example.queuemehospitalv3.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.queuemehospitalv3.Api.ApiResponse;
import org.example.queuemehospitalv3.DTO.AdminDTO;
import org.example.queuemehospitalv3.Model.Admin;
import org.example.queuemehospitalv3.Service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/admin")
public class AdminController {

    private final AdminService adminService;

    @GetMapping
    public ResponseEntity<List<Admin>> getAdmins(){
        return ResponseEntity.status(HttpStatus.OK).body(adminService.getAllAdmins());
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addAdmin(@Valid@RequestBody AdminDTO adminDTO){
        adminService.addNewAdmin(adminDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("admin added successfully"));
    }

    @DeleteMapping("/{adminId}")
    public ResponseEntity<ApiResponse> deleteAdmin (@PathVariable Integer adminId){
        adminService.deleteAdmin(adminId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("admin deleted successfully"));
    }
}
