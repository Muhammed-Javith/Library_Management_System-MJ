package com.mjcode.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjcode.lms.entity.Reader;
import com.mjcode.lms.repository.ReaderRepository;

@Service
public class ReaderService {

	@Autowired
	private ReaderRepository readerRepository;

	public List<Reader> findAll() {
		return readerRepository.findAll();
	}

	public Reader save(Reader reader) {
		return readerRepository.save(reader);
	}
}