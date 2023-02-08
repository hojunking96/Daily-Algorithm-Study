package Algo_0208;

/*
 * Algorithm Study 23/02/08 problem
 * https://school.programmers.co.kr/learn/courses/30/lessons/155651
 * 호텔 대실
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.SimpleTimeZone;

/*
풀이법 생각

사용 종료 시각 기준으로 정렬하고 종료시간이 가장 빠르고 그 종료시간 10분 이후로 시작하는 예약을 고르면 된다.

1. book_time을 종료시간 기준으로 오름차순 정렬한다.
2. book_time의 0번 예약을 선택한다.
3. 해당 예약의 종료시간으로부터 10분 뒤 시각에서 제일 가까운 시작시간을 가진 예약을 고른다.
4. 더 이상 예약이 없을 때까지 3번을 반복한다.
5. answer을 1 증가시킨다.
6. 선택되지 않은 예약에 대해 1-5를 반복한다.
7. 선택되지 않은 예약이 없으면 루프를 종료한다.
 */
public class Solution {

    final static int EXIST = 0;
    final static int NON_EXIST = 1;

    final static int START_TIME = 0;
    final static int FINISH_TIME = 1;

    public static int solution(String[][] book_time) {
        int answer = 0;
        int len = book_time.length;
        int[] existCheckArr = new int[len];

        /*
        book_time을 정렬해야 한다. 종료시간 기준으로.
        문제는 들어오는 배열의 데이터 타입이 String이다. 숫자가 아니라서 비교가 되는지부터 체크해야된다.
        -> 된다!

        그럼 2차원 배열을 정렬해야 하는데
        종료시간 기준으로 오름차순 정렬하되 종료시간이 같을 경우 시작시간이 더 이른 기준으로 정렬해야 한다.
         */
        Arrays.sort(book_time, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[1].equals(o2[1])){
                    return o1[0].compareTo(o2[0]);
                }
                else{
                    return o1[1].compareTo(o2[1]);
                }
            }
        });

        while(len > 0){
            String[][] selectedReservationArr = new String[len][2];
            String lastReservationFinshTime = "00:00";
            int index = 0;

            for (int i = 0; i < book_time.length; i++) {

                if(existCheckArr[i] != EXIST){
                    continue;
                }
                else if(lastReservationFinshTime.compareTo(book_time[i][START_TIME]) <= 0){
                    selectedReservationArr[index][START_TIME] = book_time[i][START_TIME];
                    selectedReservationArr[index][FINISH_TIME] = book_time[i][FINISH_TIME];
                    existCheckArr[i] = NON_EXIST;

                    // 이게 10분을 더해야 하는데, 10분을 더할 때 변수가 좀 많다. 예를 들어 10:50이면 10분 뒤는 11:00 이 되어버려서 계산이 힘드니까 그냥 분으로 만든 다음에 10분 더하고 다시 시간:분 꼴로 만들자.
                    String[] splitTimeString = new String[2];
                    int[] splitTimeInt = new int[2];
                    int totalMin;
                    splitTimeString = book_time[i][FINISH_TIME].split(":");

                    for (int j = 0; j < 2; j++) {
                        splitTimeInt[j] = Integer.parseInt(splitTimeString[j]);
                    }
                    totalMin = splitTimeInt[0]*60 + splitTimeInt[1] + 10;
                    splitTimeInt[0] = totalMin / 60;
                    splitTimeInt[1] = totalMin % 60;

                    // 문제1. 1시 1분같은 경우 13:01이 되어야 하는데 13:1 이 되어버린다.
                    String hour = String.valueOf(splitTimeInt[0]);
                    String min =String.valueOf(splitTimeInt[0]);

                    if(splitTimeInt[0] < 10){
                        hour = "0" + String.valueOf(splitTimeInt[0]);
                    }
                    if(splitTimeInt[1] < 10){
                        min = "0" + String.valueOf(splitTimeInt[1]);
                    }

                    lastReservationFinshTime = hour + ":" + min ;

                    index++;
                }
            }

            for (int i = 0; i < index; i++) {
                System.out.println(selectedReservationArr[i][0] + "->" + selectedReservationArr[i][1]);
            }
            System.out.println("=========================");
            len -= index;
            answer++;
        }
        return answer;
    }
    public static void main(String[] args) {

        String[][] book_time = {{"10:00", "10:51"}, {"11:01", "16:03"},{"14:10", "17:00"},{"11:00", "17:00"},{"10:10", "22:00"}};

        System.out.println(solution(book_time));
    }
}

// 뭐가 문제일까?? 