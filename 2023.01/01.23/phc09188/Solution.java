import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double a = Integer.parseInt(br.readLine());
        double b = Integer.parseInt(br.readLine());
        double[][][] arr = new double[19][19][19];
        int[] notPrimes = {0,1,4,6,8,9,10,12,14,15,16,18};
        a /= 100; b/=100; arr[0][0][0] = 1;
        for (int t = 0; t <= 17; t++) {
            for (int i = 0; i <= t; i++) {
                for (int j = 0; j <= t; j++) {
                    /**
                     * 현재 스코어 -> 다음5분 뒤 스코어 예상
                     * 1. 둘 다 못 넣을 확률
                     * 2. a만 넣을 확률
                     * 3. b만 넣을 확률
                     * 4. 둘 다 넣을 확률
                     */
                    double cur = arr[t][i][j];
                    arr[t+1][i][j] += cur*(1-a)*(1-b);
                    arr[t+1][i+1][j] += cur*a*(1-b);
                    arr[t+1][i][j+1] += cur*(1-a)*b;
                    arr[t+1][i+1][j+1] += cur*a*b;
                }
            }
        }
        double answer = 1;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                answer -= arr[18][notPrimes[i]][notPrimes[j]];
            }
        }
        System.out.println(answer);
    }
}
