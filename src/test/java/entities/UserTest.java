package entities;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class UserTest {

	private static Category fps = new Category("FPS");
	private static Category rpg = new Category("RPG");
	private static Category survival = new Category("Survival");
	private static Category racing = new Category("Racing");

	private static Game counterStrike = new Game("Counter Strike", "Joguinho de tiro", fps, 50.f, 10.f);
	private static Game needForSpeed = new Game("Ned For Speed Underground 2", "O melhor de todos", racing, 15f, 10f);
	private static Game zelda = new Game("Zelda Ocarina of Time", "O personagem principal não se chama Zelda!", rpg,
			20f, 1f);
	private static Game gta = new Game("Grand Theft Auto San Andreas", "CJ ao contrário é JC", survival, 50f, 50f);

	private static User user = new User("JuquimGamer1997BR", "1234", "joaquimskate15@gmail.com");

	@BeforeAll
	static void beforeAll() {
		user.sendMoneyToWallet(50.f);
		user.buyNewGame(counterStrike);
		System.out.println("Executando o método beforeAll");
		System.out.println("Wallet: " + user.getWalletValue());
	}

	@AfterAll
	static void afterAll() {
		System.out.println();
		System.out.println("Executando o método afterAll");
		System.out.println("-----------------------------");
		System.out.println("Wallet final value: " + user.getWalletValue());

		System.out.println();
		System.out.println("--- Games on Library ---");
		user.listLibrary();
	}

	@BeforeEach
	void beforeEachMethod() {
		user.sendMoneyToWallet(700.f);
		System.out.println();
		System.out.println("Sending 50 to wallet");
		System.out.println("Update Wallet value: " + user.getWalletValue());
	}

	@AfterEach
	void afterEachMethod() {
		System.out.println();
		System.out.println("Wallet value: " + user.getWalletValue());

		assertAll("label", () -> assertEquals(counterStrike, user.getGame(0)),
				() -> assertEquals(gta, user.getGame(1)),
				() -> assertEquals(needForSpeed, user.getGame(2)),
				() -> assertEquals(gta, user.getGame(3)),
				() -> assertEquals(needForSpeed, user.getGame(4)),
				() -> assertEquals(gta, user.getGame(5)),
				() -> assertEquals(needForSpeed, user.getGame(6)),
				() -> assertEquals(zelda, user.getGame(7)));
	}

	@Test
	@Timeout(value = 40, unit =	TimeUnit.MILLISECONDS)
	void buyGamesTest() {
		assertAll("label", () -> assertEquals(true, user.buyNewGame(gta)),
				() -> assertEquals(true, user.buyNewGame(needForSpeed)),
				() -> assertEquals(true, user.buyNewGame(gta)),
				() -> assertEquals(true, user.buyNewGame(needForSpeed)),
				() -> assertEquals(true, user.buyNewGame(gta)),
				() -> assertEquals(true, user.buyNewGame(needForSpeed)),
				() -> assertEquals(true, user.buyNewGame(zelda)));
	}

}
