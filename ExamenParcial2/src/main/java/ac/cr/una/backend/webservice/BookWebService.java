/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.webservice;

import ac.cr.una.backend.dao.BookDAO;
import ac.cr.una.backend.dao.BookDAOimpl;
import ac.cr.una.backend.model.Book;
import ac.cr.una.backend.service.BookService;
import ac.cr.una.backend.service.BookServiceImpl;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author mauricio
 */
@Path("Book")
public class BookWebService {

    private BookDAO bookDAO;
    private BookService bookService;
    @Context
    private UriInfo context;

    public BookWebService() {
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
    private ExecutorService executorService = java.util.concurrent.Executors.newCachedThreadPool();

    @DELETE
    @Path(value = "/")
    public void deleteAll(@Suspended final AsyncResponse asyncResponse) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                asyncResponse.resume(doDeleteAll());
            }
        });
    }

    private boolean doDeleteAll() {
        boolean result;
        bookDAO = new BookDAOimpl();
        bookService = new BookServiceImpl(bookDAO);
        
        result = bookService.deleteAll();
        
        return result;
    }

    @POST
    @Path(value = "/")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public void createBook(@Suspended final AsyncResponse asyncResponse, final Book book) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                asyncResponse.resume(doCreateBook(book));
            }
        });
    }

    private Book doCreateBook(Book book) {
        bookDAO = new BookDAOimpl();
        bookService = new BookServiceImpl(bookDAO);
        
        book = bookService.save(book);
        
        return book;
    }

    @GET
    @Path(value = "/")
    @Produces(value = MediaType.APPLICATION_JSON)
    public void getAllBooks(@Suspended final AsyncResponse asyncResponse) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                asyncResponse.resume(doGetAllBooks());
            }
        });
    }

    private List<Book> doGetAllBooks() {
        List<Book> bookList = null;
        bookDAO = new BookDAOimpl();
        bookService = new BookServiceImpl(bookDAO);
        
        bookList = bookService.findAll();
        
        return bookList;
    }
}
