/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author mauricio
 */
@Entity
@Table(name = "BookType", catalog = "progra3_exa2", uniqueConstraints = {
    @UniqueConstraint(columnNames = "idType")})
public class BookType implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idType", unique = true, nullable = false)
    private int idType;
    @Column(name = "type", unique = false, nullable = false)
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
