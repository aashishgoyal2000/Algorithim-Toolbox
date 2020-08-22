import java.util.*;

public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current * current;
        }

        return sum % 10;
    }
    private static long calc_fib(int n, long[] arr) {
        if (arr[n] != -1) {
          return (arr[n])%10;
        }
        if (n <= 1) {
          return n;
        }
        arr[n] = (calc_fib(n - 1, arr)%10 + calc_fib(n - 2, arr)%10)%10;
        return (arr[n])%10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int inp = (int)(n%60);

        long[] arr = new long[inp + 2];
        for (int i = 0; i < inp + 2; i++) {
          arr[i] = -1;
        }
        
        long s = calc_fib(inp, arr)%10;
        long p = calc_fib(inp + 1, arr)%10;
        
        long out = (s*p)%10;
        System.out.println(out);
    }
}

