import java.util.Scanner;

class FibonacciNumberAgain {

	static long get_pisano_period(long m) {
	    long a = 0, b = 1, c = a + b;
	    for (int i = 0; i < m * m; i++) {
	        c = (a + b) % m;
	        a = b;
	        b = c;
	        if (a == 0 && b == 1) return i + 1;
	    }
	    return 0;
	}

	static long get_fibonacci_huge(long n, long m) {
	    long remainder = n % get_pisano_period(m);

	    long first = 0;
	    long second = 1;

	    long res = remainder;

	    for (int i = 1; i < remainder; i++) {
	        res = (first + second) % m;
	        first = second;
	        second = res;
	    }

	    return res % m;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long m = sc.nextLong();
		
		long period = get_pisano_period(m);
		
		n = n%period;
		long[] arr = new long[(int)n + 1];
	    
	    for (int i = 0; i < n + 1; i++) {
	      arr[i] = -1;
	    }
		
		System.out.println(get_fibonacci_huge(n, m));
	}
}