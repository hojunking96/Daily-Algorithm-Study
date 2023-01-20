import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N, M;
    static int arr[];
    static int sel[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new int[N]; sel = new int[M];
        for (int i = 0; i < N; i++){
            arr[i] = i+1;
        }
        combination(1, 0);
        System.out.println(sb);
    }
    // 조합 알고리즘 사용
    public static void combination(int idx, int cnt) {
        if(cnt == M) {
            int x = 0;
            out: for (int j = 0; j < N; j++) {
                sb.append(sel[x++] + " ");
                if(x == M) break out;
            }

            sb.append('\n');
            return;
        }
        for (int i = idx - 1; i < N; i++) {
            sel[cnt] = arr[i];
            combination(i + 1, cnt+1);
        }
    }
}
