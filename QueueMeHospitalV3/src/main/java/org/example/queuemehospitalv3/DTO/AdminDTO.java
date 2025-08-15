package org.example.queuemehospitalv3.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class AdminDTO {

    @Size(max = 20, message = "role max length 20")
    @Pattern(regexp = "^(admin)$", message = "role must be admin")
    private String role;

    private Integer userId;
}
