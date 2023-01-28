import java.io.*;
import java.util.*;

public class Main {
    public static int C;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> cutPositions = new HashMap<>();
        PriorityQueue<Integer> woods = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int newPosition = Integer.parseInt(st.nextToken());
            if (cutPositions.containsKey(newPosition)) {
                int tmpCnt = cutPositions.get(newPosition);
                cutPositions.remove(newPosition);
                cutPositions.put(newPosition, tmpCnt + 1);
            } else {
                cutPositions.put(newPosition, 1);
            }
        }
        woods.add(L);
        int longest = cut(0, cutPositions, woods);
        System.out.println(longest + " " + min);
    }

    public static int cut(int cutCnt, HashMap<Integer, Integer> cutPositions, PriorityQueue<Integer> woods) {
        while (true) {
            int wood = woods.poll();
            if (cutPositions.isEmpty() || cutCnt == C || wood == 1)
                return wood;
            int left, right;
            if (cutCnt == C - 1) {
                left = wood / 2;
                right = wood / 2;
            } else {
                left = (wood + 1) / 2;
                right = (wood + 1) / 2;
            }
            while (right < wood || left > 0) {
                if (left > 0 && cutPositions.containsKey(left)) {
                    int tmpCnt = cutPositions.get(left);
                    cutPositions.remove(left);
                    if (tmpCnt > 1) {
                        cutPositions.put(left, tmpCnt - 1);
                    }
                    woods.add(left);
                    woods.add(wood - left);
                    if (min > left)
                        min = left;
                    break;
                } else if (right < wood && cutPositions.containsKey(right)) {
                    int tmpCnt = cutPositions.get(right);
                    cutPositions.remove(right);
                    if (tmpCnt > 1) {
                        cutPositions.put(right, tmpCnt - 1);
                    }
                    woods.add(right);
                    woods.add(wood - right);
                    if (min > right)
                        min = right;
                    break;
                }
                left--;
                right++;
            }
            cutCnt++;
        }
    }
}
