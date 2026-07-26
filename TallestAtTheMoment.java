import java.util.*;

public class TallestAtTheMoment {
    //    https://atcoder.jp/contests/abc463/tasks/abc463_c
    static void main() {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> time = new ArrayList<>();

        int timet = -1;
        int n = sc.nextInt();
//        int[] t=new int[n];
//        int[] h=new int[n];
        for (int i = 0; i < n; i++) {
            int height = sc.nextInt();
            int timetaken = sc.nextInt();
            if (timetaken > timet) {
                time.add(new ArrayList<>(Arrays.asList(height, timetaken)));
                timet = timetaken;
            }
        }
        Collections.sort(time, Comparator.comparing((ArrayList<Integer> list) -> list.get(0)).reversed());
        int queries = sc.nextInt();
        for (int i = 0; i < queries; i++) {
            int requiredtime = sc.nextInt();
            System.out.println(time.get(binarysearch(time, requiredtime)).get(0));

        }
    }

    static int binarysearch(ArrayList<ArrayList<Integer>> time, int requiredtime) {
        int low = 0;
        int high = time.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (time.get(mid).get(1) > requiredtime) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}

