package bazy.dziala.bazydziala.model;

import bazy.dziala.bazydziala.model.BaseEntity;
import bazy.dziala.bazydziala.model.PersonalData;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "electoral_register")
public class ElectoralRegister extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_data_id",
                referencedColumnName = "id")
    private PersonalData personalData;

    @Column(name = "date_of_receipt_of_voting_rights",
            nullable = false)
    private LocalDate dateOfReceipt;

    @Column(name = "constituency",
            nullable = false,
            length = 40)
    private String constituency;
}
