import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static StringBuilder sb = new StringBuilder();
    private static final String pattern = "(100+1+|01)+";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String test = br.readLine();
            if(test.matches(pattern)) sb.append("YSE\n");
            else sb.append("NO\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}