package org.example.queuemehospitalv3.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Getter
@Setter
public class AppointmentDTO {
    @NotNull(message = "appointment date is required")
    @FutureOrPresent(message = "appointment date must be in future")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime appointmentDate;


    @NotNull(message = "user id is required")
    @Positive(message = "user id must be positive")
    private Integer userId;

    @NotNull(message = "doctor id is required")
    @Positive(message = "doctor id must be positive")
    private Integer doctorId;
}
