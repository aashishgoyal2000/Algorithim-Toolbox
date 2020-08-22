import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    return (long) a * b;
  }
  private static long gcd_naive(int a, int b) {
    if (b == 0) {
      return a;
    }
    return (long)gcd_naive(b,a%b);
  }


  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    // int a = 714552;
    // int b = 371453;
    long product = lcm_naive(a, b);
    // int c = 170777928;
    long gcd = gcd_naive(a,b);
    long out = (long) product/gcd;
    System.out.println(out);
  }
}
