package com.game.Game;


import allgames.*;

public class GamingGamingApplication {
  public static void main(String[] args)
  {
	  //var game = new HelloGame();
	  //var game = new Bye();
	 // var game = new Missu();
	  var game = new HelloGame();
	  var GameRunner = new GameRunner(game);
	  GameRunner.run();
  }
}
