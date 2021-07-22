package entities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

	private static Category fps = new Category("FPS");
	private static Category rpg = new Category("RPG");
	private static Category platform = new Category("Platform");
	private static Category survival = new Category("Survival");
	private static Category racing = new Category("Racing");
	private static Category fighting = new Category("Fighting");

	private static Game counterStrike = new Game("Counter Strike", "Joguinho de tiro", fps, 50.f, 10.f);
	private static Game needForSpeed = new Game("Ned For Speed Underground 2", "O melhor de todos", racing, 15f, 10f);
	private static Game zelda = new Game("Zelda Ocarina of Time", "O personagem principal nÃ£o se chama Zelda!", rpg,
			20f, 1f);
	private static Game gta = new Game("Grand Theft Auto San Andreas", "CJ ao contrÃ¡rio Ã© JC", survival, 500f, 50f);

	private static User user = new User("JuquimGamer1997BR", "1234", "joaquimskate15@gmail.com");

	// Será executado antes de todos os Test's unitarios, precisa do static antes
	@BeforeAll
	static void beforeAll() {
		user.sendMoneyToWallet(1000.f);
		user.buyNewGame(counterStrike);
		user.buyNewGame(needForSpeed);
		System.out.println("Wallet: " + user.getWalletValue());
		System.out.println("Executando o método beforeAll");
	}

	// Será executado após todos os Test's unitarios, precisa do static antes
	@AfterAll
	static void afterAll() {
		System.out.println("Executando o método afterAll");
	}

	@BeforeEach
	void beforeEachMethod() {
		if (user.getWalletValue() <= 0)
			user.sendMoneyToWallet(1000.f);
	}

	@AfterEach
	void afterEachMethod() {
		if (user.getWalletValue() > 1500.f)
			user.setWallet(500.f);
	}

	@Test
	void test() {

	}

}
