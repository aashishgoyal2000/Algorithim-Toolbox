import java.util.*;

public class PointsAndSegments {
    
    private static class Segment {
        int x;
        int y;

        public Segment(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[" + x +
                    ", " + y +
                    ']';
        }
    }

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        TreeSet<Segment> pointsSortedByX = new TreeSet<>(new OrderX());
        for (int i = 0; i < starts.length; i++) {
            pointsSortedByX.add(new Segment(starts[i], ends[i]));
        }
        for (int i = 0; i < points.length; i++) {
            TreeSet<Segment> pointsSortedByY = new TreeSet<>(new OrderY());
            Segment search = new Segment(points[i], points[i]);
            pointsSortedByY.addAll(pointsSortedByX.headSet(search, true));
            cnt[i] = pointsSortedByY.tailSet(search, true).size();
        }
        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }
    
    private static class OrderX implements Comparator<Segment> {
        public int compare(Segment p, Segment q) {
            return Integer.compare(p.x, q.x);
        }
    }

    private static class OrderY implements Comparator<Segment> {
        public int compare(Segment p, Segment q) {
            return Integer.compare(p.y, q.y);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        // int[] cnt = naiveCountSegments(starts, ends, points);
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
} 
// import java.util.Scanner;
// import java.util.*;

// public class PointsAndSegments {
//     static class Segments {
//         int start;
//         int end;
//         Segments(int a, int b) {
//             this.start = a;
//             this.end = b;
//         }
//     }
//     public static int searchByX(Segments[] segments, int left, int right, int point) {
//         int pos = -1;
//         while (left <= right) {
//             if (left == right) {
//                 Segments p = segments[left];
//                 if (p.start <= point) {
//                     pos = left;
//                 }
//                 break;
//             }
//             int mid = left + (right - left) / 2;
//             Segments p = segments[mid];
//             if (p.start <= point) {
//                 pos = mid;
//                 left = mid + 1;
//             } else if (p.start > point) {
//                 right = mid;
//             }
//         }
//         return pos;
//     }
//     public static int binarySearch(Segments a[], int item, int low, int high) { 
//         if (high <= low) 
//             return (item > a[low].start)?  (low + 1): low; 
//         int mid = (low + high)/2; 
//         if(item == a[mid].start) 
//             return mid+1;       
//         if(item > a[mid].start) 
//             return binarySearch(a, item, mid+1, high); 
//         return binarySearch(a, item, low, mid-1); 
//     }
//     private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
//         int[] cnt = new int[points.length];
//         Segments[] sg = new Segments[starts.length];
//         for (int i = 0; i < starts.length; i++) {
//             sg[i] = new Segments(starts[i], ends[i]);
//         }
//         Arrays.sort(sg, new Comparator<Segments>(){
//             public int compare(Segments a, Segments b) {
//                 if (a.end > b.end) {
//                     return 1;
//                 }
//                 return -1;
//             }
//         });
//         for (int i = 0; i < points.length; i++) {
//             int tempPoint = points[i];
//             int left = binarySearch(sg, tempPoint, 0, sg.length - 1);
//             if (left == -1) {
//                 continue;
//             }
//             for (int j = left - 1; j >= 0; j++) {
//                 if (tempPoint >= sg[j].start && tempPoint <= sg[j].end) {
//                     cnt[i]++;
//                 }
//                 if (tempPoint < sg[j].start) {
//                     break;
//                 }
//             }
//             for (int j = left; j < sg.length; j++) {
//                 if (tempPoint >= sg[j].start && tempPoint <= sg[j].end) {
//                     cnt[i]++;
//                 }                           
//                 if (tempPoint < sg[j].start) {
//                     break;
//                 }
//             }
//         }
//         return cnt;
//     }
    
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         int n, m;
//         n = scanner.nextInt();
//         m = scanner.nextInt();
//         int[] starts = new int[n];
//         int[] ends = new int[n];
//         int[] points = new int[m];
//         for (int i = 0; i < n; i++) {
//             starts[i] = scanner.nextInt();
//             ends[i] = scanner.nextInt();
//         }
//         for (int i = 0; i < m; i++) {
//             points[i] = scanner.nextInt();
//         }

//         int[] cnt = naiveCountSegments(starts, ends, points);
//         for (int x : cnt) {
//             System.out.print(x + " ");
//         }
//     }

// }