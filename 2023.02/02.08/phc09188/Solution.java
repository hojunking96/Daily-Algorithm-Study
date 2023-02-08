package Programmerslv2;

public class Solution {
    static int[] rooms;
    static int answer = 0;
    public int solution(String[][] book_time) {
        // 24 * 60 *  + (청소시간 9) + 여유1
        rooms = new int[1449];
        for(String[] reservation : book_time){
            times(reservation);
        }
        return answer;
    }
    private void times(String[] reservation){
        int startHour = Integer.parseInt(reservation[0].substring(0,2))*60;
        int startMinute = Integer.parseInt(reservation[0].substring(3));
        int endHour = Integer.parseInt(reservation[1].substring(0,2))*60;
        int endMinute = Integer.parseInt(reservation[1].substring(3))+9;
        for (int i = startHour+startMinute; i <= endHour+endMinute; i++) {
            rooms[i] += 1;
            answer = Math.max(answer, rooms[i]);
        }
    }
    public static void main(String[] args) {
        호텔대실 a = new 호텔대실();
        String[][] books = {{"00:10","10:00"},{"10:24","23:59"}};
        System.out.println(a.solution(books));
    }
}
