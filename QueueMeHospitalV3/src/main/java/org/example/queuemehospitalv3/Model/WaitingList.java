package org.example.queuemehospitalv3.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class WaitingList {

    @Id
    private Integer id;
}
