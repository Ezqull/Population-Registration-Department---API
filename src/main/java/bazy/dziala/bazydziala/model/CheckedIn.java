package bazy.dziala.bazydziala.model;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "checked_in")
public class CheckedIn extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "personal_data_id",
                nullable = false)
    private PersonalData personalData;

    @ManyToOne
    @JoinColumn(name = "old_address",
                nullable = true)
    private Address oldAddress;

    @ManyToOne
    @JoinColumn(name = "new_address",
                nullable = false)
    private Address newAddress;

    @Column(name = "check_in_date",
            nullable = false)
    private LocalDate checkInDate;
}
