package com.puthisastra.first;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
 
    @Column(name = "title", nullable = false)
    private String title;
 
    @ManyToMany(cascade =
        {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "Book_Author",
	    joinColumns = {
	        @JoinColumn(
	            name = "book_id",
	            referencedColumnName = "id"
	        )
	    },
	    inverseJoinColumns = {
	        @JoinColumn(
	            name = "author_id",
	            referencedColumnName = "id"
	        )
	    }
	)
    @JsonIgnore
    private List<Author> authors = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
    
    
}
