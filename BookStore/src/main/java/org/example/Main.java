package org.example;

import org.apache.log4j.Logger;
import org.example.config.AppConfig;
import org.example.config.HibernateConfig;
import org.example.dao.BookDao;
import org.example.model.Book;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Date;
import java.util.List;

public class Main {
    final static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Class<?>[] configurations = new Class<?>[] {AppConfig.class, HibernateConfig.class};
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(configurations);

//        for (String s : context.getBeanDefinitionNames()) {
//            System.out.println(s);
//        }

        BookDao bookDao = (BookDao)context.getBean("bookDao");

        Book book1 = new Book();
        book1.setTitle("Alice in Wonderland");
        book1.setAuthorId(1);
        book1.setPublisherId(1);
        book1.setISBN("9780099512073");
        book1.setYear(Date.valueOf("2008-01-01"));
        book1.setTypeId(1);
        bookDao.create(book1);

        List<Book> books = bookDao.getBooks();
        for (Book b : books) {
            log.info(b.toString() + "\n\n");
        }
    }

}
