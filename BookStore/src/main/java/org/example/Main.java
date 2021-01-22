package org.example;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.example.config.AppConfig;
import org.example.config.HibernateConfig;
import org.example.controller.BookCoverController;
import org.example.dao.BookDao;
import org.example.model.Book;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class Main {
    final static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        Class<?>[] configurations = new Class<?>[] {AppConfig.class, HibernateConfig.class};
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(configurations);

        BookDao bookDao = (BookDao)context.getBean("bookDao");

//        Book book1 = new Book();
//        book1.setTitle("Enhanced Alice in Wonderland");
//        book1.setAuthorId(1);
//        book1.setPublisherId(1);
//        book1.setISBN("9780099512073");
//        book1.setYear(Date.valueOf("2008-01-01"));
//        book1.setTypeId(1);
//        book1.setCoverUrl("C:/Dropbox/Java/server/BookStore/covers/1.jpg");
//        bookDao.create(book1);
//        bookDao.update(book1);
//
//        Book book2 = new Book();
//        book2.setTitle("Me in Wonderland");
//        book2.setAuthorId(1);
//        book2.setPublisherId(1);
//        book2.setISBN("9780099512074");
//        book2.setYear(Date.valueOf("2008-01-01"));
//        book2.setTypeId(1);
//        book2.setCoverUrl("C:/Dropbox/Java/server/BookStore/covers/2.jpg");
//        bookDao.create(book2);

//        boolean isDeleted = bookDao.deleteByISBN("9780099512080");

        List<Book> books = bookDao.getBooks();
        for (Book b : books) {
            log.info(b.toString() + "\n\n");
        }

    }

}
