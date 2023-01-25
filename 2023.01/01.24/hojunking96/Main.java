import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static long cnt;
    public static long price;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            price = Long.parseLong(br.readLine());
            cnt = 0;
            countCoin();
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    public static void countCoin() {
        while (price != 0) {
            countPerHundred();
            price /= 100;
        }
    }

    public static void countPerHundred() {
        long hundredPart = price % 100;
        if (hundredPart == 0)
            return;
        long min = countByTen(hundredPart);
        for (int i = 1; i < 4; i++) {
            if (hundredPart - 25 * i < 0)
                break;
            long tmp = countByTen(hundredPart - 25 * i) + i;
            if (tmp < min)
                min = tmp;
        }
        cnt += min;
    }

    public static long countByTen(long number) {
        long k = 0;
        while (number != 0) {
            k += number % 10;
            number /= 10;
        }
        return k;
    }
}
