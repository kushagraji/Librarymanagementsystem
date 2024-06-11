package com.kushagra.file.processing.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kushagra.file.processing.lms.model.Book;
import com.kushagra.file.processing.lms.repository.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/")
	public String listBook(Model model) {
		model.addAttribute("books", bookRepository.findAll());
	    return "books";	
	}
	
	@GetMapping("/book/new")
	public String showCreateForm(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "create_book";
	}
	
	@PostMapping("/books")
	public String saveBook(Book book) {
		bookRepository.save(book);
		return "redirect:/";
		
	}
	
	@GetMapping("/book/delete/{id}")
	public String deleteBook(@PathVariable("id") int id, Model model) {
		
		bookRepository.deleteById(id);
		model.addAttribute("message", "delete successfuly");
		return "delete_success";
		
	}
	
	@GetMapping("/book/edit/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		
		model.addAttribute("book", bookRepository.findById(id));
		return "update_book";
		
	}
	
	@PostMapping("/books/update")
	public String updateBook(Book book) {
		
		bookRepository.save(book);
		return "redirect:/";
		
	}
	
	

}
