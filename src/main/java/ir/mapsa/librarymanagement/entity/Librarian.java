package ir.mapsa.librarymanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "librarian")
public class Librarian extends Person {

    @Column(nullable = false)
    private String personnelCode;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

}
