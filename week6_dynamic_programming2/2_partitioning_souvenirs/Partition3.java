import java.util.*;
import java.io.*;

public class Partition3 {
    public static boolean partition(List<Integer> ar, int[] target, int trgIdx) {
        Collections.sort(ar);
        String key = ar.toString() + "|" + Arrays.toString(target);
        // Boolean possible = mem.get(key);
        // if (possible != null) {
        //     return possible;
        // }
        
        for (int k = trgIdx; k < target.length; k++) {
            for (int idx = ar.size()-1; idx >= 0 && target[k] > 0; idx--) {                
                if (target[k] >= ar.get(idx)) { // make sure not to go negative on target
                    Integer value = ar.remove(idx); 
                    target[k] -= value; 
                    
                    if (partition(ar, target, k)) {
                        // p.get(k).add(value);           
                    } else {
                        ar.add(value);
                        target[k] += value; 
                    }
                }
            }
            if (target[k] != 0) {
                // mem.put(key, false);
                return false;
            }
        }       
        // mem.put(key, ar.isEmpty());   
        return ar.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        ArrayList<Integer> ar = new ArrayList();
        for (int i = 0; i < n; i++) {
            ar.add(scanner.nextInt());
        }
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += ar.get(i);
        }
        if (sum%3 != 0) {
            System.out.println(0);
            return;
        }
        int[] target = new int[3];
        for (int i = 0; i < 3; i++) {
            target[i] = sum / 3;
            // System.out.println(target[i]);
        }
        if (partition(ar, target, 0)) {
            System.out.println("1");    
        }
        else
            System.out.println("0");
    }
}

