/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.webservice;

import ac.cr.una.backend.dao.AuthorContactDAO;
import ac.cr.una.backend.dao.AuthorContactDAOimpl;
import ac.cr.una.backend.dao.AuthorDAO;
import ac.cr.una.backend.dao.AuthorDAOimpl;
import ac.cr.una.backend.model.Author;
import ac.cr.una.backend.model.AuthorContact;
import ac.cr.una.backend.service.AuthorService;
import ac.cr.una.backend.service.AuthorServiceImpl;
import java.util.List;
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
@Path("Author")
public class AuthorWebService {

    private AuthorDAO authorDAO;
    private AuthorContactDAO authorContactDAO;
    private AuthorService authorService;
    @Context
    private UriInfo context;

    public AuthorWebService() {
    }



    private ExecutorService executorService = java.util.concurrent.Executors.newCachedThreadPool();

    /**
     *
     * @param asyncResponse
     * @param authorContact
     */
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createAuthor(@Suspended
    final AsyncResponse asyncResponse, final AuthorContact authorContact) {

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                asyncResponse.resume(doCreateAuthor(authorContact));
            }
        });
    }

    private AuthorContact doCreateAuthor(AuthorContact authorContact) {
        authorDAO = new AuthorDAOimpl();
        authorService = new AuthorServiceImpl(authorDAO);

        authorContact = authorService.save(authorContact);

        return authorContact;
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
        authorDAO = new AuthorDAOimpl();
        authorService = new AuthorServiceImpl(authorDAO);
        
        result = authorService.deleteAll();
        
        return result;
    }

    @GET
    @Path(value = "/{nombre}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public void getAuthorByName(@Suspended final AsyncResponse asyncResponse, @PathParam(value = "nombre") final String nombre) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                asyncResponse.resume(doGetAuthorByName(nombre));
            }
        });
    }

    private Author doGetAuthorByName(@PathParam("nombre") String nombre) {
        Author author = null;
        authorDAO = new AuthorDAOimpl();
        authorService = new AuthorServiceImpl(authorDAO);
        
        author = authorService.findByName(nombre);
        
        return author;
    }

    @GET
    @Path(value = "/")
    @Produces(value = MediaType.APPLICATION_JSON)
    public void getAllAuthors(@Suspended final AsyncResponse asyncResponse) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                asyncResponse.resume(doGetAllAuthors());
            }
        });
    }

    private List<AuthorContact> doGetAllAuthors() {
        List<AuthorContact> AuthorContactList = null;
        authorContactDAO = new AuthorContactDAOimpl();
        authorService = new AuthorServiceImpl(authorDAO);
        
        AuthorContactList = authorService.findAll();
        
        return AuthorContactList;
    }
}
