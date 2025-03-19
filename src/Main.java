import java.util.concurrent.ThreadLocalRandom;

public class Main {

    static Integer myNumber = ThreadLocalRandom.current().nextInt(0, 100 + 1);

    public static void main(String[] args) {
        guess(41);
        guess(42);
    }

    public static void guess(Integer number)  {
        if(number == myNumber) {
            System.out.println("Guessed right!");
        } else {
            System.out.println("Guessed false!");
        }
    }

}