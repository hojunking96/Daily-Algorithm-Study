import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> qu = new LinkedList<>();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        // 100000까지로 잡으면 틀렸다고 나옴, 비효율 방식
        int max = 200000;
        int[] dp = new int[max+1];
        Arrays.fill(dp, INF);
        dp[n] = 0;
        qu.add(n);
        while(!qu.isEmpty()){
            int cur = qu.poll();
            if(cur <=max && cur>0){
                if (dp[cur - 1] >= dp[cur] + 1) {
                    dp[cur - 1] = Math.min(dp[cur] + 1, dp[cur - 1]);
                    qu.add(cur - 1);
                }
                if (cur + 1 <= max) {
                    if (dp[cur + 1] >= dp[cur] + 1) {
                        dp[cur + 1] = Math.min(dp[cur + 1], dp[cur] + 1);
                        qu.add(cur + 1);
                    }
                }
                if (cur * 2 <= max) {
                    if (dp[cur * 2] >= dp[cur]) {
                        qu.add(cur * 2);
                        dp[cur * 2] = Math.min(dp[cur * 2], dp[cur]);
                    }
                }
            }
        }
        System.out.println(dp[k]);
    }
}
