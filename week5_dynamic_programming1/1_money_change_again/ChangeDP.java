import java.util.Scanner;
import java.lang.Math;

public class ChangeDP {
    private static int getChange(int m) {
    	// 1 3 4
    	// for 4
    	int[] coins = new int[3];
    	coins[0] = 4;
    	coins[1] = 3;
    	coins[2] = 1;
    	int[] arr = new int[m + 1];
    	arr[0] = 0;
    	for (int i = 1; i < arr.length; i++) {
    		arr[i] = m;
    		for (int j = 0; j < coins.length - 1; j++) {
    			if (coins[j] <= i) {
    				// System.out.println(i + " " + coins[j]);
    				int minCoins = arr[i - coins[j]] + 1;
    				if (minCoins < arr[i]) {
    					arr[i] = minCoins;
    				}
    			}
    		}
     	}
        return arr[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] arr = new int[m + 2];
        for (int i = 0; i < m + 2; i++) {
        	arr[i] = -1;
        }
        System.out.println(getChange(m));

    }
}

