package com.emelgoza.sfudemy.controller;

import com.emelgoza.sfudemy.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
  private static final int PAGE_SIZE = 10;

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @RequestMapping("/books")
  public String getBooks(Model model, @RequestParam int page) {
    model.addAttribute("books_list", bookService.findPaginated(page, PAGE_SIZE));
    model.addAttribute("books_totalPages", bookService.findTotalPages(PAGE_SIZE));
    model.addAttribute("books_currentPage", page);
    return "books";
  }
}
