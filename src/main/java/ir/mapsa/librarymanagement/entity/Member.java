package ir.mapsa.librarymanagement.entity;

import ir.mapsa.librarymanagement.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member")
public class Member extends BaseEntity<Long> {

    @Column(nullable = false)
    private String memberNo;

    @Column(nullable = false)
    private LocalDate dateOfMembership;

    @Column(nullable = false)
    private LocalDate dateOfExpiration;

    @OneToMany(mappedBy = "member")
    private List<Borrow> borrowList = new ArrayList<>();

    @OneToOne(optional = false)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;
}
