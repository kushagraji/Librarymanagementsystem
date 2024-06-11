package com.kushagra.file.processing.lms.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kushagra.file.processing.lms.model.Book;
import com.kushagra.file.processing.lms.model.Borrowing;

public interface BorrowingRepository extends JpaRepository<Borrowing, Integer> {

	List<Borrowing> findByReturnDate(Date date);

}
