package game;

import java.util.Random;
import java.util.Scanner;

import parent.Gotch;

public class RatBat extends GameMode{
	
	static Scanner input3 = new Scanner(System.in);
	static Random RNG = new Random();
	static int hunger = 5;
	static int level = 1;
	static int exp = 0;
	static int day = 1;
	static int score = 0;
	
	
	
	public static void ratbatGame() {
		System.out.println("Hello, " + player1.getPlayer() + 
				". Your Rat Bat, " + player1.getGotch() + 
				", is just a Rat right now.\nYou must raise it"
				+ " to create a powerful Gotch. See how \npowerful "
				+ "you can make " + player1.getGotch() + " become "
						+ "before it \nreaches its inevitable death!\n" 
				+ "\n");
		switchboard();
	}

	private static String evolve(int level) {
		if (level < 5 ) {
			return "Rat";
		}
		else
			if (level >= 5 && level < 10) {
				return "Bat";
			}
			else
				return "Big Scary Rat Bat";
	}
	
	private static void switchboard() {
		System.out.println(player1.getGotch() + " is currently a level "
				+ level + " " + evolve(level) + ".\nIts energy level is currently at " 
				+ hunger + ".\n" + "It is day " + day + ".\n");
		
		if (evolve(level).equals("Rat")) {
			System.out.println("Choose an action:\n" + "1. Feed\n" + "2. Train\n" + "3. Scavenge");
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
				System.out.println("You have put " + player1.getGotch() + " through rigorous training!\n");
				hunger--;
				scoreUp(8);
				gainEXP(4);
				endDay();
				break;
			case 3:
				scavenge();
				endDay();
				break;
			default:
				System.out.println("Error, retrying...");
				switchboard();
				break;
			}
		} 
		else 
		if (evolve(level).equals("Bat")) {
			System.out.println("Choose an action:\n" + "1. Feed\n" + "2. Train\n" + "3. Take flight!");
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
				System.out.println("You have put " + player1.getGotch() + " through rigorous training!\n");
				hunger--;
				scoreUp(8);
				gainEXP(4);
				endDay();
				break;
			case 3:
				fly();
				endDay();
				break;
			default:
				System.out.println("Error, retrying...");
				switchboard();
				break;
			}
		} 
		else
		if (evolve(level).equals("Big Scary Rat Bat")) {
			System.out.println("Choose an action:\n" + "1. Feed\n" + "2. Train\n"
					+ "3. Hunt below the moonlight!");
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
				System.out.println("You have put " + player1.getGotch() + " through rigorous training!\n");
				hunger--;
				scoreUp(8);
				gainEXP(4);
				endDay();
				break;
			case 3:
				hunt();
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
			System.out.println("Congratulations! " + player1.getGotch() + " has grown into a Bat! It can now take to the skies!");
		}
		if (level == 10 && exp == 0) {
			System.out.println("Congratulations! " + player1.getGotch() + " has grown into a Big Scary Rat Bat! It is a true creature of the night now!");
		}
	}
	
	private static void endDay() {

		if (doesItStarve() == false && doesItDie() == false) {
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
	
	
	private static void scavenge() {
		int chaos = RNG.nextInt(100) +1;
		System.out.println(player1.getGotch() + " scavenges the area.");
		if (chaos >= 99){
			System.out.println(player1.getGotch() + " ran into a big mouse trap. How unfortunate. It died.");
			scoreUp(1);
			postScore();
		} else if (hunger >= 3 && hunger <= 4 && chaos >= 11 && chaos <99) {
			System.out.println(player1.getGotch() + " found some yummy, moldy food! Hooray!\n");
			hunger++;
			gainEXP(4);
			scoreUp(15);
		} else if (hunger >= 3 && hunger <= 4 && chaos < 11) {
			System.out.println(player1.getGotch() + " found some magic bread and a potion to wash it down with!\n");
			hunger++;
			gainEXP(10);
			scoreUp(20);
		} else  if (hunger < 3){
			System.out.println(player1.getGotch() + " was low on energy, so it didn't find much...\n");
			hunger--;
			gainEXP(2);
			scoreUp(10);
		}  else  if (hunger > 4){
			System.out.println(player1.getGotch() + " had such a full belly, it didn't move around very much...\n");
			hunger--;
			gainEXP(2);
			scoreUp(10);
		} 
	}
	
	private static void fly() {
		int chaos = RNG.nextInt(100) +1;
		System.out.println(player1.getGotch() + " tries for take off...");
		if (chaos >= 98){
			System.out.println(player1.getGotch() + " was killed and eaten by a Giant Owl! Oh no!");
			scoreUp(1);
			postScore();
		}  else if (hunger >= 3 && hunger <= 4 && chaos >= 11 && chaos <98) {
			System.out.println(player1.getGotch() + " was able to fly and snack on the bugs in the air!\n");
			hunger++;
			gainEXP(4);
			scoreUp(15);
		} else if (hunger >= 3 && hunger <= 4 && chaos < 11) {
			System.out.println(player1.getGotch() + " was able to fly, and ate a mystical bug of power while hunting!\n");
			hunger++;
			gainEXP(10);
			scoreUp(20);
		} else  if (hunger < 3){
			System.out.println(player1.getGotch() + " was low on energy, so it could hardly get off the ground...\n");
			hunger--;
			gainEXP(2);
			scoreUp(5);
		}  else  if (hunger > 4){
			System.out.println(player1.getGotch() + " had such a full belly, it couldn't take off...\n");
			hunger--;
			gainEXP(2);
			scoreUp(5);
		}
	}
	
	private static void hunt() {
		int chaos = RNG.nextInt(100) +1;
		System.out.println(player1.getGotch() + " takes flight into the night!");
		if (chaos >= 97){
			System.out.println(player1.getGotch() + " was killed by a Vampire Hunter! Oh no!");
			scoreUp(1);
			postScore();
		}  else if (hunger >= 3 && hunger <= 4 && chaos >= 11 && chaos <97) {
			System.out.println(player1.getGotch() + " flew through a local village and drank the blood of the people!\n");
			hunger++;
			gainEXP(4);
			scoreUp(15);
		} else if (hunger >= 3 && hunger <= 4 && chaos < 11) {
			System.out.println(player1.getGotch() + " fought a Vampire and won! It absorbed the Vampire's power!\n");
			hunger++;
			gainEXP(10);
			scoreUp(20);
		} else  if (hunger < 3){
			System.out.println(player1.getGotch() + " was low on energy, so it could only hunt on the ground.\n");
			hunger--;
			gainEXP(2);
			scoreUp(5);
		}  else  if (hunger > 4){
			System.out.println(player1.getGotch() + " had such a full belly, it couldn't take off, and only hunted on the ground.\n");
			hunger--;
			gainEXP(2);
			scoreUp(5);
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
