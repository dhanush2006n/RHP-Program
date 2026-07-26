import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class staticrangesumqueries {
//    https://cses.fi/problemset/task/1646/
     public static void main(String[] args) throws Exception{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         PrintWriter out = new PrintWriter(System.out);
         StringTokenizer st = new StringTokenizer(br.readLine());

         int n = Integer.parseInt(st.nextToken());
         int q = Integer.parseInt(st.nextToken());

         long[] pref = new long[n + 1];

         st = new StringTokenizer(br.readLine());
         for (int i = 1; i <= n; i++) {
             long val = Long.parseLong(st.nextToken());
             pref[i] = pref[i - 1] + val;
         }

         for (int i = 0; i < q; i++) {
             st = new StringTokenizer(br.readLine());
             int a = Integer.parseInt(st.nextToken());
             int b = Integer.parseInt(st.nextToken());

             out.println(pref[b] - pref[a - 1]);
         }

         out.close();
}
}
