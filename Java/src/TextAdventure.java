import java.util.Random;
import java.util.Scanner;

//public class TextAdventure {




//    Ask if the user is ready to start. If they type in "yes", start the game.
//public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);

//
//
//}




//    Ask the user for their name. Store this as a variable to personalize the adventure.

//    A classic RPG will have the hero going through different scenarios and battling their enemies.

//    Display enemy stats and hero stats. Properties and values can be assigned by you.

//    For example: Health, Attack Points, etc.
//    Decide on what actions your hero can take.
//    Attack (decreases enemyHealth)
//    Drink potion (adds to heroHealth)
//    Run? (ends the game)
//    Keep asking for user input until the enemyHealth reaches 0, then end the game.


//}



public class TextAdventure {
    public static void main(String[] args) {

//        System Objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

//        Game Variables
        String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin"};
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;

//        Player variables

        int health = 100;
        int attackDamage = 50;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50;

        boolean running = true;

        System.out.println("Do you want to enter the dungeon? :");
        String userInput= in.nextLine();
        System.out.println("What's your name:");
        String userName = in.nextLine();
        System.out.println("Welcome, " + userName + " to the Dungeon of Doom!!!");




        GAME:
        while (running) {
            System.out.println("---------------------------------------------");

            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + "  has appeared! #\n");
//                    Skeleton has appeared

            while (enemyHealth > 0) {
                System.out.println("\tYour HP:" + health);
                System.out.println("\t " + enemy + "'s HP " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink Health Potion");
                System.out.println("\t3. Run!");


                String input = in.nextLine();
                if (input.equals("1")) {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;
                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage");
                    System.out.println("\t> You receive " + damageTaken + " in retaliation ");

                    if (health < 1) {
                        System.out.println("t> You have taken to much damage, you are too weak to go on!");
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
                }
                else if (input.equals("3")) {
                    System.out.println("\tYou run away from the " + enemy + "!");
                    continue GAME;

                } else {
                    System.out.println("\tInvalid Command");

                }
            }

            if(health<1){
                System.out.println("You limp out of the dungeon, weak from battle");
                break;
            }
            System.out.println("---------------------------------------------");
            System.out.println((" # You have " + health +  " HP left.#"));
            if(rand.nextInt(100) < healthPotionDropChance){
                numHealthPotions++;
                System.out.println(" # The " +enemy + " dropped a health potion! # ");
                System.out.println(" # You now have " + numHealthPotions+ " health potions(s). #");
            }
            System.out.println("---------------------------------------------");
            System.out.println("What would you like to do now");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit dungeon");

            String input = in.nextLine();

            while (!input.equals("1") && !input.equals("2")){
                System.out.println("Invalid input!");
                input = in.nextLine();
            }

            if(input.equals("1")){
                System.out.println("You continue on your adventure!");
            }
            else if(input.equals("2")){
                System.out.println("You exit the dungeon successful from your adventures!");
                break;
            }

            System.out.println("########################");
            System.out.println("#  THANKS FOR PLAYING! #");
            System.out.println("########################");





        }


    }
}
