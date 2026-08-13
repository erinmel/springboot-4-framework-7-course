package com.emelgoza.sfudemy.repository;

import com.emelgoza.sfudemy.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

  @Query(value = "SELECT * FROM book LIMIT ?2 OFFSET (?1 - 1) * ?2", nativeQuery = true)
  Iterable<Book> findPaginated(int page, int size);
}
