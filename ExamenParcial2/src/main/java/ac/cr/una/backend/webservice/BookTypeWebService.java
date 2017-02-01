/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.webservice;

import ac.cr.una.backend.dao.BookTypeDAO;
import ac.cr.una.backend.dao.BookTypeDAOimpl;
import ac.cr.una.backend.model.BookType;
import ac.cr.una.backend.service.BookTypeService;
import ac.cr.una.backend.service.BookTypeServiceImpl;
import java.util.concurrent.ExecutorService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
@Path("BookType")
public class BookTypeWebService {

    private BookTypeDAO bookTypeDAO;
    private BookTypeService bookTypeService;
    @Context
    private UriInfo context;

    public BookTypeWebService() {
    }



    private ExecutorService executorService = java.util.concurrent.Executors.newCachedThreadPool();

    @GET
    @Path(value = "/{nombre}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public void getByName(@Suspended final AsyncResponse asyncResponse, @PathParam(value = "nombre") final String nombre) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                asyncResponse.resume(doGetByName(nombre));
            }
        });
    }

    private BookType doGetByName(@PathParam("nombre") String nombre) {
        BookType booktype = null;
        bookTypeDAO = new BookTypeDAOimpl();
        bookTypeService = new BookTypeServiceImpl(bookTypeDAO);
        
        booktype = bookTypeService.findByName(nombre);
        
        return booktype;
    }

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
        bookTypeDAO = new BookTypeDAOimpl();
        bookTypeService = new BookTypeServiceImpl(bookTypeDAO);
        
        result = bookTypeService.deleteAll();
        
        return result;
    }

    @POST
    @Path(value = "/")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public void createBookType(@Suspended final AsyncResponse asyncResponse, final BookType bookType) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                asyncResponse.resume(doCreateBookType(bookType));
            }
        });
    }

    private BookType doCreateBookType(BookType bookType) {
        bookTypeDAO = new BookTypeDAOimpl();
        bookTypeService = new BookTypeServiceImpl(bookTypeDAO);
        
        bookType = bookTypeService.save(bookType);
        
        return bookType;
    }
}
