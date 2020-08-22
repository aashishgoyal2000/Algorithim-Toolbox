import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int numberofcoins = 0;
        numberofcoins += m / 10;
        m = m % 10;
        numberofcoins += m / 5;
        m = m % 5;
        numberofcoins += m / 1;
        // m = m % 10;
        return numberofcoins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

