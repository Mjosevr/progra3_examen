/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.Book;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author mauricio
 */
public class BookDAOimpl implements BookDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public Book save(Book book) {
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();

        return book;
    }

    @Override
    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<>();

        bookList = session.createCriteria(Book.class).list();

        return bookList;
    }

    @Override
    public boolean deleteAll() {
        boolean isDeleted = false;
        List<Book> bookList = new ArrayList<>();

        bookList = session.createCriteria(Book.class).list();
        session.beginTransaction();
        session.delete(bookList);
        isDeleted = true;
        session.getTransaction().commit();

        return isDeleted;
    }
}
