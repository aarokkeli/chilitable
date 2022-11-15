package com.example.chilitable;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.util.List;

import javax.sound.midi.Track;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.chilitable.model.Category;
import com.example.chilitable.model.CategoryRepository;
import com.example.chilitable.model.Chili;
import com.example.chilitable.model.ChiliRepository;
import com.example.chilitable.model.Color;
import com.example.chilitable.model.ColorRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RepositoryTests {

	@Autowired
	private ChiliRepository crepo;

	@Autowired
	private CategoryRepository caterepo;

	@Autowired
	private ColorRepository colorepo;

	@Test
	public void findByChiliNameShouldReturnChili() {
		List<Chili> chilis = crepo.findByTitle("Carolina Reaper");
		assertThat(chilis).hasSize(1);
		assertThat(chilis.get(0).getShu()).isEqualTo("2,000,000");
	}

	@Test
	public void createNewChili() {
		Chili chili = new Chili("Naga Morich", null, "1,000,000", caterepo.findByName("Super-hot").get(0),
				colorepo.findByName("Green").get(0));
		crepo.save(chili);
		assertThat(chili.getTitle()).isNotNull();
	}

	@Test
	public void findByCategoryNameShouldReturnCategory() {
		List<Category> categories = caterepo.findByName("Hot");
		assertThat(categories).hasSize(1);
	}

	@Test
	public void createNewCategory() throws ParseException {
		Category category = new Category("Mega-hot");
		caterepo.save(category);
		assertThat(category.getName()).isEqualTo("Mega-hot");
	}

	@Test
	public void findByNameShouldReturnColor() {
		List<Color> colors = colorepo.findByName("Green");
		assertThat(colors).hasSize(1);
		assertThat(colors.get(0).getColorId()).isEqualTo(5);
	}

	@Test
	public void createNewColor() throws ParseException {
		Color color = new Color("Brown");
		colorepo.save(color);
		assertThat(color.getName()).isEqualTo("Brown");
	}

}