import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    // Zufällige Zahl zwischen 0 und 100 generieren
    static Integer myNumber = ThreadLocalRandom.current().nextInt(0, 100 + 1);
    static Integer tries = 0;
    static JLabel text = new JLabel("Enter a number between 0 and 100");
    static JTextField textField = new JTextField();


    public static void main(String[] args) {
        openUI();
        // nextRound();
    }

    // Erstellt die GUI
    public static void openUI(){
        JFrame frame = new JFrame("Guess the Number");
        frame.setSize(400,300);
        frame.setLocation(100,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);

        text.setBounds(50, 50, 350, 30);

        textField.setBounds(50, 100, 200, 30);

        JButton button = new JButton("Guess!");
        button.setBounds(50, 150, 200, 30);


        // Ereignis: Wenn der Button geklickt wird
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent error) {
                try {
                    String textFromTextfield = textField.getText();
                    Integer number = Integer.parseInt(textFromTextfield);
                    guess(number);
                } catch (Exception e){
                    text.setText("Please enter a number!");
                }
            }
        });


        // Komponenten zum Fenster hinzufügen
        frame.add(text);
        frame.add(textField);
        frame.add(button);
        frame.setLayout(null);
        frame.setVisible(true);
    }


    // Überprüft den gerateten Wert
    public static void guess(Integer number)  {
        if(number == myNumber) {
            System.out.println("Guessed right!");
            System.out.println("It took you " + tries + " tries!");

            text.setText("Guess correctly with " + tries + " attempts");

        } else {
            tries++;
            if(number < myNumber) {
                text.setText("Guessed false! Your Number is to small!");
            } else {
                text.setText("Guessed false! Your Number is to big!");
            }
            textField.setText("");
        }
    }
}