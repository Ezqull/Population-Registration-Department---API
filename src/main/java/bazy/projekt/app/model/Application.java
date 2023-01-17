package bazy.projekt.app.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "application")
public class Application extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "personal_data_id",
                referencedColumnName = "id")
    private PersonalData personalData;

    @ManyToOne
    @JoinColumn(name = "address_id",
                nullable = false)
    private Address address;

    @Column(name = "date_of_application",
            nullable = false)
    private LocalDate dateOfApplication;

    @Column(name = "result")
    @Enumerated(EnumType.STRING)
    private Result result;

    @Column(name = "justification")
    private String justification;

    @ManyToOne
    @JoinColumn(name = "submitting_user",
                nullable = false)
    private User submittingUser;
}
