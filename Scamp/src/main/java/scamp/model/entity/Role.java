package scamp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scamp.model.enumerated.RoleName;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
public class Role extends BaseEntity{

    @Enumerated(value = EnumType.STRING)
    private RoleName roleName;
    @Column(name = "name", columnDefinition = "TEXT")
    private String description;
}
