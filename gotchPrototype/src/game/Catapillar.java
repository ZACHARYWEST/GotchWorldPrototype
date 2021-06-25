package game;

import java.util.Random;
import java.util.Scanner;

import parent.Gotch;

public class Catapillar extends GameMode{
	
	static Scanner input3 = new Scanner(System.in);
	static Random RNG = new Random();
	static int hunger = 5;
	static int level = 1;
	static int exp = 0;
	static int day = 1;
	static int score = 0;
	
	
	
	public static void catapillarGame() {
		System.out.println("Hello, " + player1.getPlayer() + 
				". Your Cat-a-pillar, " + player1.getGotch() + 
				", is just a Kittypillar right now.\nYou must raise it"
				+ " to create a powerful Gotch. See how \npowerful "
				+ "you can make " + player1.getGotch() + " become "
						+ "before it \nreaches its inevitable death!\n" 
				+ "\n");
		switchboard();
	}

	private static String evolve(int level) {
		if (level < 5 ) {
			return "Kittypillar";
		}
		else
			if (level >= 5 && level < 10) {
				return "Catcoon";
			}
			else
				return "Bengal-Fly";
	}
	
	private static void switchboard() {
		System.out.println(player1.getGotch() + " is currently a level "
				+ level + " " + evolve(level) + ".\nIts energy level is currently at " 
				+ hunger + ".\n" + "It is day " + day + ".\n");
		
		if (evolve(level).equals("Kittypillar")) {
			System.out.println("Choose an action:\n" + "1. Feed\n" + "2. Train\n" + "3. Play");
			int choice = input3.nextInt();
			switch (choice) {
			case 1:
				System.out.println("You have fed " + player1.getGotch() + "\n");
				hunger = hunger + 2;
				scoreUp(4);
				gainEXP(1);
				endDay();
				break;
			case 2:
				System.out.println("You have put " + player1.getGotch() + " through rigorous training!" + "\n");
				hunger--;
				scoreUp(8);
				gainEXP(4);
				endDay();
				break;
			case 3:
				play();
				hunger--;
				endDay();
				break;
			default:
				System.out.println("Error, retrying...");
				switchboard();
				break;
			}
		} 
		else 
		if (evolve(level).equals("Catcoon")) {
			System.out.println("Choose an action:\n" + "1. Feed\n" + "2. Train\n" + "3. Wait");
			int choice = input3.nextInt();
			switch (choice) {
			case 1:
				System.out.println(player1.getGotch() + " is inside a cocoon and doesn't need feeding. Just wait." + "\n");
				switchboard();
				break;
			case 2:
				System.out.println(player1.getGotch() + " is inside a cocoon and cannot be trained. Just wait." + "\n");
				switchboard();
				break;
			case 3:
				waitAndGrow();
				endDay();
				break;
			default:
				System.out.println("Error, retrying...");
				switchboard();
				break;
			}
		} 
		else
		if (evolve(level).equals("Bengal-Fly")) {
			System.out.println("Choose an action:\n" + "1. Feed\n" + "2. Train\n"
					+ "3. Spread happiness around the world!");
			int choice = input3.nextInt();
			switch (choice) {
			case 1:
				System.out.println("You have fed " + player1.getGotch() + "\n");
				hunger = hunger +2;
				scoreUp(4);
				gainEXP(1);
				endDay();
				break;
			case 2:
				System.out.println("You have put " + player1.getGotch() + " through rigorous training!" + "\n");
				hunger--;
				scoreUp(8);
				gainEXP(4);
				endDay();
				break;
			case 3:
				spreadHappy();
				endDay();
				break;
			default:
				System.out.println("Error, retrying...");
				switchboard();
				break;
			}
		}
		
	
	}
	
	private static boolean doesItDie() {
		int chaos = RNG.nextInt(100) +1;
		if (day <= 4 && chaos < 2) {
			return true;
		} else if (day > 4 && day <= 8 && chaos < 4) {
			return true;
		} else if (day > 8 && day <= 12 && chaos < 6) {
			return true;
		} else if (day > 12 && day <= 16 && chaos < 8) {
			return true;
		} else if (day > 16 && day <= 20 && chaos < 10) {
			return true;
		} else if (day > 20 && day <= 24 && chaos < 12) {
			return true;
		} else if (day > 24 && day <= 28 && chaos < 15) {
			return true;
		} else if (day > 28 && day <= 32 && chaos < 18) {
			return true;
		} else if (day > 32 && day <= 36 && chaos < 25) {
			return true;
		} else if (day > 36 && day <= 40 && chaos < 30) {
			return true;
		} else if (day > 40 && day <= 44 && chaos < 35) {
			return true;
		} else if (day > 44 && day <= 48 && chaos < 40) {
			return true;
		} else if (day > 48 && day <= 52 && chaos < 45) {
			return true;
		} else if (day > 52 && day <= 56 && chaos < 50) {
			return true;
		} else if (day > 56 && day <= 60 && chaos < 60) {
			return true;
		} else if (day > 60 && day <= 64 && chaos < 70) {
			return true;
		} else if (day > 64 && day <= 68 && chaos < 80) {
			return true;
		} else if (day > 68 && day <= 74 && chaos < 90) {
			return true;
		} else if (day == 75 && chaos <= 100) {
			return true;
		} 
			
		return false;
	}
	
	private static boolean doesItStarve() {
		if (hunger <= 0) {
			return true;
		}
		return false;
	}
	
	private static void gainEXP(int gain) {
		exp = exp + gain;
		if ( exp >= 10) {
			level++;
			exp = 0;
		}
		if (level == 5 && exp == 0) {
			System.out.println("Congratulations! " + player1.getGotch() + " has grown into a Catcoon! It must wait patiently as it grows. You hope nothing bad happens!");
		}
		if (level == 10 && exp == 0) {
			hunger = 2;
			System.out.println("Congratulations! " + player1.getGotch() + " has grown into a Bengal-Fly! It is a giving creature of luck and joy!");
		}
	}
	
	private static void endDay() {

		if (doesItStarve() == false && doesItDie() == false) {
			day++;
			switchboard();
		} else if (doesItStarve() == true && doesItDie() == false) {
			System.out.println("You have starved your Gotch to death. You are the real monster." + "\n");
			postScore();
		} else if (doesItStarve() == false && doesItDie() == true) {
			System.out.println("The chaos within your Gotch has grown too strong. It has exploded and died." + "\n");
			postScore();
		} else if (doesItStarve() == true && doesItDie() == true) {
			System.out.println("Wow, you really messed that one up." + "\n");
			postScore();
		}

	}
	
	
	private static void play() {
		int chaos = RNG.nextInt(100) +1;
		System.out.println("You play with " + player1.getGotch() + "!");
		if (chaos >= 0 && chaos < 26) {
			System.out.println(player1.getGotch() + " found some very nice flowers! How sweet!\n");
			gainEXP(4);
			scoreUp(15);
		} else if (chaos >= 26 && chaos < 36) {
			System.out.println(player1.getGotch() + " came across some fairies! They sprinkled " + player1.getGotch() + " with magic poweder!\n");
			gainEXP(10);
			scoreUp(20);
		} else  if (chaos > 35 && chaos < 99){
			System.out.println("The two of you had a nice day, but nothing special happened.\n" + player1.getGotch() + " is happy!\n");
			gainEXP(2);
			scoreUp(10);
		} else {
			System.out.println(player1.getGotch() + " played so hard that the chaos within it became overwhelming. It died.");
			scoreUp(1);
			postScore();
		}
	}
	
	private static void waitAndGrow() {
		int chaos = RNG.nextInt(100) +1;
		System.out.println(player1.getGotch() + " is growing inside its cocoon.\n");
		if (chaos <= 11) {
			System.out.println("Oh no! " + player1.getGotch() + "has fallen from the tree it was in and\n" 
							+ "was preyed upon by the creatures of the ground!");
			scoreUp(1);
			postScore();
		}
		else {
			System.out.println(player1.getGotch() + " is growing bigger!\n");
			gainEXP(5);
			scoreUp(8);
		}
	}
	
	private static void spreadHappy() {
		int chaos = RNG.nextInt(100) + 1;
		System.out.println(player1.getGotch() + " went around the world, blessing people with happiness.");
		if (chaos < 11) {
			System.out.println("Frankly, people found " + player1.getGotch() + " rather annoying...");
			hunger--;
			gainEXP(1);
			scoreUp(3);
		} else if (chaos >= 11 && chaos < 21) {
			System.out.println("Many people were overjoyed by " + player1.getGotch() + "'s blessings! They showered "
					+ player1.getGotch() + " with gifts!");
			hunger++;
			gainEXP(4);
			scoreUp(12);
		} else if (chaos >= 21 && chaos < 31) {
			System.out.println(player1.getGotch()
					+ " attempted to cheer up an angry Gryphon. The Gryphon was much happier after eating "
					+ player1.getGotch() + ".");
			scoreUp(1);
			postScore();
		} else if (chaos >= 31 && chaos < 41) {
			System.out.println("A passing benevolent diety was pleased by " + player1.getGotch()
					+ "'s efforts. It granted " + player1.getGotch() + " with a bit of celestial power.");
			gainEXP(10);
			hunger++;
			scoreUp(16);
		} else if (chaos >= 41 && chaos < 51) {
			System.out.println(player1.getGotch() + " made some people happy.");
			hunger--;
			gainEXP(2);
			scoreUp(8);
		} else if (chaos >= 51 && chaos < 61) {
			System.out.println("A kingdom was so happy with " + player1.getGotch()
					+ "'s blessings that the King ordered a celebration for you two.");
			gainEXP(8);
			hunger++;
			scoreUp(14);
		} else if (chaos >= 61 && chaos < 71) {
			System.out.println(player1.getGotch()
					+ " spent a long time trying to cheer up a stubborn troll. It turned out to just be a troll-shaped boulder.");
			hunger--;
			gainEXP(1);
			scoreUp(3);
		} else if (chaos >= 71 && chaos < 81) {
			System.out.println(player1.getGotch()
					+ " showed a Bandit king and his clan the errors of their ways. They were very thankful and fed "
					+ player1.getGotch());
			hunger++;
			gainEXP(4);
			scoreUp(10);
		} else if (chaos >= 81 && chaos < 91) {
			System.out.println(
					player1.getGotch() + " tried to change the hearts of a clan of bandits. They hardly noticed "
							+ player1.getGotch() + " existed");
			hunger--;
			gainEXP(1);
			scoreUp(3);
		} else {
			System.out.println(
					player1.getGotch() + " tried to change the hearts of a clan of bandits. They were pissed off and "
							+ player1.getGotch() + " barely escaped with its life.");
			hunger--;
			scoreUp(2);
		}
	}
	
	private static void scoreUp(int x) {
		int y = x*level;
		score = score + y;
	}
	
	public static void postScore() {
		String spec = evolve(level);
		Gotch end = new Gotch();
		end.setPlayer(player1.getPlayer());
		end.setGotch(player1.getGotch());
		end.setSpecies(spec);
		end.setColor(player1.getColor());
		end.setScore(score);
		placeScore(end);
		System.out.println("/nYour final score is: " + score + "/n");
		currentPlayer[0] = null;
		menu.menus.homeMenu();
	}
	
}
