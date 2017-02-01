/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.webservice;

import ac.cr.una.backend.dao.BookTypeDAOimpl;
import ac.cr.una.backend.dao.BookTypeDAO;
import ac.cr.una.backend.dao.BookTypeDAOimpl;
import ac.cr.una.backend.model.Author;
import ac.cr.una.backend.model.AuthorContact;
import ac.cr.una.backend.model.Book;
import ac.cr.una.backend.model.BookType;
import ac.cr.una.backend.service.BookServiceImpl;
import ac.cr.una.backend.service.BookServiceImpl;
import ac.cr.una.backend.service.BookTypeService;
import ac.cr.una.backend.service.BookTypeServiceImpl;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author mauricio
 */
public class BookTypeWebService {

    private BookTypeDAO bookTypeDAO;
    private BookTypeService bookTypeService;
    @Context
    UriInfo context;

    public BookTypeWebService() {
    }

    /**
     *
     * @param nombre
     * @return booktype
     */
    @GET
    @Path("/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public BookType getByName(@PathParam("nombre") String nombre) {
        BookType booktype = null;
        bookTypeDAO = new BookTypeDAOimpl();
        bookTypeService = new BookTypeServiceImpl(bookTypeDAO);

        booktype = bookTypeService.findByName(nombre);

        return booktype;
    }

    /**
     *
     * @return result
     */
    @DELETE
    @Path("/")
    public boolean deleteAll() {
        boolean result;
        bookTypeDAO = new BookTypeDAOimpl();
        bookTypeService = new BookTypeServiceImpl(bookTypeDAO);

        result = bookTypeService.deleteAll();

        return result;
    }

    /**
     *
     * @param bookType
     * @return
     */
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BookType createBookType(BookType bookType) {

        bookTypeDAO = new BookTypeDAOimpl();
        bookTypeService = new BookTypeServiceImpl(bookTypeDAO);

        bookType = bookTypeService.save(bookType);

        return bookType;
    }
}
