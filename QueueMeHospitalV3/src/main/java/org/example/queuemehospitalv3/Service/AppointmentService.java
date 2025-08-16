package org.example.queuemehospitalv3.Service;

import lombok.RequiredArgsConstructor;
import org.example.queuemehospitalv3.Api.ApiException;
import org.example.queuemehospitalv3.DTO.AppointmentDTO;
import org.example.queuemehospitalv3.Model.Appointment;
import org.example.queuemehospitalv3.Model.Doctor;
import org.example.queuemehospitalv3.Model.User;
import org.example.queuemehospitalv3.Repository.AppointmentRepository;
import org.example.queuemehospitalv3.Repository.DoctorRepository;
import org.example.queuemehospitalv3.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    private final UserRepository userRepository;
    private final DoctorRepository doctorRepository;

    public List<Appointment> findAllAppointments(){
        List<Appointment> appointments = appointmentRepository.findAll();
        if (appointments.isEmpty()){
            throw new ApiException("appointments not found");
        }
        return appointments;
    }

    public void addNewAppointment(AppointmentDTO appointmentDTO){
        User user = userRepository.findUserById(appointmentDTO.getUserId());
        if (user == null){
            throw new ApiException("user not found");
        }

        Doctor doctor = isExistDoctor(appointmentDTO);

        Appointment appointment = new Appointment(null,appointmentDTO.getAppointmentDate(),"","waiting",user,doctor);
        appointmentRepository.save(appointment);
    }

    public void updateAppointment(Integer appointmentId, AppointmentDTO appointmentDTO){
        Appointment oldAppointment = appointmentRepository.findAppointmentById(appointmentId);
        if (oldAppointment == null){
            throw new ApiException("appointment not found");
        }
        Doctor doctor = isExistDoctor(appointmentDTO);

        User user = userRepository.findUserById(appointmentDTO.getUserId());
        if (user == null){
            throw new ApiException("user not found");
        }

        oldAppointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
        oldAppointment.setUser(user);
        oldAppointment.setDoctor(doctor);
        appointmentRepository.save(oldAppointment);
    }

    public void deleteAppointment(Integer appointmentId){
        Appointment appointment = appointmentRepository.findAppointmentById(appointmentId);
        if (appointment == null){
            throw new ApiException("appointment not found");
        }
        appointmentRepository.delete(appointment);
    }


    private Doctor isExistDoctor(AppointmentDTO appointmentDTO) {
        Doctor doctor = doctorRepository.findDoctorById(appointmentDTO.getDoctorId());
        if (doctor == null){
            throw new ApiException("doctor not found");
        }
        if (doctor.getIsLeave()){
            throw new ApiException("doctor in leave");
        }
        if (!doctorRepository.findDoctorAvailableDay(appointmentDTO.getDoctorId()).contains(appointmentDTO.getAppointmentDate().toLocalDate())){
            throw new ApiException("doctor not available in this day");
        }
        return doctor;
    }
}
