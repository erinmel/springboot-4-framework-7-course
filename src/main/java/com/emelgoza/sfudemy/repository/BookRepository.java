package com.emelgoza.sfudemy.repository;

import com.emelgoza.sfudemy.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {}
