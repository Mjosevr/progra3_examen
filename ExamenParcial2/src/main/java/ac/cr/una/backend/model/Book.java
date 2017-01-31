/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author mauricio
 */
@Entity
@Table(name = "Book", catalog = "progra3_exa2", uniqueConstraints = {
    @UniqueConstraint(columnNames = "idBook")})

public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idBook", unique = true, nullable = false)
    private int idBook;
    @Column(name = "id_Author", unique = true, nullable = false)    
    @OneToOne
    private Author author;
    @OneToOne
    private BookType type;
    @Column(name = "name", unique = false, nullable = false)
    private String name;
    @Column(name = "dataRelease", unique = true, nullable = false, length = 10)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataRelease;
    @Column(name = "price", unique = false, nullable = false)
    private float price;

    public Book() {
    }

    public Book(int idBook, Author author, BookType type, String name, Calendar dataRelease, float price) {
        this.idBook = idBook;
        this.author = author;
        this.type = type;
        this.name = name;
        this.dataRelease = dataRelease;
        this.price = price;
    }

    public int getIdBook() {
        return idBook;
    }

    public int getAuthor() {
        return author.getIdAuthor();
    }

    public BookType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Calendar getDataRelease() {
        return dataRelease;
    }

    public float getPrice() {
        return price;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setType(BookType type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDataRelease(Calendar dataRelease) {
        this.dataRelease = dataRelease;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.idBook;
        hash = 83 * hash + Objects.hashCode(this.author);
        hash = 83 * hash + Objects.hashCode(this.type);
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + Objects.hashCode(this.dataRelease);
        hash = 83 * hash + Float.floatToIntBits(this.price);
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
        final Book other = (Book) obj;
        if (this.idBook != other.idBook) {
            return false;
        }
        if (Float.floatToIntBits(this.price) != Float.floatToIntBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return Objects.equals(this.dataRelease, other.dataRelease);
    }

    @Override
    public String toString() {
        return "Book{" + "idBook=" + idBook + ", author=" + author + ", type=" + type + ", name=" + name + ", dataRelease=" + dataRelease + ", price=" + price + '}';
    }

}
