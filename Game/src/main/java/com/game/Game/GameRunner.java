package com.game.Game;

import allgames.*;


public class GameRunner {
   private Missu game;
	public GameRunner(Missu game) {
		this.game=game;
	}

	public void run()
	{
		game.missu();
	}
  
}
