package entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

	Category fps = new Category("FPS");
	Category rpg = new Category("RPG");
	Category platform = new Category("Platform");
	Category survival = new Category("Survival");
	Category racing = new Category("Racing");
	Category fighting = new Category("Fighting");

	Game counterStrike = new Game("Counter Strike", "Joguinho de tiro", fps, 50.f, 10.f);
	Game needForSpeed = new Game("Ned For Speed Underground 2", "O melhor de todos", racing, 15f, 10f);
	Game zelda = new Game("Zelda Ocarina of Time", "O personagem principal não se chama Zelda!", rpg, 20f, 1f);
	Game gta = new Game("Grand Theft Auto San Andreas", "CJ ao contrário é JC", survival, 500f, 50f);
	
	User user = new User("JuquinhaGamer1997BR", "1234", "joaquimskate15@gmail.com");

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
