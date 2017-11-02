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
        System.out.println("\nWhat would you like to do? ");


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
            System.out.println("\nWhat would you like to do? ");
        }
        return userChoice;

    }

    public static main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Boolean runAgain = true;
        int choice = 1;
        String userInput;



        //Take the number of Pokemon in the area from the user
        System.out.println("Welcome to your new PokeDex!");
        System.out.println("How many Pokemon are in your region: ");
        userInput = scanner.nextLine();
        //need to check this input


        while (runAgain)
        {
            /**
             *  Get text from user
             *  Go to the printOptionsAndCatchErrors method to get the user's choice
             *  Carry out the choice that the user selects
             **/

            choice = printOptionsAndCatchErrors();

            //What to do based on user's choice
            if (choice == 1)
            {
                //
            }
            else if (choice == 2)
            {
                //
            }
            else if (choice == 3)
            {
                //
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
