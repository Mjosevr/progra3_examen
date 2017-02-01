/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.service;

import ac.cr.una.backend.model.BookType;

/**
 *
 * @author mauricio
 */
public interface BookTypeService {

    public BookType findByName(String name);

    public BookType save(BookType bookType);

    public boolean deleteAll();

}
