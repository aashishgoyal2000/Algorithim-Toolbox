import java.util.*;

public class Inversions {

    public static int conquerer(int[] arr, int start, int mid, int end) {
        // System.out.println();
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] left = new int[n1];
        int[] right = new int[n2 + 1];
        int k = 0;  
        for (int i = start; i <= mid; i++) {
            left[k] = arr[i];
            k++;
        }
        k = 0;
        for (int i = mid + 1; i <= end; i++) {
            right[k] = arr[i];
            k++;
        }
        int i = 0;
        int j = 0;
        int inversion = 0;
        k = start;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                inversion += n1 - i;
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while ( i < n1 ) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while(j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }

        return inversion;
    }


    private static long getNumberOfInversions(int[] arr, int start, int end) {
        long numberOfInversions = 0;
        if (end <= start) {
            return numberOfInversions;
        }
        int mid = start + (end - start) / 2;
        numberOfInversions += getNumberOfInversions(arr, start, mid);
        numberOfInversions += getNumberOfInversions(arr, mid + 1, end);
        
        numberOfInversions += conquerer(arr, start, mid, end);

        return numberOfInversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, 0, a.length - 1));
    }
}

