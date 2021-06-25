package menu;

import java.util.Scanner;

import parent.Gotch;


// testing push
public class menus extends Gotch{

	public static void homeMenu() {
		Scanner input1 = new Scanner(System.in);
		System.out.println("Welcome to Gotch World!\n" + "***********************\n" + "Choose an option:\n"
							+ "1. Create a Gotch and Play\n" + "2. Scoreboard\n" + "3. How to Play\n" + "4. Exit");
		switch(input1.nextInt()) {
		case 1:
			game.GameMode.initialize();
			break;
		case 2:
			displayScoreboard();
			homeMenu();
			break;
		case 3:
			howToPlay();
			homeMenu();
			break;
		case 4:
			System.out.println("Are you sure you want to exit? y/n");
			String yn = input1.next();
			if(yn.equalsIgnoreCase("y")) {
				System.out.println("Goodbye.");
				System.exit(0);
			}
			else
				homeMenu();
		default:
			System.out.println("wrong input");
			homeMenu();
		}
		
	}
	
	private static void howToPlay() {
		System.out.println("This is Gotch World. A Gotch is a creature of chaos.\n"
						+ "They grow quickly but can die quickly, too. The\n"
						+ "goal of the game is to try to raise it as much\n"
						+ "as possible before it kicks the bucket. You get\n"
						+ "a better score for keeping it alive longer and\n"
						+ "making it more powerful. Each type of Gotch has\n"
						+ "slightly different play styles, so try them all!\n");
	}
	
}
