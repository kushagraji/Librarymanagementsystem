package com.kushagra.file.processing.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kushagra.file.processing.lms.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	void deleteByTitle(String id);

}
