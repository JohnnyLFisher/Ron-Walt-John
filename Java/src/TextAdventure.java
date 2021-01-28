import java.util.Random;
import java.util.Scanner;


public class TextAdventure {

	static String cont(int health) {

		Scanner in = new Scanner(System.in);

		System.out.println("What would you like to do now?");
		System.out.println("1. Continue fighting");
		System.out.println("2. Exit dungeon");

		String input = in.nextLine();

		while (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
			System.out.println("Invalid input!");
			input = in.nextLine();
		}

		if (input.equals("1")) {
			System.out.println("You continue on your adventure!");
			return "cont";
		} else if (input.equals("2")) {
			System.out.println("You exit the dungeon successful from your adventures!");
			System.out.println("########################");
			System.out.println("# THANKS FOR PLAYING! #");
			System.out.println("########################");
			return "stop";
		} else if (input.equals("3") && health < 1000) {
			System.out.println("Congratulations, you found a secret! Adding 1000 HP");
			health += 1000;
			System.out.println("---------------------------------------------");
			System.out.println((" # You have now have " + health + " HP! #"));
			System.out.println("---------------------------------------------");
			return "cont+1000";
		} else {
			System.out.println("There are no secrets here...");
			return "again";
		}
	}

	static void game(String userName) {

		//	System Objects
		Scanner in = new Scanner(System.in);
		Random rand = new Random();

		//	Game Variables
		String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin"};
		int maxEnemyHealth = 75;
		int enemyAttackDamage = 25;

		//	Player variables
		int health = 100;
		int attackDamage = 50;
		int numHealthPotions = 3;
		int healthPotionHealAmount = 30;
		int healthPotionDropChance = 50;


		while (true) {

			System.out.println("---------------------------------------------");

			int enemyHealth = rand.nextInt(maxEnemyHealth);
			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# " + enemy + " has appeared! #\n");

			while (enemyHealth > 0) {
				System.out.println("\t" + userName + "'s HP: " + health);
				System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
				System.out.println("\tWhat would you like to do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink Health Potion");
				System.out.println("\t3. Run!");


				String input = in.nextLine();
				if (input.equals("1")) {
					int damageDealt = rand.nextInt(attackDamage);
					int damageTaken = rand.nextInt(enemyAttackDamage);

					enemyHealth -= damageDealt;
					health -= damageTaken;
					System.out.println("\t> " + userName + " strikes the " + enemy + " for " + damageDealt + " damage");
					System.out.println("\t> " + userName + " receives " + damageTaken + " in retaliation");

					if (health < 1) {
						System.out.println("\t> You have taken to much damage, you are too weak to go on!");
						break;

					}


				} else if (input.equals("2")) {
					if (numHealthPotions > 0) {
						health += healthPotionHealAmount;
						numHealthPotions--;
						System.out.println("\t> You drink the health potion, healing yourself for " + healthPotionHealAmount
								+ "\n\t> You now have " + health + " HP."
								+ "\n\t> You have " + numHealthPotions + " health potions left.\n");

					} else {
						System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get one!\n");
					}
				} else if (input.equals("3")) {
					System.out.println("\t" + userName + " runs away from the " + enemy + "!");
					break;

				} else {
					System.out.println("\tInvalid Command");

				}

			}

			if (health < 1) {
				System.out.println(userName + " limps out of the dungeon, weak from battle");
				break;
			}
			System.out.println("---------------------------------------------");
			System.out.println((" # You have " + health + " HP left. #"));

			if (enemyHealth <= 0 && rand.nextInt(100) < healthPotionDropChance) {
				numHealthPotions++;
				System.out.println(" # The " + enemy + " dropped a health potion! # ");
				System.out.println(" # You now have " + numHealthPotions + " health potions(s). #");
			}

			System.out.println("---------------------------------------------");

			String cont = cont(health);

			if (cont.equals("cont")) {
				continue;
			} else if (cont.equals("cont+1000")) {
				health += 1000;
				cont(health);
			} else if (cont.equals("again")) {
				cont(health);
			} else {
				break;
			}

		}

	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);


		System.out.println("Do you want to enter the Dungeon of Doom? (\"yes or no\")");
		String userInput = in.nextLine();

		if (userInput.equalsIgnoreCase("yes")) {
			System.out.println("What's your name?");
			String userName = in.nextLine();
			System.out.println("Welcome, " + userName + " to the Dungeon of Doom!!!");

			game(userName);

		} else {
			System.out.println("You have chosen not to enter the Dungeon of Doom. Perhaps you will live to fight another day...");
		}

	}
}
