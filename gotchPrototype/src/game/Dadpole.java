package game;

import java.util.Random;
import java.util.Scanner;

import parent.Gotch;

public class Dadpole extends GameMode{
	
	static Scanner input3 = new Scanner(System.in);
	static Random RNG = new Random();
	static int hunger = 5;
	static int level = 1;
	static int exp = 0;
	static int day = 1;
	static int score = 0;
	static int suicide = 0;
	static int tired = 0;
	
	
	
	public static void dadpoleGame() {
		System.out.println("Hello, " + player1.getPlayer() + 
				". Your Dadpole, " + player1.getGotch() + 
				", is just a Young Dadpole right now.\nYou must raise it"
				+ " to create a powerful Gotch. See how \npowerful "
				+ "you can make " + player1.getGotch() + " become "
						+ "before it \nreaches its inevitable death!\n" 
				+ "\n");
		switchboard();
	}

	private static String evolve(int level) {
		if (level < 5 ) {
			return "Young Dadpole";
		}
		else
			if (level >= 5 && level < 10) {
				return "Midlife Crisis Frog";
			}
			else
				return "Grand Father Frog";
	}
	
	private static void switchboard() {
		System.out.println(player1.getGotch() + " is currently a level "
				+ level + " " + evolve(level) + ".\nIts energy level is currently at " 
				+ hunger + ".\n" + "It is day " + day + ".\n");
		
		if (evolve(level).equals("Young Dadpole")) {
			System.out.println("Choose an action:\n" + "1. Feed\n" + "2. Train\n" + "3. Tell Dad Jokes");
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
				trainingStress();
				scoreUp(8);
				gainEXP(4);
				endDay();
				break;
			case 3:
				joke();
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
		if (evolve(level).equals("Midlife Crisis Frog")) {
			System.out.println("Choose an action:\n" + "1. Feed\n" + "2. Train\n" + "3. Contemplate life");
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
				trainingStress();
				scoreUp(8);
				gainEXP(4);
				endDay();
				break;
			case 3:
				contemplate();
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
		if (evolve(level).equals("Grand Father Frog")) {
			System.out.println("Choose an action:\n" + "1. Feed\n" + "2. Train\n"
					+ "3. Bestow wisdom");
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
				System.out.println("A Grand Father Frog no longer trains. It only eats and bestows wisdom.");
				switchboard();
				break;
			case 3:
				wisdom();
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
			System.out.println("Congratulations! " + player1.getGotch() + " has grown into a Midlife Crisis Frog! It is more easily stressed.");
		}
		if (level == 10 && exp == 0) {
			System.out.println("Congratulations! " + player1.getGotch() + " has grown into a Grand Father Frog! It has grown wise and caring.");
			suicide = 0;
		}
	}
	
	private static void endDay() {
		if (suicide == 10) {
			suicide();
			postScore();
		} else if (doesItStarve() == false && doesItDie() == false) {
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
	
	
	private static void joke() {
		int chaos = RNG.nextInt(100) +1;
		System.out.println("You play with " + player1.getGotch() + "!");
		if (chaos >= 0 && chaos < 31) {
			System.out.println(player1.getGotch() + " told a really funny joke that made the two of you laugh together.\n");
			gainEXP(4);
			scoreUp(15);
		} else if (chaos >= 31 && chaos < 41) {
			System.out.println(player1.getGotch() + " told a dad joke so funny, it caused a whole crowd of people to laugh hysterically." + "\n");
			gainEXP(10);
			scoreUp(20);
		} else  if (chaos >= 41 && chaos < 91){
			System.out.println(player1.getGotch() + " told a few dad jokes. They were groan worthy.\n" + player1.getGotch() + " seemed happy with them.\n");
			gainEXP(2);
			scoreUp(10);
		} else {
			System.out.println(player1.getGotch() + " told a dad joke so bad that even " +player1.getGotch()+" hated it.");
			scoreUp(2);
			suicide++;
		}
	}
	
	private static void contemplate() {
		int chaos = RNG.nextInt(100) +1;
		System.out.println(player1.getGotch() + " spent time deep in thought.");
		if (chaos < 26) {
			System.out.println(player1.getGotch() + " dwelled on many dark thoughts and worries. Life is hard for a frog.");
			suicide++;
			scoreUp(5);
			gainEXP(1);
		} else if (chaos >= 26 && chaos < 51) {
			System.out.println(player1.getGotch() + " has overcome some of its stress with your help, " + player1.getPlayer() + "!");
			suicide--;
			scoreUp(17);
			gainEXP(6);
		} else if (chaos >= 51 && chaos < 76) {
			System.out.println(player1.getGotch() + " is becoming increasingly stressed. Life is hard for a frog.");
			suicide++;
			scoreUp(5);
			gainEXP(1);
		} else {
			System.out.println(player1.getGotch() + " was just daydreaming. Life isn't so bad for a frog.");
			scoreUp(10);
			gainEXP(2);
		}
	}
	
	private static void wisdom() {
		int chaos = RNG.nextInt(100) +1;
		System.out.println(player1.getGotch() + " sits atop a mountain, ready to bestow wisdom to those who seek it.");
		if (chaos < 26) {
			System.out.println("Nobody came to seek " + player1.getGotch() + "'s wisdom today.");
			scoreUp(5);
			gainEXP(1);
		} else if (chaos >= 26 && chaos < 51) {
			System.out.println(player1.getGotch() + " has granted some wisdom to you, " + player1.getPlayer() + ", and the two of you became better together!");
			scoreUp(15);
			gainEXP(5);
		} else if (chaos >= 51 && chaos < 76) {
			System.out.println("Many people came to seek " + player1.getGotch() + "'s wisdom today. It was revered for its knowledge.");
			scoreUp(20);
			gainEXP(5);
		} else {
			System.out.println("Only one person came to seek " + player1.getGotch() + "'s wisdom today. Every soul counts, though.");
			scoreUp(10);
			gainEXP(2);
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
	
	private static void suicide() {
		int chaos = RNG.nextInt(5) +1;
		if (chaos == 1) {
			System.out.println(player1.getGotch() + " couldn't take it anymore. It forced itself to spontaneously combust.");
		} else if (chaos == 2) {
			System.out.println(player1.getGotch() + " couldn't take it anymore. It ran into a pit of scorpions.");
		} else if (chaos == 3) {
			System.out.println(player1.getGotch() + " couldn't take it anymore. It stepped into moving traffic.");
		} else if (chaos == 4) {
			System.out.println(player1.getGotch() + " couldn't take it anymore. It hopped underneath a lawn mower.");
		} else if (chaos == 5) {
			System.out.println(player1.getGotch() + " couldn't take it anymore. It summoned a demon and fed itself to it.");
		}
		
	}
	
	private static void trainingStress() {
		tired++;
		if (tired == 4) {
			suicide++;
			tired = 0;
		}	
	}
	
	
}
