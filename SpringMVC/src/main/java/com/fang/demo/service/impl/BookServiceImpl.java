package com.fang.demo.service.impl;


import com.fang.demo.model.Book;
import com.fang.demo.model.Category;
import com.fang.demo.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {


    private List<Category> categories;
    private List<Book> books;

    public BookServiceImpl() {
        categories = new ArrayList<>();
        Category category1 = new Category(1, "computing");
        Category category2 = new Category(2, "Travel");
        Category category3 = new Category(3, "Health");
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        books = new ArrayList<>();
        books.add(new Book(1l, "9898897897", "xiaoFangFang", category1, "fangfangfang"));
        books.add(new Book(2L, "464343434", "C语言程序设计", category2, "jianguo"));
        books.add(new Book(3l, "64363464", "javaScript程序设计", category3, "nigulas"));


    }

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public Category getCategory(int id) {

        for (Category category : categories) {

            if (category.getId() == id) {
                return category;
            }

        }
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Book save(Book book) {
        book.setId(getNextId());
        books.add(book);
        return book;
    }

    @Override
    public Book update(Book book) {

        for (int i = 0; i < books.size(); i++) {

            if (books.get(i).getId() == book.getId()) {
                books.set(i, book);
                return book;
            }
        }
        return book;
    }

    @Override
    public Book get(long id) {

        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }

        return null;
    }

    @Override
    public long getNextId() {

        long max = 0;
        for (Book book : books) {
            if (book.getId() > max) {
                max = book.getId();
            }
        }
        return max + 1;
    }

    @Override
    public void delBook(long id) {
        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                return;
            }
        }
    }
}
