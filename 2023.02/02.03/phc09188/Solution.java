import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }



        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static List<Node>[] list;
    static boolean[] visited;
    static int v, e;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        list = new ArrayList[v + 1];
        visited = new boolean[v + 1];
        for (int i = 0; i <= v; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }
        int cnt = 0;
        PriorityQueue<Node> qu = new PriorityQueue<>();
        qu.add(new Node(1,0));
        while(!qu.isEmpty()){
            Node cur = qu.poll();
            int to = cur.to;
            int weight = cur.weight;
            if(visited[to]) continue;
            visited[to] = true;
            cnt += weight;
            for(Node a : list[to]){
                if(!visited[a.to]) qu.add(a);
            }
        }
        System.out.println(cnt);
    }
}
