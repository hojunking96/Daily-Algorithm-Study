class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int[] reverseDelivers = new int[deliveries.length];
        int[] reversePickups = new int[pickups.length];
        for (int i = deliveries.length-1, j=0; i>=0; j++, i--) {
            reverseDelivers[j] = deliveries[i];
            reversePickups[j] = pickups[i];
        }
        long answer = 0;
        long d = 0; long p = 0;
        for (int i = 0; i < n; i++) {
            d += reverseDelivers[i];
            p += reversePickups[i];
            while(d>0 || p>0){
                d -= cap;
                p -= cap;
                answer += (n-i)*2;
            }
        }
        return answer;
    }
}