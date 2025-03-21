import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    static Integer myNumber = ThreadLocalRandom.current().nextInt(0, 100 + 1);
    static Integer tries = 0;
    static JLabel text = new JLabel("Enter a number between 0 and 100");


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

        text.setBounds(50, 50, 350, 30);

        JTextField textField = new JTextField();
        textField.setBounds(50, 100, 200, 30);

        JButton button = new JButton("Guess!");
        button.setBounds(50, 150, 200, 30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textFromTextfield = textField.getText();
                Integer number = Integer.parseInt(textFromTextfield);
                guess(number);
            }
        });

        frame.add(text);
        frame.add(textField);
        frame.add(button);
        frame.setLayout(null);
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

            text.setText("Guess correctly with" + tries + " attempts");

        } else {

            if(number < myNumber) {
                text.setText("Guessed false! Your Number is to small!");
            } else {
                text.setText("Guessed false! Your Number is to big!");
            }
            //nextRound();
        }
    }

}