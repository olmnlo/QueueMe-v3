package org.example.queuemehospitalv3.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.queuemehospitalv3.Api.ApiResponse;
import org.example.queuemehospitalv3.DTO.SchedulerDTO;
import org.example.queuemehospitalv3.Model.Scheduler;
import org.example.queuemehospitalv3.Service.SchedulerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/scheduler")
public class SchedulerController {

    private final SchedulerService schedulerService;


    @GetMapping
    public ResponseEntity<List<Scheduler>> getAllScheduler(){
        return ResponseEntity.status(HttpStatus.OK).body(schedulerService.findAllSchedules());
    }

    @PostMapping
    public ResponseEntity<ApiResponse> assignScheduler(@Valid@RequestBody SchedulerDTO schedulerDTO){
        schedulerService.assignScheduleToDoctor(schedulerDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("schedule assigned successfully"));
    }

    @PutMapping("/{schedulerId}")
    public ResponseEntity<ApiResponse> updateScheduler(@PathVariable Integer schedulerId, @Valid@RequestBody SchedulerDTO schedulerDTO){
        schedulerService.updateSchedule(schedulerId,schedulerDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("schedule updated successfully"));
    }

    @DeleteMapping("/{schedulerId}")
    public ResponseEntity<ApiResponse> deleteScheduler(@PathVariable Integer schedulerId){
        schedulerService.deleteScheduler(schedulerId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("schedule delete successfully"));
    }

}
