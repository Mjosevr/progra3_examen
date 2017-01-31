/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.model;

import java.util.Objects;

/**
 *
 * @author mauricio
 */
public class BookType {

    private int idType;
    private String type;

    public BookType() {
    }

    public BookType(int idType, String type) {
        this.idType = idType;
        this.type = type;
    }

    public int getIdType() {
        return idType;
    }

    public String getType() {
        return type;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.idType;
        hash = 47 * hash + Objects.hashCode(this.type);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BookType other = (BookType) obj;
        if (this.idType != other.idType) {
            return false;
        }
        return Objects.equals(this.type, other.type);
    }

    @Override
    public String toString() {
        return "BookType{" + "idType=" + idType + ", type=" + type + '}';
    }

}
