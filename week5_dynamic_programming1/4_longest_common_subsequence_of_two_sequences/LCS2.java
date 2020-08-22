import java.util.*;

public class LCS2 {

    private static int lcs2(int[] s, int[] t) {
        int[][] arr = new int[s.length + 1][t.length + 1];
        for (int i = 0; i <= s.length; i++) {
          arr[i][0] = 0;
        }
        for (int i = 0; i <= t.length; i++) {
          arr[0][i] = 0;
        }

        for (int i = 1; i <= s.length; i++) {
          for (int j = 1; j <= t.length; j++) {
            if (s[i - 1] == t[j - 1]) {
              arr[i][j] = arr[i - 1][j - 1] + 1;
            } else {
              arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
            }
          }
        }
        return arr[s.length][t.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

