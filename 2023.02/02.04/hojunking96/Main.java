import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class App {
        int memory;
        int cost;

    }

    public static int N, M;
    public static App[] applications;
    public static int[] dp;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        applications = new App[N];
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            applications[i] = new App();
            applications[i].memory = Integer.parseInt(st.nextToken());
            applications[i].cost = Integer.parseInt(st2.nextToken());

        }
        dp = new int[10001];
        for (int i = 0; i < N; i++) {
            for (int j = 10000; j - applications[i].cost >= 0; j--) {
                dp[j] = Math.max(dp[j - applications[i].cost] + applications[i].memory, dp[j]);
            }
        }

        for (int i = 0; i < 10001; i++) {
            if (dp[i] >= M) {
                System.out.println(i);
                break;
            }
        }
    }
}
