package com.example.chilitable.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ColorRepository extends CrudRepository<Color, Long> {
	List<Color> findByName(String color);

}
