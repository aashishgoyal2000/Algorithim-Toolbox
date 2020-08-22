import java.util.*;

public class LCS3 {

    private static int lcs3(int[] s, int[] t, int[] c) {
        int[][][] arr = new int[s.length + 1][t.length + 1][c.length + 1];
        for (int i = 0; i <= s.length; i++) {
          arr[i][0][0] = 0;
        }
        for (int i = 0; i <= t.length; i++) {
          arr[0][i][0] = 0;
        }
        for (int i = 0; i <= c.length; i++) {
          arr[0][0][i] = 0;
        }        

        for (int i = 1; i <= s.length; i++) {
          for (int j = 1; j <= t.length; j++) {
            for (int k = 1; k <= c.length; k++) {
                if (s[i - 1] == t[j - 1] && t[j - 1] == c[k - 1]) {
                  arr[i][j][k] = arr[i - 1][j - 1][k - 1] + 1;
                } else {
                  arr[i][j][k] = Math.max(arr[i - 1][j][k], Math.max(arr[i][j][k - 1] , arr[i][j - 1][k]));
                }
            }
          }
        }
        return arr[s.length][t.length][c.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

