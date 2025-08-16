package org.example.queuemehospitalv3.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.queuemehospitalv3.Model.Department;

@Data
@AllArgsConstructor
@Getter
@Setter
public class DoctorDTO {

    @NotEmpty(message = "name is required")
    @Size(max = 30, message = "name max length 30")
    private String name;

    @NotEmpty(message = "specialization is required")
    @Size(max = 30, message = "specialization max length 30")
    private String specialization;

    @NotNull(message = "isLeave flag is required")
    private Boolean isLeave;

    @NotNull(message = "department id is required")
    @Positive(message = "department id must be positive")
    private Integer departmentId;
}
