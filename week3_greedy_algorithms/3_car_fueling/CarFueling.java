import java.util.*;
import java.io.*;

public class CarFueling {
    static long computeMinRefills(long dist, long tank, long[] stops) {
        if (tank >= dist) {
            return 0;
        }
        long countFuels = 0;
        int currentFuel = 0;
        // long distanceTravelled = 0;
        
        while (currentFuel < stops.length - 1) {
            int lastFuel = currentFuel;
            // System.out.println(stops[currentFuel] + " " + countFuels);
            while (currentFuel + 1 < stops.length && stops[currentFuel + 1] - stops[lastFuel] <= tank) {
                currentFuel++;
            }
            if (currentFuel == lastFuel) {
                return -1;
            }
            if (currentFuel < stops.length) {
                countFuels++;
            }
        }

        return countFuels - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long dist = scanner.nextLong();
        long tank = scanner.nextLong();
        int n = scanner.nextInt();
        long stops[] = new long[n + 2];
        stops[0] = 0;
        for (int i = 1; i <= n ; i++) {
            stops[i] = scanner.nextLong();
        }
        stops[n + 1] = dist;
        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
