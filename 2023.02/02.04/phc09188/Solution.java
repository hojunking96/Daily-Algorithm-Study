import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        int[] bites = new int[n]; int[] costs = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bites[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }
        // n*c 최대 10000
        int[] dp = new int[10001];
        Arrays.fill(dp, -1);
        for (int i = 0; i < n; i++) {
            int cost = costs[i];
            // 좋은 경우를 찾아랏!
            for (int j = 10000; j >=cost ; j--) {
                if(dp[j-cost] != -1){
                    int cur = dp[j-cost]+ bites[i];
                    if(cur>dp[j]){
                        dp[j] = cur;
                    }
                }
            }
            // 없다....
            if(dp[cost] < bites[i]) dp[cost] = bites[i];
        }

        for (int i = 0; i < 10001; i++) {
            if(dp[i] >= m){
                System.out.println(i);
                break;
            }
        }
    }
}
