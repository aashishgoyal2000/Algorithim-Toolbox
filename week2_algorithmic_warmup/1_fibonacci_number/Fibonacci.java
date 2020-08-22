import java.util.Scanner;

public class Fibonacci {

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

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    
    long[] arr = new long[n + 1];
    for (int i = 0; i < n + 1; i++) {
      arr[i] = -1;
    }

    System.out.println(calc_fib(n, arr));
  }
}
  