package com.example.app.Task912.library;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/library")
public class BookController {

    private final BookRepo bookRepo;

    public BookController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping("/main")
    public String booksMain(Model model) {
        model.addAttribute("books", bookRepo.findAll());
        return "/library/main";
    }

    @GetMapping("/diagram")
    public String diagram(Model model) {
        model.addAttribute("books", bookRepo.findAll());
        return "/library/diagram";
    }

    @GetMapping("/book")
    public String book(@RequestParam(name = "id", required = false) Long id,
                      Model model){
        Book book;
        if (id!=null) {
            book = bookRepo.getReferenceById(id);
        } else {
            book = new Book();
        }
        model.addAttribute("book", book);
        return "/library/book";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") Book book){
        bookRepo.save(book);
        return "redirect:/library/main";
    }

    @PostMapping("/delete")
    public String delBook(@RequestParam("id") Long id){
        bookRepo.deleteById(id);
        return "redirect:/library/main";
    }
}
