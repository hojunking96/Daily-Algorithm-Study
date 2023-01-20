import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static int N;
    public static int M;
    public static StringBuilder sb;
    public static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        cnt = new int[N];
        dfs(0, 0);
        System.out.println(sb);
    }

    public static void dfs(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(cnt[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < N; i++) {
            cnt[depth] = i + 1;
            dfs(depth + 1, i);
        }
    }
}
