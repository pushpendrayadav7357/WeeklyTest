package com.example.demo.Service;

import com.example.demo.Entity.Book;
import com.example.demo.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    // Create a new book
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // Retrieve a book by ID
    public Optional<Book> getBookById(String bookId) {
        return bookRepository.findById(bookId);
    }

    // Retrieve all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Update a book
    public Book updateBook(String bookId, Book updatedBook) {
        if (bookRepository.existsById(bookId)) {
            updatedBook.setID(bookId);
            return bookRepository.save(updatedBook);
        } else {
            // Handle not found or other appropriate error handling
            return null;
        }
    }

    // Delete a book by ID
    public void deleteBook(String bookId) {
        bookRepository.deleteById(bookId);
    }
}