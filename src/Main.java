//Note: some of this code was copied from my Project 2 code

import java.util.*;

public class Main
{
    /*
     *  The goal of printOptionsAndCatchErrors is to print the
     *  options to the user, catch any errors in the input and
     *  return the user's choice to the main method.
     */
    public static int printOptionsAndCatchErrors()
    {
        int userChoice = 0;
        Boolean error = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n1. List Pokemon");
        System.out.println("2. Add Pokemon");
        System.out.println("3. Check a Pokemon's Stats");
        System.out.println("4. Evolve a Pokemon");
        System.out.println("5. Sort Pokemon");
        System.out.println("6. Exit");
        System.out.print("\nWhat would you like to do? ");


        while (error)
        {
            try
            {
                userChoice = scanner.nextInt();

                if (userChoice < 1)
                {
                    System.out.println("\nThat is not a valid choice. Try again.");
                }
                else if (userChoice > 6)
                {
                    System.out.println("\nThat is not a valid choice. Try again.");
                }
                else
                {
                    error = false;
                    return userChoice;
                }
            }
            catch (InputMismatchException notAnInt)
            {
                System.out.println("\nThat is not a valid choice. Try again.");
            }
            catch (Exception except)
            {
                System.out.println("\nThat is not a valid choice. Try again.");
            }

            scanner.nextLine();

            System.out.println("\n1. List Pokemon");
            System.out.println("2. Add Pokemon");
            System.out.println("3. Check a Pokemon's Stats");
            System.out.println("4. Evolve a Pokemon");
            System.out.println("5. Sort Pokemon");
            System.out.println("6. Exit");
            System.out.print("\nWhat would you like to do? ");
        }
        return userChoice;
    }

    /*
     *  The goal of checkNumInRegion is to check the input
     *  that the user gives for the number of Pokemon in the
     *  region to make sure that it is an int.
     */
    public static int checkNumInRegion()
    {
        int userChoice = 0;
        Boolean error = true;
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many Pokemon are in your region: ");

        while (error)
        {
            try
            {
                userChoice = scanner.nextInt();

                error = false;
                return userChoice;

            }
            catch (InputMismatchException notAnInt)
            {
                System.out.println("\nThat is not a valid choice. Try again.");
            }
            catch (Exception except)
            {
                System.out.println("\nThat is not a valid choice. Try again.");
            }

            scanner.nextLine();

            System.out.println("\n1. List Pokemon");
            System.out.println("2. Add Pokemon");
            System.out.println("3. Check a Pokemon's Stats");
            System.out.println("4. Evolve a Pokemon");
            System.out.println("5. Sort Pokemon");
            System.out.println("6. Exit");
            System.out.println("\nWhat would you like to do? ");
        }
        return userChoice;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Boolean runAgain = true;
        int choice = 1;
        int userInput;
        Pokedex pokedex;

        //Take the number of Pokemon in the region from the user
        System.out.println("Welcome to your new PokeDex!");
        userInput = checkNumInRegion();
        pokedex = new Pokedex(userInput);
        System.out.println("\nYour new Pokedex can hold " + userInput + " Pokemon. Let's start using it!");

        while (runAgain)
        {
            /*
             *  Go to the printOptionsAndCatchErrors method to get the user's choice
             *  Carry out the choice that the user selects
             */

            choice = printOptionsAndCatchErrors();

            //What to do based on user's choice
            if (choice == 1)
            {
                //List Pokemon
                String[] names = pokedex.listPokemon();
                for(int index = 0; index < names.length; index++)
                {
                    if (names[index] == null)
                        break;

                    System.out.println((index + 1) + ". " + names[index]);
                }
            }
            else if (choice == 2)
            {
                //Add a Pokemon
                System.out.print("\nPlease enter the Pokemon's Species: ");
                String input = scanner.nextLine();

                pokedex.addPokemon(input);
            }
            else if (choice == 3)
            {
                //Check a Pokemon's Stats
                int[] stats = new int[3];

                System.out.print("\nPlease enter the Pokemon of interest: ");
                String input = scanner.nextLine();

                stats = pokedex.checkStats(input);

                if((stats[0] != -1) && (stats[1] != -1) && (stats[2] != -1))
                {
                    System.out.println("\nThe stats for " + input + " are:");
                    System.out.println("Attack: " + stats[0]);
                    System.out.println("Defense: " + stats[1]);
                    System.out.println("Speed: " + stats[2]);
                }
                else
                    System.out.println("Missing");
            }
            else if (choice == 4)
            {
                //Evolve a Pokemon
                System.out.print("\nPlease enter the Pokemon of interest: ");
                String input = scanner.nextLine();

                if (pokedex.evolvePokemon(input))
                    System.out.println(input + " has evolved!");
                else
                    System.out.println("Missing");
            }
            else if (choice == 5)
            {
                //Sort the Pokemon
                pokedex.sortPokedex();
            }
            else if (choice == 6)
            {
                //Exit game
                runAgain = false;
            }
        }


        return;
    }
}
