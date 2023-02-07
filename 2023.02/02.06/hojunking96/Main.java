import java.util.*;

class Solution {
   
    static class Node {
        int dist;
        int boxCnt;

        public Node(int dist, int boxCnt) {
            this.dist = dist;
            this.boxCnt = boxCnt;
        }
    }
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        Stack<Node> deliveryStack = new Stack<>();
        Stack<Node> pickupStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (deliveries[i] != 0) {
                deliveryStack.push(new Node(i + 1, deliveries[i]));
            }
            if (pickups[i] != 0) {
                pickupStack.push(new Node(i + 1, pickups[i]));
            }
        }
        return count(cap, deliveryStack, pickupStack);
    }

   public static long count(int cap, Stack<Node> deliveryStack, Stack<Node> pickupStack) {
        long dist = 0;
        while (!deliveryStack.isEmpty() || !pickupStack.isEmpty()) {
            int deliveryBox = cap;
            int pickupBox = cap;
            long dist1 = 0;
            long dist2 = 0;
            if (!deliveryStack.isEmpty()) {
                dist1 = deliveryStack.peek().dist;
            }
            if (!pickupStack.isEmpty()) {
                dist2 = pickupStack.peek().dist;
            }
            while (!deliveryStack.isEmpty()) {
                Node lastDelivery = deliveryStack.pop();
                deliveryBox -= lastDelivery.boxCnt;
                if (deliveryBox < 0) {
                    deliveryStack.push(new Node(lastDelivery.dist, Math.abs(deliveryBox)));
                    break;
                }
            }
            while (!pickupStack.isEmpty()) {
                Node lastPickup = pickupStack.pop();
                pickupBox -= lastPickup.boxCnt;
                if (pickupBox < 0) {
                    pickupStack.push(new Node(lastPickup.dist, Math.abs(pickupBox)));
                    break;
                }
            }
            dist += Math.max(dist1, dist2);
        }
        return dist * 2;
    }
}
