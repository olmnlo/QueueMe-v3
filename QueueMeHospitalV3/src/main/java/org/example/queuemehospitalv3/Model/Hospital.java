package org.example.queuemehospitalv3.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @NotNull(message = "latitude is required")
    @DecimalMin(value = "-90.0", message = "latitude must be >= -90")
    @DecimalMax(value = "90.0", message = "latitude must be <= 90")
    private Double latitude;

    @NotNull(message = "longitude is required")
    @DecimalMin(value = "-180.0", message = "longitude must be >= -180")
    @DecimalMax(value = "180.0", message = "longitude must be <= 180")
    private Double longitude;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<Department> departments = new ArrayList<>();
}
