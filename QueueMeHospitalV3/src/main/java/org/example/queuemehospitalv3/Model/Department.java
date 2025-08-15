package org.example.queuemehospitalv3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(30) not null")
    private String name;


    @Column(columnDefinition = "TEXT NOT NULL")
    private String description;

    @ManyToOne
    @JsonIgnore
    private Hospital hospital;
}
