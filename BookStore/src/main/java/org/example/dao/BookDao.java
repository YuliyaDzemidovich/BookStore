package org.example.dao;

import org.example.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookDao {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Book> getBooks() {
        Session session = sessionFactory.openSession();
        String hql = "from Book";
        Query query = session.createQuery(hql);
        List<Book> books = query.list();
        session.close();
        return books;
    }

    public boolean create(Book book) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(book);
            tx.commit();
            return true;
        } catch (Exception e){
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            session.close();
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
