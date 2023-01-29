import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        //정규 표현식 사용
        String pattern = "(100+1+|01)+";
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.matches(pattern)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}
