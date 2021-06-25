package game;

import parent.Gotch;

public class GameMode extends Gotch{

	static Gotch player1 = new Gotch();
	private static void currentP() {
		player1 = (Gotch) currentPlayer[0];
	}
	
	public static void modeSwitch() {
		currentP();
		
		switch(player1.getSpecies()) {
		case "Doggo":
			game.Doggo.doggoGame();
			break;
		case "Rat Bat":
			game.RatBat.ratbatGame();
			break;
		case "Dadpole":
			game.Dadpole.dadpoleGame();
			break;
		case "Cat-a-pillar":
			game.Catapillar.catapillarGame();
			break;
		case "Demon":
			game.Demon.demonGame();
			break;
		default:
			break;
		}	
	}
	
	public static void initialize() {
		createGotch();
		modeSwitch();
	}
	
}
