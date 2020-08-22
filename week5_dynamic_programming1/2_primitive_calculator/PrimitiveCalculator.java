import java.util.*;

public class PrimitiveCalculator {

    static class Path {
        int n;
        int freq = 0;
        String path = "";
        Path(int h) {
            n = h;
            freq = 0;
            path = "";
        }
    }

    private static String dpSol(int n) {
        Path[] pp = new Path[n + 1];
        for (int i = 0; i < n + 1; i++) {
            pp[i] = new Path(i);
            // pp[i].n = i;
        }
        pp[0].freq = 0;
        pp[1].freq = 0;
        pp[1].path = "1 ";

        for (int i = 2; i <= n; i++) {
            int a = -1, b = -1, c = -1;
            if (i%2 == 0) {
                a = pp[i/2].freq + 1;
            }
            if (i%3 == 0) {
                b = pp[i/3].freq + 1;
            }
            c = pp[i - 1].freq + 1;
            if(a<b && a!=-1){
                if(a<c){
                    pp[i].freq = a;
                    pp[i].path += pp[i/2].path + " " + pp[i].n + " ";
                } else {
                    pp[i].freq = c;
                    pp[i].path += pp[i - 1].path + " " + pp[i].n + " ";
                }
            } else if(b<c && b!=-1){
                pp[i].freq = b;
                pp[i].path += pp[i/3].path + " " + pp[i].n + " ";
            } else {
                if(a<c && a != -1){
                    pp[i].freq = a;
                    pp[i].path += pp[i/2].path + " " + pp[i].n + " ";
                } else {
                    pp[i].freq = c;
                    pp[i].path += pp[i - 1].path + " " + pp[i].n + " ";
                }
            }
        }
        return pp[n].freq + "\n" + pp[n].path;
    }

    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        // for (int i = 1; i < 10; i++) {
        //     int n = (int)(Math.random() * 1000000 + 1);     
        //     List<Integer> sequence = optimal_sequence(n);
        //     System.out.println( "Greedy Solution" + (sequence.size() - 1));
        //     for (Integer x : sequence) {
        //         System.out.print(x + " ");
        //     }
        //     System.out.println("\nDynamic Solution" + dpSol(n));
        //     System.out.println("\n");
        // }
        System.out.println(dpSol(n));
    }
}

