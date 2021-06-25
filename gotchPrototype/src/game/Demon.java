package game;

import java.util.Random;
import java.util.Scanner;

import parent.Gotch;

public class Demon extends GameMode{
	
	static Scanner input3 = new Scanner(System.in);
	static Random RNG = new Random();
	static int hunger = 5;
	static int level = 1;
	static int exp = 0;
	static int day = 1;
	static int score = 0;
	static int evil = 0;
	
	
	
	public static void demonGame() {
		System.out.println("Hello, " + player1.getPlayer() + 
				". Your Demon, " + player1.getGotch() + 
				", is just an Imp right now.\nYou must raise it"
				+ " to create a powerful Gotch. See how \npowerful "
				+ "you can make " + player1.getGotch() + " become "
						+ "before it \nreaches its inevitable death!\n" 
				+ "\n");
		switchboard();
	}

	private static String evolve(int level) {
		if (level < 5 ) {
			return "Imp";
		}
		else
			if (level >= 5 && level < 10) {
				return "Troll";
			}
			else
				return "Lord of Destruction";
	}
	
	private static void switchboard() {
		System.out.println(player1.getGotch() + " is currently a level "
				+ level + " " + evolve(level) + ".\nIts energy level is currently at " 
				+ hunger + ".\n" + "It is day " + day + ".\n");
		
		if (evolve(level).equals("Imp")) {
			System.out.println("Choose an action:\n" + "1. Feed\n" + "2. Train\n" + "3. Prank");
			int choice = input3.nextInt();
			switch (choice) {
			case 1:
				System.out.println("You have fed " + player1.getGotch() + "\n");
				hunger = hunger + 2;
				scoreUp(1);
				gainEXP(1);
				endDay();
				break;
			case 2:
				System.out.println("You have put " + player1.getGotch() + " through rigorous training!\n");
				hunger--;
				scoreUp(2);
				gainEXP(4);
				endDay();
				break;
			case 3:
				prank();
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
		if (evolve(level).equals("Troll")) {
			System.out.println("Choose an action:\n" + "1. Feed\n" + "2. Train\n" + "3. Torment");
			int choice = input3.nextInt();
			switch (choice) {
			case 1:
				System.out.println("You have fed " + player1.getGotch() + "\n");
				hunger = hunger + 2;
				scoreUp(1);
				gainEXP(1);
				endDay();
				break;
			case 2:
				System.out.println("You have put " + player1.getGotch() + " through rigorous training!\n");
				hunger--;
				scoreUp(2);
				gainEXP(4);
				endDay();
				break;
			case 3:
				torment();
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
		if (evolve(level).equals("Lord of Destruction")) {
			System.out.println("Choose an action:\n" + "1. Feed\n" + "2. Train\n"
					+ "3. Spread your evil!");
			int choice = input3.nextInt();
			switch (choice) {
			case 1:
				System.out.println("You have fed " + player1.getGotch() + "\n");
				hunger = hunger +2;
				scoreUp(1);
				gainEXP(1);
				endDay();
				break;
			case 2:
				System.out.println("You have put " + player1.getGotch() + " through rigorous training!\n");
				hunger--;
				scoreUp(2);
				gainEXP(4);
				endDay();
				break;
			case 3:
				spreadEvil();
				hunger--;
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
		if (day <= 4 && chaos < 1) {
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
	
	private static boolean doesGoodWin() {
		int chaos = RNG.nextInt(70) +1;
		if (evil > chaos) {
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
			System.out.println("Congratulations! " + player1.getGotch() + " has grown into a Troll! It's not very nice.");
		}
		if (level == 10 && exp == 0) {
			System.out.println("Congratulations! " + player1.getGotch() + " has grown into a Lord of Destruction! "
					+ "It wants to spread its evil!");
		}
	}
	
	private static void endDay() {
		if (doesGoodWin() == true) {
			System.out.println("The forces of good have prevailed! They have slain " + player1.getGotch() 
			+ " and wiped its evil from the world!");
			scoreUp(3);
			postScore();
		} else	if (doesItStarve() == false && doesItDie() == false) {
			day++;
			switchboard();
		} else if (doesItStarve() == true && doesItDie() == false) {
			System.out.println("You have starved your Gotch to death. You are the real monster.\n");
			postScore();
		} else if (doesItStarve() == false && doesItDie() == true) {
			System.out.println("The chaos within your Gotch has grown too strong. It has exploded and died.\n");
			postScore();
		} else if (doesItStarve() == true && doesItDie() == true) {
			System.out.println("Wow, you really messed that one up.\n");
			postScore();
		}

	}
	
	
	private static void prank() {
		int chaos = RNG.nextInt(100) +1;
		System.out.println("You play with " + player1.getGotch() + "!");
		if (chaos >= 0 && chaos < 26) {
			System.out.println(player1.getGotch() + " truly made people miserable today!\n");
			evil++;
			gainEXP(4);
			scoreUp(3);
		} else if (chaos >= 26 && chaos < 36) {
			System.out.println(player1.getGotch() + " stole a magic amulet from a passing wizard unnoticed!\n");
			evil++;
			gainEXP(10);
			scoreUp(5);
		} else  if (chaos > 35){
			System.out.println("The two of you pulled some small pranks, but nothing very interesting.\n");
			gainEXP(2);
			scoreUp(2);
		} 
	}
	
	private static void torment() {
		int chaos = RNG.nextInt(100) +1;
		System.out.println(player1.getGotch() + " went looking for a town of people to torment.\n");
		if (chaos >= 0 && chaos < 26) {
			System.out.println(player1.getGotch() + " made a large town of folks miserable!\n");
			evil++;
			gainEXP(4);
			scoreUp(3);
		} else if (chaos >= 26 && chaos < 36) {
			System.out.println(player1.getGotch() + " brought an entire city to ruin! What a terrible Troll!\n");
			evil++;
			gainEXP(10);
			scoreUp(5);
		} else  if (chaos > 35){
			System.out.println(player1.getGotch() + " scared away some folks, but didn't do anything eventful.\n");
			gainEXP(2);
			scoreUp(2);
		}
	}
	
	private static void spreadEvil() {
		int chaos = RNG.nextInt(100) +1;
		System.out.println(player1.getGotch() + " went around the world, plaguing it with evil!");
		if (chaos >= 0 && chaos < 26) {
			System.out.println(player1.getGotch() + " brought a country to its knees!\n");
			evil++;
			gainEXP(4);
			scoreUp(3);
		} else if (chaos >= 26 && chaos < 36) {
			System.out.println(player1.getGotch() + " has consumed the world in its evil! It is gaining power from the fear of the people!\n");
			evil++;
			gainEXP(10);
			scoreUp(5);
		} else  if (chaos > 35 && chaos < 97){
			System.out.println(" Unfortunately, it was a boring day for the evil Demon...\n");
			gainEXP(2);
			scoreUp(2);
		} else {
			System.out.println(player1.getGotch() + " was slain by a valiant Dog Knight. Good prevails!.");
			scoreUp(1);
			postScore();
		}
	}
	
	private static void scoreUp(int x) {
		int y = x*evil;
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
