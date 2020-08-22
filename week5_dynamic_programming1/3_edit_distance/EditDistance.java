import java.util.*;
import java.lang.Math;

class EditDistance {
  public static int EditDistance(String s, String t) {
    int[][] arr = new int[s.length() + 1][t.length() + 1];
    for (int i = 0; i <= s.length(); i++) {
      arr[i][0] = i;
    }
    for (int i = 0; i <= t.length(); i++) {
      arr[0][i] = i;
    }

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 1; j <= t.length(); j++) {
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
          arr[i][j] = arr[i - 1][j - 1];
        } else {
          arr[i][j] = Math.min(arr[i - 1][j], Math.min(arr[i][j - 1], arr[i - 1][j - 1])) + 1;
        }
      }
    }

    return arr[s.length()][t.length()];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
