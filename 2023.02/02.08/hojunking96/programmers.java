import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
class Solution {
 
    static class Room {
        int start;
        int end;

        public Room(String start, String end) {
            this.start = calculate(start);
            this.end = calculate(end) + 10;
        }

        private int calculate(String time) {
            String[] arr = time.split(":");
            int h = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            return h * 60 + m;
        }
    }
    public int solution(String[][] book_time) {
         int answer = 0;
        PriorityQueue<Room> schedule = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));
        Room[] rooms = new Room[book_time.length];
        for (int i = 0; i < book_time.length; i++) {
            rooms[i] = new Room(book_time[i][0], book_time[i][1]);
        }
        Arrays.sort(rooms, Comparator.comparingInt(o -> o.start));
        for (Room room : rooms) {
            if (!schedule.isEmpty() && room.start >= schedule.peek().end) {
                schedule.poll();
            } else {
                answer++;
            }
            schedule.offer(room);
        }
        return answer;
    }
}

