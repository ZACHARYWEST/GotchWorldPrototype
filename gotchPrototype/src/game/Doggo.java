package game;

import java.util.Random;
import java.util.Scanner;

import parent.Gotch;

public class Doggo extends GameMode{
	
	static Scanner input3 = new Scanner(System.in);
	static Random RNG = new Random();
	static int hunger = 5;
	static int level = 1;
	static int exp = 0;
	static int day = 1;
	static int score = 0;
	
	
	
	public static void doggoGame() {
		System.out.println("Hello, " + player1.getPlayer() + 
				". Your Doggo, " + player1.getGotch() + 
				", is just a Pupper right now.\nYou must raise it"
				+ " to create a powerful Gotch. See how \npowerful "
				+ "you can make " + player1.getGotch() + " become "
						+ "before it \nreaches its inevitable death!\n" 
				+ "\n");
		switchboard();
	}

	private static String evolve(int level) {
		if (level < 5 ) {
			return "Pupper";
		}
		else
			if (level >= 5 && level < 10) {
				return "Dawg";
			}
			else
				return "Dog Knight";
	}
	
	private static void switchboard() {
		System.out.println(player1.getGotch() + " is currently a level "
				+ level + " " + evolve(level) + ".\nIts energy level is currently at " 
				+ hunger + ".\n" + "It is day " + day + ".\n");
		
		if (evolve(level).equals("Pupper")) {
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
		if (evolve(level).equals("Dawg")) {
			System.out.println("Choose an action:\n" + "1. Feed\n" + "2. Train\n" + "3. Serve the community");
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
				serve();
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
		if (evolve(level).equals("Dog Knight")) {
			System.out.println("Choose an action:\n" + "1. Feed\n" + "2. Train\n"
					+ "3. Protect the people of the world from Evil!");
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
				protect();
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
		if (day <= 4 && chaos < 3) {
			return true;
		} else if (day > 4 && day <= 8 && chaos < 5) {
			return true;
		} else if (day > 8 && day <= 12 && chaos < 8) {
			return true;
		} else if (day > 12 && day <= 16 && chaos < 10) {
			return true;
		} else if (day > 16 && day <= 20 && chaos < 13) {
			return true;
		} else if (day > 20 && day <= 24 && chaos < 15) {
			return true;
		} else if (day > 24 && day <= 28 && chaos < 17) {
			return true;
		} else if (day > 28 && day <= 32 && chaos < 20) {
			return true;
		} else if (day > 32 && day <= 35 && chaos < 25) {
			return true;
		} else if (day > 35 && day <= 38 && chaos < 30) {
			return true;
		} else if (day > 38 && day <= 41 && chaos < 35) {
			return true;
		} else if (day > 41 && day <= 44 && chaos < 40) {
			return true;
		} else if (day > 44 && day <= 47 && chaos < 45) {
			return true;
		} else if (day > 47 && day <= 50 && chaos < 50) {
			return true;
		} else if (day > 50 && day <= 53 && chaos < 60) {
			return true;
		} else if (day > 53 && day <= 56 && chaos < 70) {
			return true;
		} else if (day > 56 && day <= 59 && chaos < 80) {
			return true;
		} else if (day > 62 && day <= 65 && chaos < 90) {
			return true;
		} else if (day > 65) {
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
			System.out.println("Congratulations! " + player1.getGotch() + " has grown into a Dawg! It loves to help people.");
		}
		if (level == 10 && exp == 0) {
			System.out.println("Congratulations! " + player1.getGotch() + " has grown into a Dog Knight! It is dedicated to fighting evil!");
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
			System.out.println(player1.getGotch() + " dug up a bone! How exciting!" + "\n");
			gainEXP(4);
			scoreUp(15);
		} else if (chaos >= 26 && chaos < 36) {
			System.out.println(player1.getGotch() + " dug up a magic crystal! That's super lucky!" + "\n");
			gainEXP(10);
			scoreUp(20);
		} else  if (chaos > 35 && chaos < 99){
			System.out.println("The two of you had a nice day, but nothing special happened.\n" + player1.getGotch() + " is happy!" + "\n");
			gainEXP(2);
			scoreUp(10);
		} else {
			System.out.println(player1.getGotch() + " played so hard that the chaos within it became overwhelming. It died.");
			scoreUp(1);
			postScore();
		}
	}
	
	private static void serve() {
		int chaos = RNG.nextInt(100) +1;
		System.out.println(player1.getGotch() + " went around town, searching for people in need." + "\n");
		if (chaos >= 0 && chaos < 26) {
			System.out.println(player1.getGotch() + " made a huge impact on the community! How grand!" + "\n");
			gainEXP(4);
			scoreUp(15);
		} else if (chaos >= 26 && chaos < 36) {
			System.out.println(player1.getGotch() + " helped an old lady, who turned out to be a nice witch!\n"
					+ "She used her magic to strengthen " + player1.getGotch() + "!" + "\n");
			gainEXP(10);
			scoreUp(20);
		} else  if (chaos > 35 && chaos < 98){
			System.out.println("The two of you helped some folks, but nothing special happened.\n" + player1.getGotch() + " is content!" + "\n");
			gainEXP(2);
			scoreUp(10);
		} else {
			System.out.println(player1.getGotch() + " was overwhelmed by bandits. It died.");
			scoreUp(1);
			postScore();
		}
	}
	
	private static void protect() {
		int chaos = RNG.nextInt(100) +1;
		System.out.println(player1.getGotch() + " went around the world, searching for Evil.");
		if (chaos >= 0 && chaos < 26) {
			System.out.println(player1.getGotch() + " slayed some evil monsters! It was very courageous!" + "\n");
			gainEXP(4);
			scoreUp(15);
		} else if (chaos >= 26 && chaos < 36) {
			System.out.println(player1.getGotch() + " vanquished an evil demon lord!\n"
					+ player1.getGotch() + " gained so much power!" + "\n");
			gainEXP(10);
			scoreUp(20);
		} else  if (chaos > 35 && chaos < 97){
			System.out.println("You two defeated some bandits, but nothing special happened.\n" + player1.getGotch() + " is pleased!" + "\n");
			gainEXP(2);
			scoreUp(10);
		} else {
			System.out.println(player1.getGotch() + " ran into a dragon's den where it was outnumbered and didn't stand a chance. It died.");
			scoreUp(1);
			postScore();
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
