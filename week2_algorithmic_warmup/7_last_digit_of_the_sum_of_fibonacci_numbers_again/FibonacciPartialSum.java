import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }
    // private static long calc_fib(long n) {
    //     if (n <= 1) {
    //       return n;
    //     }
    //     return (calc_fib(n - 1)%10 + calc_fib(n - 2)%10)%10;
        
    // }
    private static long calc_fib(int n, long[] arr) {
        if (arr[n] != -1) {
          return arr[n]%10;
        }
        if (n <= 1) {
          return n;
        }
        arr[n] = (calc_fib(n - 1, arr)%10 + calc_fib(n - 2, arr)%10)%10;
        return arr[n]%10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();

        int n = (int)(to%60);
        int m = (int)(from % 60);
        long sum = 0;

        int big = (m + 2) > (n + 3) ? (m + 2) : (n + 3);
        long[] arr = new long[big];
        for (int i = 0; i < big; i++) {
          arr[i] = -1;
        }

        long a1 = calc_fib((n + 2), arr) - 1;
        long a2 = calc_fib(m + 1, arr) - 1;
        System.out.println((a1%10 - a2%10 + 10)%10);

    }
}

