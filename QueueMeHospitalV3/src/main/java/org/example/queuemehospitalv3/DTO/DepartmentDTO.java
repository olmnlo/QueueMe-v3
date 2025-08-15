package org.example.queuemehospitalv3.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class DepartmentDTO {

    @NotEmpty(message = "name is required")
    @Size(max = 30, message = "name max length 30")
    private String name;

    @NotEmpty(message = "description is required")
    private String description;

    private Integer hospitalId;
}
