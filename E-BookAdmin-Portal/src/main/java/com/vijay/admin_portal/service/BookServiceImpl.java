package com.vijay.admin_portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.admin_portal.domain.Book;
import com.vijay.admin_portal.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book save(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return (List<Book>) bookRepository.findAll();
	}

	@Override
	public Book findOne(Long id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id).get();
	}

	@Override
	public void removeOne(Long id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);

	}

}
