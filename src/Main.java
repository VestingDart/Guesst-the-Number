import javax.swing.*;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    static Integer myNumber = ThreadLocalRandom.current().nextInt(0, 100 + 1);
    static Integer tries = 0;
    public static void main(String[] args) {
        openUI();
        // nextRound();
    }

    public static void openUI(){
        JFrame frame = new JFrame("Guess the Number");
        frame.setSize(400,300);
        frame.setLocation(100,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);

        JLabel text = new JLabel("Enter a number between 0 and 100");
        text.setBounds(50, 50, 200, 30);

        frame.add(text);
        frame.setVisible(true);
    }

    public static void nextRound() {
        tries = tries + 1; //or tries++;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        Integer number = scanner.nextInt();
        guess(number);
    }

    public static void guess(Integer number)  {
        if(number == myNumber) {
            System.out.println("Guessed right!");
            System.out.println("It took you " + tries + " tries!");
        } else {
            System.out.println("Guessed false!");

            if(number < myNumber) {
                System.out.println("Your Number is to small!");
            } else {
                System.out.println("Your Number is to big!");
            }
            nextRound();
        }
    }

}