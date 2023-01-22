import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    private static List<Integer>[] tree;
    private static int[] parentArr;
    private static int N;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        parentArr = new int[N + 1];
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            tree[num1].add(num2);
            tree[num2].add(num1);
        }
        makeTree(1, 0);
        printTree();
        System.out.print(sb);
    }

    public static void makeTree(int start, int parent) {
        parentArr[start] = parent;
        for (int e : tree[start]) {
            if (e != parent)
                makeTree(e, start);
        }
    }

    public static void printTree() {
        for (int i = 2; i <= N; i++) {
            sb.append(parentArr[i]).append("\n");
        }
    }
}
