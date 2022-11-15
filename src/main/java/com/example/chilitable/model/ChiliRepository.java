package com.example.chilitable.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ChiliRepository extends CrudRepository<Chili, Long> {
	List<Chili> findByTitle(String title);

}
