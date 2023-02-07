import java.text.ParseException;
import java.util.Scanner;

/**
 * @author SK
 * @date 07/02/2022 11:54 am
 */

public class GuessNumberGame{
    public static void main(String[] args) throws ParseException{
        GuessNumberGame numberGame = new GuessNumberGame();
        numberGame.welcomeNInfo();
        numberGame.takeUserConsentToProceed();
    }

    /**
     * method that provides instruction about the game 
     */
    public void welcomeNInfo(){
        System.out.println("===============================================================================================================================");
        System.out.println("Welcome! Welcome to the number game!");
        System.out.println("Rules for this game is fairly simple. All you have to do is think of a number, keep it to your self and the game will try to guess it!");
        System.out.println("===============================================================================================================================");
    }

    /**
     * method to take user consent
     * @throws ParseException
     */
    public void takeUserConsentToProceed() throws ParseException{
        System.out.println("Enter Y to start the game or N to terminate");
        userInputForYesOrNo();
    }

    /**
     * main game function that does the actual gaming 
     * @throws ParseException
     */
    public final static void mainGameFunction() throws ParseException{
                Scanner scanner = new Scanner(System.in);
                System.out.println("* Think of a number in your head and keep it to yourself!");
                System.out.println("Done so? Press Y for yes");
                char userInput = scanner.next().charAt(0);
                if(userInput == 'Y' || userInput == 'y'){
                    System.out.println("* Now add 5 to that number and multiply it by 8.");
                    System.out.println("* Then divide it by 2");
                    System.out.println("* Now tell us what you got by entering the resulted number- ");
                    float resultedNumber =  scanner.nextFloat();
                    System.out.println("The original number you thought of is => " + ((2*resultedNumber) - 40)/8);
                    thankYouRetry();
                    scanner.close();
                }
    }
    
    /**
     * method to get user input to progress or to terminate
     * @throws ParseException
     */
    public static void userInputForYesOrNo() throws ParseException{
        Scanner scan = new Scanner(System.in);
        char userInput = scan.next().charAt(0);
        if(userInput == 'Y' || userInput == 'y'){
            GuessNumberGame.mainGameFunction();
        }else if(userInput == 'N' || userInput == 'n'){
            System.out.println("We are sorry to see you go. Feel free to come back again!");
            System.exit(0);
        }else{
            unrecognisedInput();
        }
        scan.close();
    }

    /**
     * @throws ParseException
     * method for conclusion
     */
    public static void thankYouRetry() throws ParseException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let us know if its correct by pressing Y for yes or N for no");
        char userFlagInput = scanner.next().charAt(0);
        if(userFlagInput == 'Y' || userFlagInput == 'y'){
            System.out.println("Thank you for playing this game with us!");
            System.out.println("Would you like to try again? (yes/no)");
            char userInputForContinueOrNot = scanner.next().charAt(0);
            if(userInputForContinueOrNot == 'Y' || userInputForContinueOrNot == 'y'){
                GuessNumberGame.mainGameFunction();
            }else if(userInputForContinueOrNot == 'N' || userInputForContinueOrNot == 'n'){ 
                System.out.println("Thank you for playing this game! Feel free to come back again!");
                System.exit(0);
            }else {
                unrecognisedInput();
            }
        }else if(userFlagInput == 'N' || userFlagInput == 'n'){
            System.out.println("Oh! we are sorry to hear that! Wanna try again? Press Y to play again and N to exit");
            userInputForYesOrNo();
        }else{
                unrecognisedInput();
        }
        scanner.close();
    }

    /**
     *  method to handle unrecognised input
     * @throws ParseException
     */
    public static void unrecognisedInput() throws ParseException{ 
        System.out.println("Sorry we didn't recognise the input you entered. Please enter Y for yes or N to exit.");
        userInputForYesOrNo();
    }
}