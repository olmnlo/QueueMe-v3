package org.example.queuemehospitalv3.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Scheduler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @FutureOrPresent(message = "date must be future or present")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date")
    private LocalDate availableDay;

    @NotNull(message = "doctor id is required")
    @ManyToOne
    @JsonIgnore
    private Doctor doctor;
}
