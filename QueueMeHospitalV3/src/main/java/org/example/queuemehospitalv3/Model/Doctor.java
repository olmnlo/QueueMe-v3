package org.example.queuemehospitalv3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(30) not null")
    private String name;

    @Column(columnDefinition = "varchar(30) not null")
    private String specialization;

    @Column(columnDefinition = "boolean default false")
    private Boolean isLeave = false;

    @ManyToOne
    @JsonIgnore
    private Department department;
}
