package com.example.chilitable.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Chili {

	// Attributes... "shu" means Scoville Heat Units and it's the measurement of how hot the chili is
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long chiliId;
	private String title, link, shu;

	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "colorId")
	private Color color;

	// Constructors
	public Chili(String title, String link, String shu, Category category, Color color) {
		super();
		this.title = title;
		this.link = link;
		this.shu = shu;
		this.category = category;
		this.color = color;
	}

	public Chili() {
	}
	
	// Getters and setters
	public Long getChiliId() {
		return chiliId;
	}

	public void setChiliId(Long id) {
		this.chiliId = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getShu() {
		return shu;
	}

	public void setShu(String shu) {
		this.shu = shu;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	// toString
	@Override
	public String toString() {
		return "Chili [chiliId=" + chiliId + ", title=" + title + ", link=" + link + ", shu=" + shu + "]";
	}

}
