import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int n, m, h;
    static int[][][] board;
    static int[][] dirs = {{0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}, {0, 0, 1}, {0, 0, -1}};

    static class Node {
        int x;
        int y;
        int h;
        int depth;

        public Node(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.depth = 0;
        }

        public Node(int x, int y, int h, int depth) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        board = new int[n][m][h];
        Queue<Node> qu = new LinkedList<>();
        for (int height = 0; height < h; height++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    board[i][j][height] = Integer.parseInt(st.nextToken());
                    if (board[i][j][height] == 1) {
                        qu.add(new Node(i, j, height));
                    }
                }
            }
        }
        while (!qu.isEmpty()) {
            Node cur = qu.poll();
            answer = Math.max(answer, cur.depth);
            for (int[] dir : dirs) {
                int nx = dir[0] + cur.x;
                int ny = dir[1] + cur.y;
                int nh = dir[2] + cur.h;
                if (nx >= 0 && ny >= 0 && nh >= 0 && nx < n && ny < m && nh < h) {
                    if (board[nx][ny][nh] == 0) {
                        board[nx][ny][nh] = 1;
                        qu.add(new Node(nx, ny, nh, cur.depth + 1));
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < h; k++) {
                    if (board[i][j][k] == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
