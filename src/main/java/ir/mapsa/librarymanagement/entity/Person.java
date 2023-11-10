package ir.mapsa.librarymanagement.entity;

import ir.mapsa.librarymanagement.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person")
////Inheritance strategy
//@Inheritance(strategy = InheritanceType.JOINED)
public class Person extends BaseEntity<Long>{

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String nationalCode;
}
