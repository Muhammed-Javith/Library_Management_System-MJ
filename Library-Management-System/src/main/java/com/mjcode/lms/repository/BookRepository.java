package com.mjcode.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mjcode.lms.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}