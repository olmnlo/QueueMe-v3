package org.example.queuemehospitalv3.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Getter
@Setter
public class SchedulerDTO {

    @FutureOrPresent(message = "date must be future or present")
    @NotNull(message = "available day is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate availableDay;

    @NotNull(message = "doctor id is required")
    @Positive(message = "doctor id must be positive")
    private Integer doctorId;
}
