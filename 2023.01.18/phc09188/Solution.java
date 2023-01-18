import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static StringBuffer sb = new StringBuffer();
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i]= Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }
        if(max <3) board = new int[4][2];
        else board = new int[max+1][2];
        fill();
        for (int cur : arr) {
            sb.append(board[cur][0]).append(" ").append(board[cur][1]).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }

    private static void fill() {
        int high = board.length;
        board[0][0] = 1; board[1][1] = 1;
        board[2][0] = 1; board[2][1] = 1;
        int cur =3;
        while(cur<high){
            board[cur][0] = board[cur-1][0] + board[cur-2][0];
            board[cur][1] = board[cur-1][1] + board[cur-2][1];
            cur++;
        }
    }

}
