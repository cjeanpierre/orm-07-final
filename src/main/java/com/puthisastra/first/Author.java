package com.puthisastra.first;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
 
    @Column(name = "full_name", nullable = false)
    private String fullName;
 
    @ManyToMany(mappedBy = "authors",
        cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Book> books = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
    
	public void addBook(Book book) {
        books.add(book);
        book.getAuthors().add(this);
    }
 
    public void removeBook(Book book) {
        books.remove(book);
        book.getAuthors().remove(this);
    }
    
}
