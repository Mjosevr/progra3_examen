/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.BookType;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author mauricio
 */
public class BookTypeDAOimpl implements BookTypeDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public BookType save(BookType bookType) {
        session.beginTransaction();
        session.save(bookType);
        session.getTransaction().commit();

        return bookType;
    }

    @Override
    public List<BookType> findAll() {
        List<BookType> bookTypeList = new ArrayList<>();

        bookTypeList = session.createCriteria(BookType.class).list();

        return bookTypeList;
    }

    @Override
    public boolean deleteAll() {
        boolean isDeleted = false;
        List<BookType> bookTypeList = new ArrayList<>();

        bookTypeList = session.createCriteria(BookType.class).list();
        session.beginTransaction();
        session.delete(bookTypeList);
        isDeleted = true;
        session.getTransaction().commit();

        return isDeleted;
    }
}
