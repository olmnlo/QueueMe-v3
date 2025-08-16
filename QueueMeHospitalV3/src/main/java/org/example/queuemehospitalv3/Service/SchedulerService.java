package org.example.queuemehospitalv3.Service;

import lombok.RequiredArgsConstructor;
import org.example.queuemehospitalv3.Api.ApiException;
import org.example.queuemehospitalv3.DTO.SchedulerDTO;
import org.example.queuemehospitalv3.Model.Doctor;
import org.example.queuemehospitalv3.Model.Scheduler;
import org.example.queuemehospitalv3.Repository.DoctorRepository;
import org.example.queuemehospitalv3.Repository.SchedulerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SchedulerService {
    private final SchedulerRepository schedulerRepository;

    private final DoctorRepository doctorRepository;


    public List<Scheduler> findAllSchedules(){
        List<Scheduler> schedulers = schedulerRepository.findAll();
        if (schedulers.isEmpty()){
            throw new ApiException("no schedules found");
        }
        return schedulers;
    }

    public void assignScheduleToDoctor(SchedulerDTO schedulerDTO){
        Doctor doctor = doctorRepository.findDoctorById(schedulerDTO.getDoctorId());
        if (doctor == null){
            throw new ApiException("doctor not found");
        }
        if (doctor.getScheduler() == null){
            doctor.setScheduler(new ArrayList<>());
        }
        doctor.getScheduler().add(new Scheduler(null, schedulerDTO.getAvailableDay(),doctor));
        doctorRepository.save(doctor);
    }

    public void updateSchedule(Integer schedulerId, SchedulerDTO schedulerDTO){
        Scheduler oldScheduler = schedulerRepository.findSchedulerById(schedulerId);
        if (oldScheduler == null){
            throw new ApiException("schedule not found");
        }
        Doctor doctor = doctorRepository.findDoctorById(schedulerDTO.getDoctorId());
        if (doctor == null){
            throw new ApiException("doctor not found");
        }
        oldScheduler.setAvailableDay(schedulerDTO.getAvailableDay());
        oldScheduler.setDoctor(doctor);
        schedulerRepository.save(oldScheduler);

    }

    public void deleteScheduler(Integer schedulerId){
        Scheduler scheduler = schedulerRepository.findSchedulerById(schedulerId);
        if (scheduler == null){
            throw new ApiException("scheduler not found");
        }
        Doctor doctor = doctorRepository.findDoctorById(scheduler.getDoctor().getId());
        if (doctor == null){
            throw new ApiException("doctor not found");
        }

        scheduler.setDoctor(null);
        schedulerRepository.delete(scheduler);
        doctor.getScheduler().remove(scheduler);
        doctorRepository.save(doctor);

    }
}
