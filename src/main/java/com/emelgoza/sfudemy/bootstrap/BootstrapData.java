package com.emelgoza.sfudemy.bootstrap;

import com.emelgoza.sfudemy.domain.Author;
import com.emelgoza.sfudemy.domain.Book;
import com.emelgoza.sfudemy.domain.Publisher;
import com.emelgoza.sfudemy.repository.AuthRepository;
import com.emelgoza.sfudemy.repository.BookRepository;
import com.emelgoza.sfudemy.repository.PublisherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BootstrapData implements CommandLineRunner {

  private final AuthRepository authRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public BootstrapData(
      AuthRepository authRepository,
      BookRepository bookRepository,
      PublisherRepository publisherRepository) {
    this.authRepository = authRepository;
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

    Author ericSaved = authRepository.save(eric);
    Author rodSaved = authRepository.save(rod);
    Book dddSaved = bookRepository.save(ddd);
    Book noEJBSaved = bookRepository.save(noEJB);
    Publisher publisherSaved = publisherRepository.save(publisher);

    ericSaved.getBooks().add(dddSaved);
    rodSaved.getBooks().add(noEJBSaved);

    authRepository.save(ericSaved);
    authRepository.save(rodSaved);

    log.info("Saved in Bootstrap");
    log.info("Number of Authors: {}", authRepository.count());
    log.info("Number of Books: {}", bookRepository.count());
    log.info("Number of Publishers: {}", publisherRepository.count());
    log.info("Number of Books for Eric: {}", ericSaved.getBooks().size());
    log.info("Number of Books for Rod: {}", rodSaved.getBooks().size());
  }
}
