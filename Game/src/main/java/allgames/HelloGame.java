package allgames;

import com.game.Game.GamingConsole;

public class HelloGame implements GamingConsole {
    

	@Override
	public void up() {
		System.out.println("Hello up ");
		
	}

	@Override
	public void down() {
		System.out.println("Hello down ");
		
	}

	@Override
	public void left() {
		System.out.println("Hello left ");
		
	}

	@Override
	public void right() {
		System.out.println("Hello right ");
		
	}
}
