package bazy.projekt.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "address")
public class Address extends BaseEntity{

    @Column(name = "street",
            nullable = false,
            length = 50)
    private String street;

    @Column(name = "city",
            length = 30)
    private String city;

    @Column(name = "state",
            nullable = false,
            length = 20)
    private String state;

    @Column(name = "postal_code",
            nullable = false,
            length = 5,
            columnDefinition = "VARCHAR(5)")
    private String postalCode;

    @Column(name = "country",
            nullable = false,
            length = 20)
    private String country;

    @JsonIgnore
    @OneToMany(mappedBy = "oldAddress",
            cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<CheckedIn> oldCheckIns = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "newAddress",
            cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<CheckedIn> newCheckIns = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "address",
               cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Application> applications = new ArrayList<>();

}
