/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.webservice;

import ac.cr.una.backend.dao.AuthorContactDAOimpl;
import ac.cr.una.backend.dao.AuthorDAOimpl;
import ac.cr.una.backend.dao.BookDAO;
import ac.cr.una.backend.dao.BookDAOimpl;
import ac.cr.una.backend.model.AuthorContact;
import ac.cr.una.backend.model.Book;
import ac.cr.una.backend.service.AuthorServiceImpl;
import ac.cr.una.backend.service.BookService;
import ac.cr.una.backend.service.BookServiceImpl;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author mauricio
 */
public class BookWebService {

    private BookDAO bookDAO;
    private BookService bookService;
    @Context
    UriInfo context;

    public BookWebService() {
    }

    /**
     *
     * @return result
     */
    @DELETE
    @Path("/")
    public boolean deleteAll() {
        boolean result;
        bookDAO = new BookDAOimpl();
        bookService = new BookServiceImpl(bookDAO);

        result = bookService.deleteAll();

        return result;
    }

    /**
     *
     * @param book
     * @return
     */
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Book createBook(Book book) {

        bookDAO = new BookDAOimpl();
        bookService = new BookServiceImpl(bookDAO);

        book = bookService.save(book);

        return book;
    }

    /**
     *
     * @return bookList
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks() {
        List<Book> bookList = null;
        bookDAO = new BookDAOimpl();
        bookService = new BookServiceImpl(bookDAO);

        bookList = bookService.findAll();

        return bookList;
    }

    /**
     *
     * @return bookService.totalPriceAll()
     */
    @GET
    @Path("/{price}")
    @Produces(MediaType.APPLICATION_JSON)
    public float getTotalPrice() {
        bookDAO = new BookDAOimpl();
        bookService = new BookServiceImpl(bookDAO);

        return bookService.totalPriceAll();

    }
}
