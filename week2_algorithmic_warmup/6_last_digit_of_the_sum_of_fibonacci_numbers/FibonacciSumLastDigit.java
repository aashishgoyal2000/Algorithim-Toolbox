import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous%10;
            previous = current%10;
            current = (tmp_previous + current)%10;
            sum += current;
            sum = sum % 10;
            // System.out.println(current + " " + sum);
        }

        return sum % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        // long s = getFibonacciSumNaive(n);
        long mod = getFibonacciSumNaive(n%60);
        System.out.println(mod);
    }
}

