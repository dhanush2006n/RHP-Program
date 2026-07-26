import java.util.Arrays;
import java.util.Scanner;

public class cSushi {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] shari = new int[n];
        int[] neta = new int[m];
        Arrays.sort(shari);
        Arrays.sort(neta);
        System.out.println(Count(shari, neta));
    }

    static int Count(int[] shari, int[] neta) {
//        int count=0;
        int j = 0;
//        int updatedJ=neta.length-1;
        int i = 0;
        int count = 0;
        while (i < shari.length && j < neta.length) {
            if (2 * shari[i] >= neta[j]) {
                count++;
                j++;
                i++;
            } else {
                i++;
            }

        }
        return count;
    }
}
