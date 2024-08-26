package com.mjcode.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjcode.lms.entity.Reader;
import com.mjcode.lms.service.ReaderService;

@RestController
@RequestMapping("/api/readers")
public class ReaderController {
	@Autowired
	private ReaderService readerService;

	@GetMapping
	public List<Reader> getAllReaders() {
		return readerService.findAll();
	}

	@PostMapping
	public Reader addReader(@RequestBody Reader reader) {
		return readerService.save(reader);
	}
}