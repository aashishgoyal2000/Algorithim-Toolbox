import java.util.Scanner;
import java.lang.Math;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
      int length = exp.length();
      int operands = (length + 1)/2;
      long[][] minArray = new long[operands][operands]; 
      long[][] maxArray = new long[operands][operands]; 
      for (int i = 0; i < operands; i++) {
          for (int j = 0; j < operands; j++) {
              minArray[i][j] = 0;
              maxArray[i][j] = 0;
          }
      }
      for (int i = 0; i < operands; i++) {
          minArray[i][i] = Integer.parseInt(exp.charAt( 2 * i) + "");
          maxArray[i][i] = Integer.parseInt(exp.charAt( 2 * i) + "");
      }
      for (int s = 0; s < operands - 1; s++) {
          for (int i = 0; i < operands - s - 1; i++) {
              int j = i + s + 1;
              long minn = Integer.MAX_VALUE, maxx = Integer.MIN_VALUE;
              for (int k = i; k < j; k++) {
                  long a = eval(minArray[i][k], minArray[k + 1][j], exp.charAt(2 * k + 1));
                  long b = eval(minArray[i][k], maxArray[k + 1][j], exp.charAt(2 * k + 1));
                  long c = eval(maxArray[i][k], minArray[k + 1][j], exp.charAt(2 * k + 1));
                  long d = eval(maxArray[i][k], maxArray[k + 1][j], exp.charAt(2 * k + 1));
                  minn = Math.min(minn, Math.min(a, Math.min(b, Math.min(c, d))));
                  maxx = Math.max(maxx, Math.max(a, Math.max(b, Math.max(c, d))));
              }
              minArray[i][j] = minn;
              maxArray[i][j] = maxx;
          }
      }
      return maxArray[0][operands - 1];
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            System.out.println("Wrong Operator");
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

