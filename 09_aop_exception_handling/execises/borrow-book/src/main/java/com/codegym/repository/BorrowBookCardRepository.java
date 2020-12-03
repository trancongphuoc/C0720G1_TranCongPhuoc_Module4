package com.codegym.repository;

import com.codegym.entity.BorrowBookCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowBookCardRepository extends JpaRepository<BorrowBookCard, Integer> {
}
