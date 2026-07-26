import java.util.Scanner;

public class dcountry {
    //    https://atcoder.jp/contests/abc371/tasks/abc371_d
    public static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coordiates = new int[n];
        long[] villages = new long[n + 1];
        for (int i = 0; i < n; i++) {
            coordiates[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            int currentVillage = sc.nextInt();
            villages[i] = currentVillage + villages[i - 1];
        }
        int queries = sc.nextInt();
        for (int i = 0; i < queries; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int lower = BinarySearch(coordiates, start, true);
            int upper = BinarySearch(coordiates, end, false);
            long ans = villages[upper] - villages[lower];
            System.out.println(ans);
        }
    }

    private static int BinarySearch(int[] coordiates, int target, boolean b) {
        int low = 0;
        int high = coordiates.length - 1;
        int bound = coordiates.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (b && coordiates[mid] >= target) {
                bound = mid;
                high = mid - 1;
            } else if (!b && coordiates[mid] > target) {
                bound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return bound;
    }

//    private static int upperBound(int[] coordiates, int key) {
//        int low=0;
//        int high=coordiates.length-1;
//        while(low<=high){
//            int mid=low+(high-low)/2;
//            if(coordiates[mid]>key){
//                high=mid;
//            }
//            else{
//                low=mid+1;
//            }
//        }
//
//        return low;
//    }
//
//    private static int lowerBound(int[] coordiates, int key) {
//        int low=0;
//        int high=coordiates.length;
//        while (low<high){
//            int mid=low+(high-low)/2;
//            if(coordiates[mid]>=key){
//                high=mid;
//            }
//            else{
//                low=mid+1;
//            }
//
//        }
//        if(low<coordiates.length && coordiates[low]<key){
//            low++;
//        }
//        return low;
//    }

}

