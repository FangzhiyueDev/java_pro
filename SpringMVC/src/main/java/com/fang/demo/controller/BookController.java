package com.fang.demo.controller;


import com.fang.demo.model.Book;
import com.fang.demo.model.Category;
import com.fang.demo.service.BookService;
import com.fang.demo.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 书籍管理的测试demo
 * 这个demo只是实现了spring-mvc的整合,并没有整合mybatis,
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;


    @RequestMapping(value = "/book_input")
    public String inputBook(Model model) {
        List<Category> categories = bookService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("book", new Book());
        return "BookAndForm";
    }


    @RequestMapping(value = "/book_edit/{id}")
    public String editBook(Model model, @PathVariable long id) {

        List<Category> categories = bookService.getAllCategories();

        model.addAttribute("categories", categories);

        Book book = bookService.get(id);

        model.addAttribute("book", book);
        return "BookEditForm";
    }


    @RequestMapping(value = "/book_save")
    public String saveBook(@ModelAttribute Book book) {
        Category category = bookService.getCategory(book.getCategory().getId());
        book.setCategory(category);
        bookService.save(book);
        return "redirect:/book_list";
    }


    /**
     * 更新书籍信息
     *
     * @param book
     * @return
     */
    @RequestMapping(value = "/book_update")
    public String updateBook(@ModelAttribute Book book) {
        Category category = bookService.getCategory(book.getCategory().getId());
        book.setCategory(category);
        bookService.update(book);
        return "redirect:/book_list";
    }

    /**
     * 获得所有的数据信息
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/book_list")
    public String listBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        System.out.print("书籍的长度为" + books.size());
        model.addAttribute("books", books);
        return "BookList";
    }

    /**
     * 获得所有的数据信息
     *
     * @return
     */
    @RequestMapping(value = "/book_del/{id}")
    public String delBook(@PathVariable long id) {
        bookService.delBook(id);
        return "redirect:/book_list";
    }


}
