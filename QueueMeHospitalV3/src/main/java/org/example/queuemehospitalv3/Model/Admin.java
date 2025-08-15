package org.example.queuemehospitalv3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Setter
@Getter
public class Admin {

    @Id
    private Integer id;

    @Column(columnDefinition = "varchar(30) not null")
    private String username;

    @Column(columnDefinition = "varchar(20) not null")
    private String password;

    @Column(columnDefinition = "varchar(20) not null")
    private String role = "admin";

    @OneToOne
    @JsonIgnore
    @MapsId
    private User user;
}
