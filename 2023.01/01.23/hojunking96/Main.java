import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double A = Integer.parseInt(br.readLine());
        double B = Integer.parseInt(br.readLine());
        double AScoreProbability = primeNumProbability(A / 100);
        double BScoreProbability = primeNumProbability(B / 100);
        double answer = 1 - AScoreProbability * BScoreProbability;
        System.out.println(answer);
    }

    public static double primeNumProbability(double scoreProbability) {
        double sum = 0;
        for (int i = 0; i <= 18; i++) {
            if (!isPrime(i)) {
                sum += combination(i) * calcProbability(scoreProbability, i);
            }
        }
        return sum;
    }

    public static boolean isPrime(int k) {
        if (k == 0 || k == 1)
            return false;
        for (int i = 2; i <= Math.sqrt(k); i++) {
            if (k % i == 0)
                return false;
        }
        return true;
    }

    public static double calcProbability(double scoreProbability, int cnt) {
        double result = 1;
        for (int i = 0; i < cnt; i++) {
            result *= scoreProbability;
        }
        for (int i = cnt; i < 18; i++) {
            result *= (1 - scoreProbability);
        }
        return result;
    }

    public static double combination(int cnt) {
        double upSide = 1;
        double downSide = 1;
        for (int i = 1; i <= cnt; i++) {
            upSide *= (19 - i);
            downSide *= i;
        }
        return upSide / downSide;
    }
}
