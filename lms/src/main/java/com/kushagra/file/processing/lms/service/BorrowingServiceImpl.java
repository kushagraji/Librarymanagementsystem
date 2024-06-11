package com.kushagra.file.processing.lms.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kushagra.file.processing.lms.model.Borrowing;
import com.kushagra.file.processing.lms.repository.BookRepository;
import com.kushagra.file.processing.lms.repository.BorrowingRepository;
import com.kushagra.file.processing.lms.repository.MemberRepository;

@Service
public class BorrowingServiceImpl implements BorrowingService {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	BorrowingRepository borrowingRepository;

	@Override
	public Borrowing borrowBook(int bookId, int memberId) {
		Borrowing borrowing = new Borrowing();
		borrowing.setBook(bookRepository.findById(bookId).get());
		borrowing.setMember(memberRepository.findById(memberId).get());
		borrowing.setBorrowedDate(new Date());
		return borrowingRepository.save(borrowing);
	}

	@Override
	public Borrowing returnBook(int borrowingId) {
		 Borrowing borrowing = borrowingRepository.findById(borrowingId).get();
		 borrowing.setReturnDate(new Date());
		return borrowingRepository.save(borrowing);
	}
	

}
