import java.util.Scanner;

public class newfriends {
    //    https://atcoder.jp/contests/abc350/tasks/abc350_d
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] ldr = new int[n + 1];
        int[] grpcnt = new int[n + 1];
        int[] edges = new int[n + 1];
        int[][] rlsp = new int[m][2];
        for (int i = 1; i <= n; i++) {
            ldr[i] = i;
        }
        for (int i = 0; i < m; i++) {
            rlsp[i][0] = sc.nextInt();
            rlsp[i][1] = sc.nextInt();
            Join(ldr, rlsp[i][0], rlsp[i][1]);
        }

        for (int i = 1; i <= n; i++) {
            grpcnt[find(ldr, i)]++;
        }
        for (int i = 0; i < m; i++) {
            edges[find(ldr, rlsp[i][1])]++;
        }
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans +=totalPassedges(grpcnt[i])-edges[i];
        }

        System.out.println(ans);
    }

    private static long totalPassedges(int i) {
        return (long)i*(i-1)/2;
    }

    private static void Join(int[] ldr, int lt, int rt) {
        int ldrlt = find(ldr, lt);
        int ldrrt = find(ldr, rt);
        ldr[ldrlt] = ldrrt;
    }

    static int find(int[] ldr, int node) {
        if (ldr[node] != node) {
            ldr[node] = find(ldr, ldr[node]);
        }
        return ldr[node];
    }
}
