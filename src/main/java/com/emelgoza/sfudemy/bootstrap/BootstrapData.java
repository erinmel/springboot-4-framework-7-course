package com.emelgoza.sfudemy.bootstrap;

import com.emelgoza.sfudemy.domain.Author;
import com.emelgoza.sfudemy.domain.Book;
import com.emelgoza.sfudemy.domain.Publisher;
import com.emelgoza.sfudemy.repository.AuthorRepository;
import com.emelgoza.sfudemy.repository.BookRepository;
import com.emelgoza.sfudemy.repository.PublisherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BootstrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public BootstrapData(
      AuthorRepository authorRepository,
      BookRepository bookRepository,
      PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Author eric = Author.builder().firstName("Eric").lastName("Evans").build();
    Author rod = Author.builder().firstName("Rod").lastName("Johnson").build();
    Book ddd = Book.builder().title("Domain Driver Design").isbn("123456").build();
    Book noEJB = Book.builder().title("J2EE Development without EJB").isbn("56789").build();
    Publisher publisher =
        Publisher.builder()
            .publisherName("Awesome Publisher")
            .address("123 Main St")
            .city("Cityville")
            .state("CA")
            .zipCode("12345")
            .build();

    eric = authorRepository.save(eric);
    rod = authorRepository.save(rod);
    ddd = bookRepository.save(ddd);
    noEJB = bookRepository.save(noEJB);
    publisher = publisherRepository.save(publisher);

    ddd.addPublisher(publisher);
    noEJB.addPublisher(publisher);

    bookRepository.save(ddd);
    bookRepository.save(noEJB);

    eric.addBook(ddd);
    rod.addBook(noEJB);

    authorRepository.save(eric);
    authorRepository.save(rod);
    bookRepository.save(ddd);
    bookRepository.save(noEJB);

    log.info("Saved in Bootstrap");
    log.info("Number of Authors: {}", authorRepository.count());
    log.info("Number of Books: {}", bookRepository.count());
    log.info(
        "In Memory Publisher {} has {} books",
        publisher.getPublisherName(),
        publisher.getBooks().stream().map(Book::getTitle).toList());
  }
}
