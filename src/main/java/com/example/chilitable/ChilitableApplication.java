package com.example.chilitable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.chilitable.model.Category;
import com.example.chilitable.model.CategoryRepository;
import com.example.chilitable.model.Chili;
import com.example.chilitable.model.ChiliRepository;
import com.example.chilitable.model.Color;
import com.example.chilitable.model.ColorRepository;
import com.example.chilitable.model.User;
import com.example.chilitable.model.UserRepository;

@SpringBootApplication
public class ChilitableApplication {

	private static final Logger log = LoggerFactory.getLogger(ChilitableApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ChilitableApplication.class, args);
	}

	@Bean
	public CommandLineRunner chiliDemo(ChiliRepository crepo, UserRepository urepo, CategoryRepository caterepo,
			ColorRepository colorepo) {
		return (args) -> {
			log.info("Create a few categories/heat levels");
			Category category1 = new Category("Mild");
			Category category2 = new Category("Medium");
			Category category3 = new Category("Hot");
			Category category4 = new Category("Super-hot");
			caterepo.save(category1);
			caterepo.save(category2);
			caterepo.save(category3);
			caterepo.save(category4);

			log.info("Create a few colors for the chilis");
			Color color1 = new Color("Green");
			Color color2 = new Color("Black");
			Color color3 = new Color("Yellow");
			Color color4 = new Color("Red");
			colorepo.save(color1);
			colorepo.save(color2);
			colorepo.save(color3);
			colorepo.save(color4);

			log.info("Create a few chilis");
			Chili chili1 = new Chili("Carolina Reaper", "https://en.wikipedia.org/wiki/Carolina_Reaper", "2,000,000",
					category4, color4);
			Chili chili2 = new Chili("Habanero", "https://en.wikipedia.org/wiki/Habanero", "2,000,000", category2, color4);
			Chili chili3 = new Chili("Jalapeno", "https://en.wikipedia.org/wiki/Jalapeño", "2,000,000", category1, color1);
			crepo.save(chili1);
			crepo.save(chili2);
			crepo.save(chili3);
			
			// Create users admin/admin and user/user
			User user1 = new User("user", "$2a$10$xDSOHxQuLo4syde/Xy9aMOBoUxFVuzTTzbndyL1Jm27G/9qM6rp9m", "USER");
			User user2 = new User("admin", "$2a$10$6TyLJ3vgERNGGhoWKbzrxOiUF/vlFt5PE62DiF.2qvfEx8UfhwW0u", "ADMIN");
			urepo.save(user1);
			urepo.save(user2);
		}; 
	}
}
