package exercise1;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * A class that fills a hand of 7 cards with random Card Objects and then asks the user to pick a card.
 * It then searches the array of cards for the match to the user's card. 
 * To be used as starting code in Exercise
 *
 * @author dancye
 * @author Paul Bonenfant Jan 25, 2022 
 */
public class CardTrick {
    
    public static void main(String[] args) {
        
        Card[] hand = new Card[7];

        for (int i = 0; i < hand.length; i++) {
            Card card = new Card();
            //card.setValue(insert call to random number generator here)
            card.setValue((int)(Math.random() * 13 + 1));
            //card.setSuit(Card.SUITS[insert call to random number between 0-3 here])
            card.setSuit(Card.SUITS[(int)(Math.random() * 3)]);
            // Hint: You can use Random -> random.nextInt(n) to get a random number between 0 and n-1 (inclusive)
            hand[i] = card;
            System.out.println(card.getValue() + " " + card.getSuit());
        }

        // insert code to ask the user for Card value and suit, create their card
        Scanner keyboard = new Scanner(System.in);
        int userValue = 0;
        int userSuit = 0;
        while(true){
            System.out.println("Enter a card value 1-10, 11-13 is Jack, Queen, King. Out of range numbers default to 1");
            try{
                userValue = keyboard.nextInt();
                if(userValue < 1 || userValue > 13){
                    userValue = 1;
                }
                System.out.println("Enter a suit. 0 for hearts, 1 for diamonds, 2 for spades, 3 for clubs. Out of range numbers default to 0");
                userSuit = keyboard.nextInt();
                if(userSuit < 0 || userSuit > 3){
                    userSuit = 0;
                }
            }
            catch(InputMismatchException exception){
                System.out.println("Invalid entry. Try again.");
                keyboard.next();
            }
            Card userCard = new Card();
            userCard.setValue(userValue);
            userCard.setSuit(Card.SUITS[userSuit]);
            for(int j = 0; j < hand.length; j++){
                if(userCard.getValue() == hand[j].getValue() && userCard.getSuit().equals(hand[j].getSuit())){
                    printInfo();
                    System.exit(0);
                }
            }
            System.out.println("Your card was not found in the hand!");
        }
            
        
        // and search the hand here. 
        // Hint: You can ask for values 1 to 10, and then
        //       11 for jack, 12 for queen, etc. (remember arrays are 0-based though)
        //       1 for Hearts, 2 for Diamonds, etc. (remember arrays are 0-based though)
        // 
        // Then loop through the cards in the array to see if there's a match.
        
        // If the guess is successful, invoke the printInfo() method below.
        
    }

    /**
     * A simple method to print out personal information. Follow the instructions to 
     * replace this information with your own.
     * @author Paul Bonenfant Jan 2022
     */
    private static void printInfo() {
    
        System.out.println("Congratulations");
        System.out.println();
        
        System.out.println("Some default stuff");
        System.out.println();
        
        System.out.println("My career ambitions:");
        System.out.println("-- Sit around");
        System.out.println("-- Do nothing");
	System.out.println();	

        System.out.println("My hobbies:");
        System.out.println("-- Stuff");
        System.out.println("-- Running");
        System.out.println("-- Blank");
        System.out.println("-- Riding my lawnmower");

        System.out.println();
        
    
    }

}
