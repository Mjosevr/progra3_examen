/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.service;

import ac.cr.una.backend.dao.BookDAO;
import ac.cr.una.backend.model.Book;
import java.util.List;

/**
 *
 * @author mauricio
 */
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;

    public BookServiceImpl() {
    }

    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public float totalPriceAll() {
        float totalPrice = 0;
        int i = 0;
        while (findAll().listIterator(i).hasNext()) {
            totalPrice = findAll().indexOf(this.findAll().listIterator(++i)) + findAll().indexOf(this.findAll().listIterator(i));
            i++;
        }
        return totalPrice;
    }

    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookDAO.save(book);
    }

    @Override
    public boolean deleteAll() {
        return bookDAO.deleteAll();
    }

    public BookDAO getBookDAO() {
        return bookDAO;
    }

    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

}
