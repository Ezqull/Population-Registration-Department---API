package bazy.projekt.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @Column(updatable = false,
            nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY,
                    generator = "native")
    @GenericGenerator(name = "native",
                      strategy = "native")
    private Long id;
}
