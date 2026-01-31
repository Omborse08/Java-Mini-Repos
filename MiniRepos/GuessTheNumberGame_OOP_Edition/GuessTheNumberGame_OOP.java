import java.util.Random;
import java.util.Scanner;

class Guessed {
    private int number;
    private int ran;
    private int count = 0;

    public Guessed() {
        Random random = new Random();
        ran = random.nextInt(5);
    }

    public void setNOG() {
        count++;
    }

    public int getNOG() {
        return count;
    }

    public void setNumber(int a) {
        this.number = a;
    }

    public boolean isCorrcetNumber() {
        if (this.number==ran) {
            System.out.println("Win");
            System.out.print("Total Guess: ");
            System.out.print(getNOG());
            return true;
        } else if (this.number>ran) {
            System.out.println("Too High!");
        }
        else {
            System.out.println("Too Low!");
        }
        return false;
    }
}
public class GuessTheNumberGame_OOP {
    public static void main(String[] args) {
        Guessed gs = new Guessed();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("\nEnter Number: ");
            int num = sc.nextInt();
            gs.setNumber(num);
            gs.setNOG();
            if (gs.isCorrcetNumber()) {
                break;
            }
        }
    }
}
