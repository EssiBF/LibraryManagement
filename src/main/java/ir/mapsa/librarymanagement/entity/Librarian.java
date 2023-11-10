package ir.mapsa.librarymanagement.entity;

import ir.mapsa.librarymanagement.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "librarian")
public class Librarian extends BaseEntity<Long> {

    @Column(nullable = false)
    private String personnelCode;

    @Column(nullable = false)
    private LocalDate hireDate;

    @OneToOne(optional = false)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;
}
