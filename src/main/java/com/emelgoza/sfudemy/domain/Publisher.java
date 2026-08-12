package com.emelgoza.sfudemy.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString(exclude = {"books"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Publisher {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @EqualsAndHashCode.Include
  private Long id;

  private String publisherName;
  private String address;
  private String city;
  private String state;
  private String zipCode;

  @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
  @Builder.Default
  private Set<Book> books = new HashSet<>();

  public void addBook(Book book) {
    this.books.add(book);
    book.setPublisher(this);
  }
}
