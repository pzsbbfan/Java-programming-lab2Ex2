import javax.swing.*;
import java.util.Random;

public class Lotto {
    private int[] randomInt;

    //constructor to populate an array for Lotto
    public Lotto(){
        Random random = new Random();
        randomInt = new int[3];
        for (int i =0; i<3;i++){
            randomInt[i] = random.nextInt(1,10);
        }
    }
    public int[] newLottoNumber(){
        Random random = new Random();
        randomInt = new int[3];
        for (int i =0; i<3;i++){
            randomInt[i] = random.nextInt(1,10);
        }
        return randomInt;
    }

    // get user input and validate input type and values
    public int userInput() {
        boolean inputInt = true;
        int userGuess = 0;
        while (inputInt) {
            try {
                userGuess = Integer.parseInt(JOptionPane.showInputDialog("Please choose a number between 3 to 27"));
                if (userGuess < 3 || userGuess > 27) {
                    JOptionPane.showMessageDialog(null, "number can not be less than 3 or greater than 27!");
                    inputInt = true;
                } else {
                    inputInt = false;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please Enter A integer number between 3~27!");
                inputInt = true;
            }
        }
        return userGuess;
    }

    //check user input to see if it matches the jackpot
    public boolean checkAnswer(){
        int userGuess = userInput();
        int winNumber = 0;
        boolean win = false;



        //loop 5 times
        for (int i =0; i<5;i++){
            // get the winning number from adding all elements in the array
            for (int j=0;j<randomInt.length;j++) {
                winNumber += randomInt[j];
            }
            //win condition
            if (userGuess == winNumber) {
                win = true;
                break;
            }
            else
            {
                for (int num:randomInt)
                {
                    System.out.println("Elements in array: " + num);
                }
                System.out.println("your input:" + userGuess + " win number: " + winNumber);

                //populate another instance of lotto array
                newLottoNumber();
                winNumber = 0;
            }



        }

        return win;

    }
    public void displayMessage(){
        // display message to user
        if (checkAnswer()){
            JOptionPane.showMessageDialog(null,"Winner! Congratulations!");
        }
        else {JOptionPane.showMessageDialog(null,"Computer win! Better luck next time!");}
    }
    public void startLotto(){
        displayMessage();
    }
}
