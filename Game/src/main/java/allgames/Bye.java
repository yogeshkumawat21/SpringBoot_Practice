package allgames;

import com.game.Game.GamingConsole;

public class Bye implements GamingConsole {

	public void up() {
		System.out.println("Bye up ");
		
	}

	@Override
	public void down() {
		System.out.println("Bye down ");
		
	}

	@Override
	public void left() {
		System.out.println("Bye left ");
		
	}

	@Override
	public void right() {
		System.out.println("Bye right ");
		
	}
}

