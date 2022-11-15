package com.example.chilitable.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
	
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryId;
	private String name;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Chili> chilis;
	
	// Constructors
	public Category(String name) {
		super();
		this.name = name;
	}

	public Category() {
	}

	// Getters and setters
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Chili> getChilis() {
		return chilis;
	}

	public void setChilis(List<Chili> chilis) {
		this.chilis = chilis;
	}

	// toString 
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + ", chilis=" + chilis + "]";
	}

}
