package com.udacity.course3;

import com.udacity.course3.data.Delivery;
import com.udacity.course3.data.Flower;
import com.udacity.course3.data.Plant;
import com.udacity.course3.repository.PlantRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
class Course3ApplicationTests {

	@Autowired
	TestEntityManager entityManager;

	@Autowired
	PlantRepository plantRepository;

	@Test
	void testPriceLessThan() {
		Plant firstPlant = entityManager.persist(new Plant("Flower 1", BigDecimal.valueOf(10.0)));
		entityManager.persist(new Plant("Flower 2", BigDecimal.valueOf(20.0)));

		List<Plant> plants = plantRepository.findByPriceLessThan(BigDecimal.valueOf(15));

		assertEquals(plants.size(), 1);
		assertEquals(plants.get(0), firstPlant);
	}

	@Test
	void testDeliveryComplete() {
		Plant p = entityManager.persist(new Plant("Baz Root", BigDecimal.valueOf(9.99)));
		Delivery d = entityManager.persist(new Delivery("Leonard Bernstein", "234 West Side", LocalDateTime.now()));

		d.setPlants(Lists.newArrayList(p));
		p.setDelivery(d);

		//test both before and after
		Assertions.assertFalse(plantRepository.deliveryCompleted(p.getId()));
		d.setComplete(true);
		Assertions.assertTrue(plantRepository.deliveryCompleted(p.getId()));
	}
}