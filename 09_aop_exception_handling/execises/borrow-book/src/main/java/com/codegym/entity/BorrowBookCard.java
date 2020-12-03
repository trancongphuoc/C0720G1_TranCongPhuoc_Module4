package com.codegym.entity;


import javax.persistence.*;
import java.util.Set;

@Entity(name = "borrow_book_card")
public class BorrowBookCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private Member member;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "day_start_borrow", columnDefinition = "DATE")
    private String dayStartBorrow;

    @Column(name = "day_end_borrow", columnDefinition = "DATE")
    private String dayEndBorrow;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public BorrowBookCard() {
    }

    public BorrowBookCard(Integer id, Member member, Boolean status, String dayStartBorrow, String dayEndBorrow, Book book) {
        this.id = id;
        this.member = member;
        this.status = status;
        this.dayStartBorrow = dayStartBorrow;
        this.dayEndBorrow = dayEndBorrow;
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDayStartBorrow() {
        return dayStartBorrow;
    }

    public void setDayStartBorrow(String dayStartBorrow) {
        this.dayStartBorrow = dayStartBorrow;
    }

    public String getDayEndBorrow() {
        return dayEndBorrow;
    }

    public void setDayEndBorrow(String dayEndBorrow) {
        this.dayEndBorrow = dayEndBorrow;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
