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
public class Color {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long colorId;
	private String name;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "color")
	private List<Chili> chilis;

	// Constructors
	public Color(String name) {
		super();
		this.name = name;
	}

	public Color() {

	}
	
	// Getters and setters
	public Long getColorId() {
		return colorId;
	}

	public void setColorId(Long colorId) {
		this.colorId = colorId;
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
		return "Color [colorId=" + colorId + ", name=" + name + ", chilis=" + chilis + "]";
	}

}
