package org.example.queuemehospitalv3.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.queuemehospitalv3.Api.ApiResponse;
import org.example.queuemehospitalv3.DTO.AppointmentDTO;
import org.example.queuemehospitalv3.Model.Appointment;
import org.example.queuemehospitalv3.Service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<Appointment>> getAppointments(){
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService.findAllAppointments());
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addAppointment(@Valid@RequestBody AppointmentDTO appointmentDTO){
        appointmentService.addNewAppointment(appointmentDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("appointment added successfully"));
    }

    @PutMapping("/{appointmentId}")
    public ResponseEntity<ApiResponse> updateAppointment(@PathVariable Integer appointmentId ,@Valid@RequestBody AppointmentDTO appointmentDTO){
        appointmentService.updateAppointment(appointmentId,appointmentDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("appointment updated successfully"));
    }

    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<ApiResponse> deleteAppointment(@PathVariable Integer appointmentId){
        appointmentService.deleteAppointment(appointmentId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("appointment deleted successfully"));
    }
}
