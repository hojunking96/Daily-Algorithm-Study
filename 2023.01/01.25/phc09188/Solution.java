import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static class Gem{
        int weight;
        int value;

        public Gem(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Gem[] gems = new Gem[n];
        int[] bags = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            gems[i] = new Gem(m,v);
        }
        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        // 무게 순으로 정렬 && 무게가 같을 경우는 값 순으로 정렬
        Arrays.sort(gems, new Comparator<Gem>() {
            @Override
            public int compare(Gem o1, Gem o2) {
                if(o1.weight == o2.weight){
                    return o2.value - o1.value;
                }
                return o1.weight - o2.weight;
            }
        });
        Arrays.sort(bags);
        long answer = 0;
        for (int i = 0; i < k; i++) {
            int j = 0;
            while(j<n && gems[i].weight<=bags[i]){
                pq.offer(gems[j++].value);
            }
            if(!pq.isEmpty()){
                answer+= pq.poll();
            }
        }
        System.out.println(answer);
    }
}
