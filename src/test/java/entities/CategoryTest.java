package entities;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class CategoryTest {

	@Test
	void getNameTest() {
		Category c = new Category("FPS");
		assertEquals("FPS", c.getName());
	}

	@Test
	void setNameTest() {
		Category c = new Category("FPS");
		c.setName("RPG");
		assertEquals("RPG", c.getName());
	}

	@Test
	void nullCategoryTest() {
		Category c = new Category(null);
		// Espera um retorno True, caso contrário para a execuçao do teste!
		assumeTrue(c.getName() == null);
		// System.out.println("Passou!");
		// Espera um retorno null
		assertNull(c.getName());
	}

	@Test
	void groupAssertionsTest() {
		String[] categorys = { "FPS", "RPG", "Platform", "Shooter", "Fighting", "Stealth", "Survival", "Rhythm",
				"MMORPG", "Life simulation", "Tower defense", "Wargame", "Racing", "Competitive", "Casual game" };

		assertAll("label", () -> assertEquals("FPS", new Category(categorys[0]).getName()),
				() -> assertEquals("RPG", new Category(categorys[1]).getName()),
				() -> assertEquals("Platform", new Category(categorys[2]).getName()),
				() -> assertEquals("Shooter", new Category(categorys[3]).getName()),
				() -> assertEquals("Fighting", new Category(categorys[4]).getName()),
				() -> assertEquals("Stealth", new Category(categorys[5]).getName()));

	}

	@Test
	@Timeout(value = 30, unit = TimeUnit.MILLISECONDS)
	void changeCategoryTimeoutTest() {
		// 15 categorys
		String[] categorys = { "FPS", "RPG", "Platform", "Shooter", "Fighting", "Stealth", "Survival", "Rhythm",
				"MMORPG", "Life simulation", "Tower defense", "Wargame", "Racing", "Competitive", "Casual game" };

		Category c = new Category(null);

		for (int i = 0; i < categorys.length; i++) {
			c.setName(categorys[i]);
			assertEquals(categorys[i], c.getName());
		}
	}

}
