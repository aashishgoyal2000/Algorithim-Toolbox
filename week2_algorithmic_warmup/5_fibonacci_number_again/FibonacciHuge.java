import java.util.*;

public class FibonacciHuge {

    private static long calc_fib(long n) {

        if (n <= 1) {
          return n;
        }
        
        return calc_fib(n - 1) + calc_fib(n - 2);
        // return arr[n];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        long period = findPatternLength(m);

        System.out.println(period);
        System.out.println(calc_fib(n));
    }

    private static long findPatternLength(long m) {
        ArrayList<Long> pattern = new ArrayList();

        long first = 0;
        long second = 1;
        
        pattern.add((first%m));
        pattern.add((second%m));
        
        int checking = 2;
        long period = (long)0;
        
        while(true) {
            long fib = first + second;
            first = second;
            second = fib;
            long mod = (fib%m);
            pattern.add(mod);
            if (pattern.get(checking) == (long)1 && pattern.get(checking - 1) == (long)0) {
                period =  pattern.size() - 2;
                break;
            }
            checking++;
        }
        
        return period;
    }
}


// ag3204501@gmail.com
// goalaashish06@gmail.com
// ag@420420
// Algoexpert Full course -
// Link — https://mega.nz/folder/KqYiVCYL
// Decryption key — -thljhUTx_p367nRNOruYg
// Algoexpert Solutions -
// Link — https://mega.nz/file/i2oHFLgZ
// Decryption key — jSrh_0k-aHr_3Q79MzHzn1Z7pj_H_tHTK6fKcNhhLdQ
// GRE Materials -
// Link — https://mega.nz/folder/OmIiDKpT
// Decryption Key — FS1wRw3dpbkslXr251LLYw
// GFG DSA -
// Link — https://mega.nz/folder/lihzlQiJ
// Decryption Key — v-ZMWiuLkx0gx4ZjpTN43Q
// GFG Core CS -
// Link — https://mega.nz/folder/Eu4HjYgD
// Decryption Key — uwU9dNHdVXvwxhWRPm8h8w
// GFG Placement 100 -
// Link — https://mega.nz/folder/GUhHyaxC
// Decryption Key — cRURq6Dqd-vK2zHePZX97A
// GFG Amazon SDE -
// Link — https://mega.nz/folder/pp9QUa6B
// Decryption Key — Gjlg0ywNSb_N38hWMOdLSA
// GFG C++ STL -
// Link — https://mega.nz/folder/HTJTBYhJ
// Decryption Key — 1eNJwAXXSO9KvWucE5H1Mw
// Coding Ninjas Competitive Programming -
// Link — https://mega.nz/folder/uKQhCCRZ
// Decryption Key — J9DVX1u_serZrWv0JwX-MA
// 
// https://mega.nz/folder/rE9hTaRB#RIhE5RBKxtKM4o8ZvucVTw
// https://drive.google.com/folderview?id=1Tk_-NOXDJ2xuKefQ-r0TiwSvYz0ejKgd
