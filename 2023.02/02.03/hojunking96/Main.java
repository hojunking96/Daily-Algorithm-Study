import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge {
        private int start;
        private int end;
        private int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getWeight() {
            return weight;
        }

    }

    public static int V, E;
    public static int[] parent;
    public static List<Edge> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edges.add(new Edge(A, B, C));
        }
        parent = new int[V + 1];
        edges.sort(Comparator.comparingInt(Edge::getWeight));
        for (int i = 1; i < V + 1; i++) {
            parent[i] = i;
        }
        System.out.println(kruscal());
    }

    private static long kruscal() {
        long totalWeight = 0;
        for (int i = 0; i < E; i++) {
            Edge edge = edges.get(i);
            int start = edge.getStart();
            int end = edge.getEnd();
            if (findParent(start) != findParent(end)) {
                union(start, end);
                totalWeight += edge.getWeight();
            }
        }
        return totalWeight;
    }

    private static int findParent(int x) {
        if (parent[x] == x)
            return x;
        return findParent(parent[x]);
    }

    private static void union(int v1, int v2) {
        v1 = findParent(v1);
        v2 = findParent(v2);
        if (v1 > v2) {
            parent[v1] = v2;
        } else {
            parent[v2] = v1;
        }
    }
}

