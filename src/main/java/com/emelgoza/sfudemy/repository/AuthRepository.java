package com.emelgoza.sfudemy.repository;

import com.emelgoza.sfudemy.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthRepository extends CrudRepository<Author, Long> {}
