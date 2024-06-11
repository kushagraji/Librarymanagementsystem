package com.kushagra.file.processing.lms.service;

import com.kushagra.file.processing.lms.model.Borrowing;

public interface BorrowingService {
	
	Borrowing borrowBook(int bookId, int memberId);
	
	Borrowing returnBook(int borrowingId);

}
