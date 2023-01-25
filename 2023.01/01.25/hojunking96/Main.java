import java.io.*;
import java.util.*;

public class Main {
    static class Item {
        private final int weight;
        private final int price;

        public Item(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        public int getWeight() {
            return weight;
        }

        public int getPrice() {
            return price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Item[] items = new Item[N];
        long totalPrice = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            items[i] = new Item(weight, price);
        }
        Arrays.sort(items, (o1, o2) -> {
            if (o1.getWeight() == o2.getWeight()) {
                return o2.getPrice() - o1.getPrice();
            }
            return o1.getWeight() - o2.getWeight();
        });

        Integer[] bags = new Integer[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int ptr = 0;
        for (int i = 0; i < K; i++) {
            while (ptr < N && items[ptr].getWeight() <= bags[i]) {
                pq.offer(items[ptr].getPrice());
                ptr++;
            }
            if (!pq.isEmpty()) {
                totalPrice += pq.poll();
            }
        }
        System.out.println(totalPrice);
    }
}
