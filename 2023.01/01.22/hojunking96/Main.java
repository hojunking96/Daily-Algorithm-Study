import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static final int INF = Integer.MAX_VALUE;
    private static int[][] costs;
    private static int N;
    private static int M;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        costs = new int[N][N];
        initCost();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            costs[start - 1][dest - 1] = Math.min(costs[start - 1][dest - 1], cost);
        }
        floydWarshall();
        writeCosts();
        System.out.println(sb);
    }

    public static void initCost() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    costs[i][j] = 0;
                } else {
                    costs[i][j] = INF;
                }
            }
        }
    }

    public static void floydWarshall() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (costs[j][i] == INF || costs[i][k] == INF)
                        continue;
                    costs[j][k] = Math.min(costs[j][k], costs[j][i] + costs[i][k]);
                }
            }
        }
    }

    public static void writeCosts() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (costs[i][j] == INF)
                    sb.append(0).append(" ");
                else {
                    sb.append(costs[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
    }
}
