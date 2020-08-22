import java.util.*;

public class FibonacciLastDigit {
    // private static int getFibonacciLastDigitNaive(int n) {
    //     if (n <= 1)
    //         return n;

    //     int previous = 0;
    //     int current  = 1;

    //     for (int i = 0; i < n - 1; ++i) {
    //         int tmp_previous = previous;
    //         previous = current;
    //         current = tmp_previous + current;
    //     }

    //     return current % 10;
    // }

    private static long calc_fib(int n, long[] arr) {
        if (arr[n] != -1) {
          return arr[n]%10;
        }
        if (n <= 1) {
          return n;
        }
        arr[n] = calc_fib(n - 1, arr) + calc_fib(n - 2, arr);
        return arr[n]%10;
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        long[] arr = new long[n + 1];
        for (int i = 0; i < n + 1; i++) {
          arr[i] = -1;
        }

        long c = calc_fib(n%60,arr);
        // int d = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}

