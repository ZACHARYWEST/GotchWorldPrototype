package parent;

import java.util.Arrays;
import java.util.Scanner;

public class Gotch {

	private String player;
	private String gotch;
	private String species;
	private String color;
	private int score;
		
	static Object[] playerList = new Object[10];
	protected static Object[] currentPlayer = new Object[1];
	
	
	public Gotch(String player, String gotch, String species, String color) {
		this.player = player;
		this.gotch = gotch;
		this.species = species;
		this.color = color;
		score = 0;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Gotch() {
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public String getGotch() {
		return gotch;
	}

	public void setGotch(String gotch) {
		this.gotch = gotch;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public static void createGotch() {
		Scanner input = new Scanner(System.in);
		Gotch player = new Gotch();
		System.out.println("Enter Player's name:");
		player.setPlayer(input.nextLine());
		System.out.println("Welcome, " + player.getPlayer() + ". Now choose a species of Gotch:");
		String species = chooseSpecies1();
		player.setSpecies(species);
		System.out.println("Good choice!");
		String color = chooseColor1();
		player.setColor(color);
		System.out.println("You have chosen a " + player.getColor() + " " + player.getSpecies() + "! Now give it a name:");
		player.setGotch(input.nextLine());
		currentPlayer[0] = player;
		
	}
	
	private static String chooseSpecies1() {
		Scanner input2 = new Scanner(System.in);
		System.out.println("Options:\n" + "1. Doggo\n" + "2. Rat Bat\n" + "3. Dadpole\n" +
				"4. Cat-a-pillar\n" + "5. Demon\n");
		String PC = input2.nextLine();
		String result = chooseSpecies2(PC);
		return result;
	}
	
	private static String chooseSpecies2(String choice) {
		String spec = null;
		if (choice.equalsIgnoreCase("Doggo") || choice.equals("1")) {
			spec = "Doggo";
		} else 
			if (choice.equalsIgnoreCase("Rat Bat") || choice.equalsIgnoreCase("RatBat") || choice.equals("2")) {
			spec = "Rat Bat";
		} else
			if (choice.equalsIgnoreCase("Dadpole") || choice.equals("3")) {
			spec = "Dadpole";
		} else 
			if (choice.equalsIgnoreCase("Cat-a-pillar") || choice.equalsIgnoreCase("Catapillar")
				|| choice.equals("4")) {
			spec = "Cat-a-pillar";
		} else 
			if (choice.equalsIgnoreCase("Demon") || choice.equals("5")) {
			spec = "Demon";
		} else {
			System.out.println("Error. Please try again.");
			chooseSpecies1();
		}
		return spec;
	}
	
	private static String chooseColor1() {
		Scanner input2 = new Scanner(System.in);
		System.out.println("Now select it's color: red, blue, or green.");
		String PC = input2.nextLine();
		String result = chooseColor2(PC);
		return result;
	}
	
	private static String chooseColor2(String choice) {
		String spec = null;
		if (choice.equalsIgnoreCase("red") || choice.equalsIgnoreCase("R")) {
			spec = "red";
		} else
			if (choice.equalsIgnoreCase("blue") || choice.equalsIgnoreCase("B")) {
			spec = "blue";
		} else
			if (choice.equalsIgnoreCase("green") || choice.equalsIgnoreCase("G")) {
			spec = "green";
		} else {
			System.out.println("Error. Please try again.");
			chooseColor1();
		}
		return spec;
	}
	
	@Override
	public String toString() {
		return "Score: " + score + " --- Player: " + player + " --- Gotch: " + gotch + " (" +  color + " " + species + ")";
	}
	
	public static void placeScore(Gotch ff) {
		int[] scores = new int[10];
		for (int i = 0; i < 10; i++) {
			if(playerList[0] != null && playerList[1] != null && playerList[2] != null && playerList[3] != null && 
					playerList[4] != null && playerList[5] != null && playerList[6] != null && playerList[7] != null &&
					playerList[8] != null && playerList[9] != null) {
					Gotch temp0 = new Gotch();
					temp0 = (Gotch) playerList[0];
					scores[0] = temp0.getScore();
					Gotch temp1 = new Gotch();
					temp1 = (Gotch) playerList[1];
					scores[1] = temp1.getScore();
					Gotch temp2 = new Gotch();
					temp2 = (Gotch) playerList[2];
					scores[2] = temp2.getScore();
					Gotch temp3 = new Gotch();
					temp3 = (Gotch) playerList[3];
					scores[3] = temp3.getScore();
					Gotch temp4 = new Gotch();
					temp4 = (Gotch) playerList[4];
					scores[4] = temp4.getScore();
					Gotch temp5 = new Gotch();
					temp5 = (Gotch) playerList[5];
					scores[5] = temp5.getScore();
					Gotch temp6 = new Gotch();
					temp6 = (Gotch) playerList[6];
					scores[6] = temp6.getScore();
					Gotch temp7 = new Gotch();
					temp7 = (Gotch) playerList[7];
					scores[7] = temp7.getScore();
					Gotch temp8 = new Gotch();
					temp8 = (Gotch) playerList[8];
					scores[8] = temp8.getScore();
					Gotch temp9 = new Gotch();
					temp9 = (Gotch) playerList[9];
					scores[9] = temp9.getScore();
					Arrays.sort(scores); //sorts in ascending order
					for (int k = 0; k < 10; k++) {
						Gotch secTemp = new Gotch();
						secTemp = (Gotch) playerList[k];
						if (secTemp.getScore() == scores[0]) {
							playerList[k] = null;
							playerList[k] = ff;
							break;
						}
					}
			}
			else	
			if (playerList[i] == null) {
				playerList[i] = ff;
				break;
			}
		}
	}
	
	public static void displayScoreboard() {
		System.out.println("\n------------------------------------------------------------");
		for (int i = 0; i<playerList.length; i++) {
			if (playerList[i] != null) {
				System.out.println("| " + playerList[i].toString()+" |");
			}
		}
		System.out.println("------------------------------------------------------------\n");
	}
	
}
