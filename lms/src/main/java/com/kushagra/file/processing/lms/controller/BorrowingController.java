package com.kushagra.file.processing.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kushagra.file.processing.lms.repository.BookRepository;
import com.kushagra.file.processing.lms.repository.BorrowingRepository;
import com.kushagra.file.processing.lms.repository.MemberRepository;
import com.kushagra.file.processing.lms.service.BorrowingService;

@Controller
public class BorrowingController {
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	BorrowingRepository borrowingRepository;
	
	@Autowired
	BorrowingService borrowingservice;
	
	@GetMapping("/borrow")
	public String showBorrowForm(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		model.addAttribute("members", memberRepository.findAll());
		return "borrow_book";
		
	}
	
	@PostMapping("/borrow")
	public String borrowBook(@RequestParam int memberId, @RequestParam int bookId, Model model) {
		borrowingservice.borrowBook(bookId, memberId);
		model.addAttribute("message", "Book Borrowed Successfully");
		return "borrow_success";
	}
	
	
	@GetMapping("/return")
	public String showReturnForm(Model model) {
	model.addAttribute("borrowers",borrowingRepository.findByReturnDate(null));
		return "return_book";
		
	}
	
	@PostMapping("/return")
	public String returnBook(@RequestParam int borrowingId, Model model) {
		borrowingservice.returnBook(borrowingId);
		model.addAttribute("message", "Book returned Successfully");
		return "borrow_success";
	}
}
