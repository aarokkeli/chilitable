package com.example.chilitable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.chilitable.web.ChiliController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ChilitableApplicationTests {
	
	@Autowired
	private ChiliController chiliController;
	
	@Test
	public void contextLoads() {
		assertThat(chiliController).isNotNull();
	}

}
