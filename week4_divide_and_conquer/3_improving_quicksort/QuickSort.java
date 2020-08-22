import java.io.*;
import java.util.*;

class QuickSort {

	static void randomizedQuickSort(int[] arr, int low, int high) {
		if (high < low) {
			return;
		}
		int pivot = tellMyPivot(arr, low, high);
		randomizedQuickSort(arr, low, pivot - 1);
		randomizedQuickSort(arr, pivot + 1, high);
	}

	static int tellMyPivot(int[] arr, int low, int high) {
		int pivot = arr[low];
		int j = low;
		for (int i = low + 1; i <= high; i++) {
			if (arr[i] < pivot) {
				j++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[j];
		arr[j] = arr[low];
		arr[low] = temp;
		return j;
	}

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}