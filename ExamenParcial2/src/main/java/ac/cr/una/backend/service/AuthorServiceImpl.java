/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.service;

import ac.cr.una.backend.dao.AuthorContactDAO;
import ac.cr.una.backend.model.Author;
import ac.cr.una.backend.model.AuthorContact;
import ac.cr.una.backend.dao.AuthorDAO;
import java.util.List;

/**
 *
 * @author mauricio
 */
public class AuthorServiceImpl implements AuthorService {

    private AuthorDAO authorDao;
    private AuthorContactDAO authorContactDAO;

    public AuthorServiceImpl() {
    }

    public AuthorServiceImpl(AuthorDAO authorDao) {
        this.authorDao = authorDao;
    }

    public AuthorServiceImpl(AuthorContactDAO authorContactDAO) {
        this.authorContactDAO = authorContactDAO;
    }

    public AuthorServiceImpl(AuthorDAO authorDao, AuthorContactDAO authorContactDAO) {
        this.authorDao = authorDao;
        this.authorContactDAO = authorContactDAO;
    }

    @Override
    public Author findByName(String name) {
        return authorDao.findByName(name);
    }

    @Override
    public List<AuthorContact> findAll() {
        return authorContactDAO.findAll();
    }

    @Override
    public AuthorContact save(AuthorContact authorContact) {
        return authorContactDAO.save(authorContact);
    }

    @Override
    public boolean deleteAll() {
        return authorContactDAO.deleteAll();
    }

    public AuthorDAO getAuthorDao() {
        return authorDao;
    }

    public AuthorContactDAO getAuthorContactDAO() {
        return authorContactDAO;
    }

    public void setAuthorDao(AuthorDAO authorDao) {
        this.authorDao = authorDao;
    }

    public void setAuthorContactDAO(AuthorContactDAO authorContactDAO) {
        this.authorContactDAO = authorContactDAO;
    }

}
