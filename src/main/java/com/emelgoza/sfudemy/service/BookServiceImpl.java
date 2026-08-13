package com.emelgoza.sfudemy.service;

import com.emelgoza.sfudemy.domain.Book;
import com.emelgoza.sfudemy.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;

  public BookServiceImpl(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public Iterable<Book> findAll() {
    return bookRepository.findAll();
  }

  @Override
  public Iterable<Book> findPaginated(int page, int size) {
    return bookRepository.findPaginated(page, size);
  }

  @Override
  public Integer findTotalPages(long size) {
    return (int) Math.ceil((double) bookRepository.count() / size);
  }
}
