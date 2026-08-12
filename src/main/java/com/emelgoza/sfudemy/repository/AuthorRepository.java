package com.emelgoza.sfudemy.repository;

import com.emelgoza.sfudemy.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {}
