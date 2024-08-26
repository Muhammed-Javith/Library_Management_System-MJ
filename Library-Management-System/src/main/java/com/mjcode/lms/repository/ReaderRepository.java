package com.mjcode.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mjcode.lms.entity.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
}