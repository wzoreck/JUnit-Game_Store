package entities;

import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	@Disabled
	void gettersTest() {
		Category c = new Category("FPS");
		Game g = new Game("Counter Strike", "Escolha uma arma e atire nos seus amigos", c);

		assertEquals("Counter Strike", g.getName());
		assertEquals("Escolha uma arma e atire nos seus amigos", g.getDescription());
		assertEquals(c, g.getCategory());
		assertNotEquals(null, g.getCategory());
		assumeFalse(g.getCategory() == null);
		System.out.println("Passou - assumeFalse do método gettersTest()");
	}

	@Test
	@Disabled
	void getters2Test() {
		Category c = new Category("FPS");
		Game g = new Game("Counter Strike", "Escolha uma arma e atire nos seus amigos", c, 54.7f, 10.f);

		assertEquals("Counter Strike", g.getName());
		assertEquals("Escolha uma arma e atire nos seus amigos", g.getDescription());
		assertEquals(c, g.getCategory());
		assertNotEquals(null, g.getCategory());
		assumeFalse(g.getCategory() == null);
		System.out.println("Passou - assumeFalse do método getters2Test()");
		assertEquals(54.7f, g.getPrice());
		assertEquals(10, g.getDiscountPercentage());
	}

	@Test
	void discountTest() {
		Category c = new Category("FPS");
		Game g = new Game("Counter Strike", "Escolha uma arma e atire nos seus amigos", c, 54.7f, 10.f);
		System.out.println("Discount Price = " + g.getDiscount());
		assertEquals(49, 23f, g.getDiscount());
	}

	@Test
	void nullTest() {
		Game g = new Game("Doom", "Insane Game", null);
		assumeTrue(g.getCategory() == null);
		System.out.println("Passou - assumeTrue do método nullTest()");
		assertEquals(null, g.getCategory());
		assertNull(g.getCategory());

		assertThrows(NullPointerException.class, () -> {
			g.getCategoryName();
		});
	}

	@Test
	void setterGettersGroupAssertions() {
		Game g = new Game(null, null, null);
		g.setName("Counter Strike");
		g.setCategory(new Category("FPS"));
		g.setDescription("Joguinho de tiro");
		g.setPrice(100.f);
		g.setDiscountPercentage(5.f); // 5%

		assertAll("label", () -> assertEquals("Counter Strike", g.getName()),
				() -> assertEquals("Joguinho de tiro", g.getDescription()),
				() -> assertEquals("FPS", g.getCategory().getName()), () -> assertEquals("FPS", g.getCategoryName()),
				() -> assertEquals(100.f, g.getPrice()), () -> assertEquals(5.f, g.getDiscountPercentage()),
				() -> assertEquals(95.f, g.getDiscount()));
	}

}
