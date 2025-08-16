package org.example.queuemehospitalv3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "date not null")
    private LocalDateTime appointmentDate;

    @Column(columnDefinition = "text")
    private String description = "";

    @Column(columnDefinition = "varchar(15) not null")
    private String status = "waiting";

    @ManyToOne
    @JsonIgnore
    private User user;

    @ManyToOne
    @JsonIgnore
    private Doctor doctor;

}
