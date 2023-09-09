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
@Table(name = "borrow")
public class Borrow extends BaseEntity<Long> {
    @Column
    private LocalDate dateOfIssue;

    @Column
    private LocalDate dueDate;

    @Column
    private LocalDate returnedDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(optional = false)
    @JoinColumn(name = "member_id")
    private Member member;

}
