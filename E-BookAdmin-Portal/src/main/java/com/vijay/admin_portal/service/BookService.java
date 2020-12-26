package com.vijay.admin_portal.service;

import java.util.List;

import com.vijay.admin_portal.domain.Book;

public interface BookService {
	Book save(Book book);

	List<Book> findAll();
	
	Book findOne(Long id);
	
	void removeOne(Long id);

}
