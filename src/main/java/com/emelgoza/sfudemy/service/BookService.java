package com.emelgoza.sfudemy.service;

import com.emelgoza.sfudemy.domain.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {

  Iterable<Book> findAll();
}
