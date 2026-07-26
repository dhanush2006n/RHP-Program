import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ihatesigmaproblems {
//    https://atcoder.jp/contests/abc371/tasks/abc371_e

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long sum = 0;
        long lastSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            lastSum = lastSum - map.getOrDefault(arr[i], 0) + (n - i);
            map.put(arr[i], n - i);
            sum += lastSum;
        }
        System.out.println(sum);
    }
}


