package ru.netology.hibernate.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Embeddable
public class PersonsPrimaryKey implements Serializable {
    private String name;
    private String surname;
    private int age;
}
