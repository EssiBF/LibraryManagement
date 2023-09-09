package ir.mapsa.librarymanagement.entity;

import ir.mapsa.librarymanagement.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "library")
public class Library extends BaseEntity<Long> {

    @Column(nullable = false)
    private String name;
    @Column
    private String address;
    @Column
    private String tel;

    @OneToMany(mappedBy = "library")
    private List<Book> bookList = new ArrayList<>();

}
