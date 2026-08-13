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
  private static final String[] BOOK_NAMES_PREFIX = {
    "The Great Adventure of ",
    "The Mystery of ",
    "The Secret Life of ",
    "The Chronicles of ",
    "The Legend of "
  };
  private static final String[] BOOK_NAMES_SUFFIX = {
    "the Lost City",
    "the Hidden Treasure",
    "the Forgotten Kingdom",
    "the Enchanted Forest",
    "the Time Traveler",
    "the Haunted Mansion",
    "the Magical Island",
    "the Ancient Artifact",
    "the Cursed Amulet",
    "the Phantom Ship",
    "the Secret Society"
  };

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

    for (int i = 0; i < 23; i++) {
      String randomPrefix = BOOK_NAMES_PREFIX[(int) (Math.random() * BOOK_NAMES_PREFIX.length)];
      String randomSuffix = BOOK_NAMES_SUFFIX[(int) (Math.random() * BOOK_NAMES_SUFFIX.length)];
      String bookTitle = randomPrefix + " " + randomSuffix;
      Book randomBook = Book.builder().title(bookTitle).isbn(String.valueOf(100000 + i)).build();
      bookRepository.save(randomBook);
    }

    log.info("Saved in Bootstrap");
    log.info("Number of Authors: {}", authorRepository.count());
    log.info("Number of Books: {}", bookRepository.count());
    log.info(
        "In Memory Publisher {} has {} books",
        publisher.getPublisherName(),
        publisher.getBooks().stream().map(Book::getTitle).toList());
  }
}
