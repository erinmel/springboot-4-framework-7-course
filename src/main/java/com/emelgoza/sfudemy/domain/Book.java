package com.emelgoza.sfudemy.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString(exclude = {"authors", "publisher"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @EqualsAndHashCode.Include
  private Long id;

  private String title;
  private String isbn;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "author_book",
      joinColumns = @JoinColumn(name = "book_id"),
      inverseJoinColumns = @JoinColumn(name = "author_id"))
  @Builder.Default
  private Set<Author> authors = new HashSet<>();

  @ManyToOne
  @JoinColumn(name = "publisher_id")
  private Publisher publisher;

  public void addAuthor(Author author) {
    this.authors.add(author);
    author.getBooks().add(this);
  }

  public void addPublisher(Publisher publisher) {
    this.publisher = publisher;
    publisher.getBooks().add(this);
  }
}
