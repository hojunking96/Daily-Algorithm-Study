import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int[] dp = new int[101];
    static int[] coins = {1, 10, 25};
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < dp.length; i++) {
            dp[i] = INF;
            for (int j = 0; j < coins.length; j++) {
                if(i-coins[j] >= 0){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            long cur = Long.parseLong(br.readLine());
            int cnt = 0;
            while(cur>0){
                long length = cur%100;
                cnt += dp[(int)length];
                cur = cur/100;
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb.toString());
    }
}
