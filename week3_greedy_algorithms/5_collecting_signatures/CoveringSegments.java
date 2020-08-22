import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        Arrays.sort(segments, new Comparator<Segment>(){
            public int compare(Segment a, Segment b) {
                int diffa = a.end - a.start;
                int diffb = b.end - b.start; 
                if (a.end > b.end) {
                    return 1;
                }
                return -1;    
            }
        });
        int k = 0;
        int i = 0;
        ArrayList<Integer> points = new ArrayList<Integer>();
        while(k < segments.length) {
            int endPoint = segments[k].end;
            points.add(endPoint);
            while (k + 1 < segments.length && endPoint >= segments[k + 1].start && endPoint <= segments[k + 1].end) {
                k++;
            }
            k++;
        }
        int[] output = new int[points.size()];
        for (i = 0; i < points.size(); i++) {
            output[i] = points.get(i);
        }
        return output;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
