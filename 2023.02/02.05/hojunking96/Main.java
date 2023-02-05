import java.util.*;

class Solution {
      
    class Vertex {
        int v;
        int w;

        public Vertex(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    private List<List<Vertex>> graph;
    private int[] dist;
    private int minIntensity = 10000000;
    private int minSummit = 50001;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        dist = new int[n + 1];
        Arrays.fill(dist, 10000001);

        for (int[] path : paths) {
            int v1 = path[0];
            int v2 = path[1];
            int weight = path[2];
            if (isGate(v1, gates) || isSummit(v2, summits)) {
                graph.get(v1).add(new Vertex(v2, weight));
            } else if (isGate(v2, gates) || isSummit(v1, summits)) {
                graph.get(v2).add(new Vertex(v1, weight));
            } else {
                graph.get(v1).add(new Vertex(v2, weight));
                graph.get(v2).add(new Vertex(v1, weight));
            }
        }
        for (int gate : gates) {
            dist[gate] = 0;
        }
        dijkstra(n, gates);
        for (int summit : summits) {
            if (dist[summit] < minIntensity) {
                minIntensity = dist[summit];
                minSummit = summit;
            } else if (dist[summit] == minIntensity) {
                if (minSummit > summit) {
                    minSummit = summit;
                }
            }
        }
        return new int[]{minSummit, minIntensity};
    }

    private boolean isGate(int v, int[] gates) {
        for (int gate : gates) {
            if (v == gate) {
                return true;
            }
        }
        return false;
    }

    private boolean isSummit(int v, int[] summits) {
        for (int summit : summits) {
            if (v == summit) {
                return true;
            }
        }
        return false;
    }

    private void dijkstra(int n, int[] gates) {
        Queue<Vertex> q = new LinkedList<>();
        for (int gate : gates) {
            q.add(new Vertex(gate, 0));
        }
        while (!q.isEmpty()) {
            Vertex vertex = q.poll();
            if (vertex.w > dist[vertex.v]) continue;
            for (int i = 0; i < graph.get(vertex.v).size(); i++) {
                Vertex nextVertex = graph.get(vertex.v).get(i);
                int d = Math.max(dist[vertex.v], nextVertex.w);
                if (dist[nextVertex.v] > d) {
                    dist[nextVertex.v] = d;
                    q.add(new Vertex(nextVertex.v, d));
                }
            }
        }
    }
}
