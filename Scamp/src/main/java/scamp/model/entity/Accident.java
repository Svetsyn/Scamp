package scamp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scamp.model.enumerated.AccidentType;

import java.sql.Blob;
import java.util.List;

@Entity
@Table(name = "accidents")
@Getter
@Setter
@NoArgsConstructor
public class Accident extends BaseEntity {

    @Enumerated(value = EnumType.STRING)
    private AccidentType type;

    @Column(name = "city",nullable = false)
    private String city;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Image> images;

}
