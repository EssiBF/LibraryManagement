package ir.mapsa.librarymanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
public class Member extends Person {

    @Column(nullable = false)
    private String memberNo;

    @Column(nullable = false)
    private LocalDate dateOfMembership;

    @Column(nullable = false)
    private LocalDate dateOfExpiration;

    @OneToMany(mappedBy = "member")
    private List<Borrow> borrowList = new ArrayList<>();
}
