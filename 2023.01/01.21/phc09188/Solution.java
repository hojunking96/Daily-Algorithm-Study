import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());
            list.get(b).add(a);
            list.get(a).add(b);
        }
        boolean visited[] = new boolean[n+1];
        Queue<Integer> qu = new LinkedList<>();
        qu.add(1); visited[1] = true;
        int answer[] = new int[n+1];
        while(!qu.isEmpty()){
            int num = qu.poll();
            for(int i : list.get(num)){
                if(!visited[i]){
                    visited[i] = true;
                    answer[i] = num;
                    qu.add(i);
                }
            }

        }
        for (int i = 2; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}