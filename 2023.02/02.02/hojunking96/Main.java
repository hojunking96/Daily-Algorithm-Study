import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, K;
    public static int[] graph;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new int[100001];
        visited = new boolean[100001];
        BFS();
        System.out.println(graph[K]);
    }

    public static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == K) {
                break;
            }
            int next = now * 2;
            if (next <= 100000) {
                if (!visited[next]) {
                    q.add(next);
                    graph[next] = graph[now];
                    visited[next] = true;
                }
            }
            next = now - 1;
            if (next >= 0) {
                if (!visited[next]) {
                    q.add(next);
                    graph[next] = graph[now] + 1;
                    visited[next] = true;
                }
            }
            next = now + 1;
            if (next <= 100000) {
                if (!visited[next]) {
                    q.add(next);
                    graph[next] = graph[now] + 1;
                    visited[next] = true;
                }
            }
        }
    }
}
