package com.vijay.admin_portal.repository;

import org.springframework.data.repository.CrudRepository;

import com.vijay.admin_portal.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
