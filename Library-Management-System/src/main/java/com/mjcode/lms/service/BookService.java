package com.mjcode.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjcode.lms.entity.Book;
import com.mjcode.lms.entity.Reader;
import com.mjcode.lms.repository.BookRepository;
import com.mjcode.lms.repository.ReaderRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private ReaderRepository readerRepository;

	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	public Book findById(Long id) {
		return bookRepository.findById(id).orElse(null);
	}

	public Book save(Book book) {
		return bookRepository.save(book);
	}

	public void deleteById(Long id) {
		bookRepository.deleteById(id);
	}

	public Book borrowBook(Long bookId, Long readerId) {
		Book book = findById(bookId);
		Reader reader = readerRepository.findById(readerId).orElse(null);

		if (book != null && !book.isBorrowed() && reader != null) {
			book.setBorrowedBy(reader);
			book.setBorrowed(true);
			return save(book);
		}
		// Handle errors (e.g., book not found, book already borrowed, user not found)
		return null;
	}

	public Book returnBook(Long bookId) {
		Book book = findById(bookId);
		if (book != null && book.isBorrowed()) {
			book.setBorrowedBy(null);
			book.setBorrowed(false);
			return save(book);
		}
		// Handle errors (e.g., book not found, book not borrowed)
		return null;
	}
}