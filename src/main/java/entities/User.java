package entities;

import java.util.ArrayList;

public class User {
	
	private String username;
	private String password;
	private String email;
	private Float wallet;
	private ArrayList<Game> myGames = null;
	
	public User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.wallet = 0.f;
		this.myGames = new ArrayList<Game>();
	}
	
	// Other Methods
	
	public boolean buyNewGame(Game game) {
		if (this.wallet >= game.getPrice()) {
			this.myGames.add(game);
			return true;
		}
		return false;
	}
	
	public Float getWalletValue() {
		return wallet;
	}

	public boolean sendMoneyToWallet(Float value) {
		if (value > 0.f) {
			this.wallet = value;
			return true;
		}
		return false;
	}
	
	// ./Other Methods

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Game> getMyGames() {
		return myGames;
	}
	
}
