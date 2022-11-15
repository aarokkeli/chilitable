package com.example.chilitable.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.chilitable.model.Category;
import com.example.chilitable.model.CategoryRepository;
import com.example.chilitable.model.Chili;
import com.example.chilitable.model.ChiliRepository;
import com.example.chilitable.model.Color;
import com.example.chilitable.model.ColorRepository;

@Controller
public class ChiliController {

	@Autowired
	private ChiliRepository crepo;

	@Autowired
	private CategoryRepository caterepo;

	@Autowired
	private ColorRepository colorepo;

	// Show all tracks
	@GetMapping(value = { "", "/chililist" })
	public String chiliList(Model model) {
		model.addAttribute("chilis", crepo.findAll());
		return "chililist";
	}

	// Add a new chili
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/addchili")
	public String addChili(Model model) {
		model.addAttribute("chili", new Chili());
		model.addAttribute("colors", colorepo.findAll());
		model.addAttribute("categories", caterepo.findAll());
		return "addchili";
	}

	// Save the new chili
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping(value = "/save")
	public String saveChili(Chili chili) {
		crepo.save(chili);
		return "redirect:chililist";
	}

	// Delete a chili
	@GetMapping(value = "/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteChili(@PathVariable("id") Long chiliId, Model model) {
		crepo.deleteById(chiliId);
		return "redirect:../chililist";
	}

	// Edit a chili
	@GetMapping(value = "/editchili/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editChili(@PathVariable("id") Long chiliId, Model model) {
		model.addAttribute("chili", crepo.findById(chiliId));
		model.addAttribute("colors", colorepo.findAll());
		model.addAttribute("categories", caterepo.findAll());
		return "editchili";
	}

	// Add a new color
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/addcolor")
	public String addColor(Model model) {
		model.addAttribute("color", new Color());
		return "addcolor";
	}

	// Save the new color
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping(value = "/savecolor")
	public String saveColor(Color color) {
		colorepo.save(color);
		return "redirect:chililist";
	}

	// Add a new heat level
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/addheat")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addheat";
	}

	// Save the new heat level
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping(value = "/savecategory")
	public String saveCategory(Category category) {
		caterepo.save(category);
		return "redirect:chililist";
	}

	// REST METHODS

	// Show all chilis
	@GetMapping(value = "/chilis")
	public @ResponseBody List<Chili> chiliListRest() {
		return (List<Chili>) crepo.findAll();
	}

	// Show a chili via id
	@GetMapping(value = "/chilis/{id}")
	public @ResponseBody Optional<Chili> findChilisRest(@PathVariable("id") Long chiliId) {
		return crepo.findById(chiliId);
	}

	// Show all categories (heat levels)
	@GetMapping(value = "/categories")
	public @ResponseBody List<Category> categoryListRest() {
		return (List<Category>) caterepo.findAll();
	}

	// Show a category (heat level) via its id
	@GetMapping(value = "/categories/{id}")
	public @ResponseBody Optional<Category> findCategoryRest(@PathVariable("id") Long categoryId) {
		return caterepo.findById(categoryId);
	}

	// Show all colors
	@GetMapping(value = "/colors")
	public @ResponseBody List<Color> colorListRest() {
		return (List<Color>) colorepo.findAll();
	}

	// Show a color via id
	@GetMapping(value = "/colors/{id}")
	public @ResponseBody Optional<Color> findColorRest(@PathVariable("id") Long colorId) {
		return colorepo.findById(colorId);
	}

}
