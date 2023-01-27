import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[][] dp = new long[N][N];
        int x1, x2, y1, y2;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int k = Integer.parseInt(st.nextToken());
                makeMatrix(dp, i, j, k);
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken()) - 1;
            y1 = Integer.parseInt(st.nextToken()) - 1;
            x2 = Integer.parseInt(st.nextToken()) - 1;
            y2 = Integer.parseInt(st.nextToken()) - 1;
            long k = calculateResult(dp, x1, y1, x2, y2);
            sb.append(k).append("\n");
        }
        System.out.println(sb);
    }

    //x1,y1, x2,y2 가 주어졌을 때 요구 값 구하는 메소드
    public static long calculateResult(long[][] dp, int x1, int y1, int x2, int y2) {
        long diff;
        if (x1 == 0) {
            if (y1 == 0) {
                diff = 0;
            } else {
                diff = dp[x2][y1 - 1];
            }
        } else {
            if (y1 == 0) {
                diff = dp[x1 - 1][y2];
            } else {
                diff = dp[x2][y1 - 1] + dp[x1 - 1][y2] - dp[x1 - 1][y1 - 1];
            }
        }
        return dp[x2][y2] - diff;
    }


    //dp 배열을 생성하는 메소드 ( dp 값 : (0,0) 부터의 누적 합)
    public static void makeMatrix(long[][] dp, int x, int y, int k) {
        if (x == 0) {
            if (y == 0) {
                dp[x][y] = 0;
            } else {
                dp[x][y] = dp[x][y - 1];
            }
        } else {
            if (y == 0) {
                dp[x][y] = dp[x - 1][y];
            } else {
                dp[x][y] = dp[x - 1][y] + dp[x][y - 1] - dp[x - 1][y - 1];
            }
        }
        dp[x][y] += k;
    }
}
