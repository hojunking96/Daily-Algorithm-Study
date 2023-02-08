package algo;

/*
 * Algorithm Study 23/02/08 problem
 * https://school.programmers.co.kr/learn/courses/30/lessons/155651
 * 호텔 대실
 */

import java.util.Arrays;
import java.util.Comparator;


/*
처음 풀이법 생각

사용 종료 시각 기준으로 정렬하고 종료시간이 가장 빠르고 그 종료시간 10분 이후로 시작하는 예약을 고르면 된다.

1. book_time을 종료시간 기준으로 오름차순 정렬한다.
2. book_time의 0번 예약을 선택한다.
3. 해당 예약의 종료시간으로부터 10분 뒤 시각에서 제일 가까운 시작시간을 가진 예약을 고른다.
4. 더 이상 예약이 없을 때까지 3번을 반복한다.
5. answer을 1 증가시킨다.
6. 선택되지 않은 예약에 대해 1-5를 반복한다.
7. 선택되지 않은 예약이 없으면 루프를 종료한다.

-> 하지만 종료시간 기준 정렬하면 틀린다!! 반례는 잘 모르겠다... 
 */
public class Solution {

    final static int EXIST = 0;
    final static int NON_EXIST = 1;

    final static int START_TIME = 0;
    final static int FINISH_TIME = 1;
    
    final static int HOUR = 0;
    final static int MINIUTE = 1;

    public static int solution(String[][] book_time) {
        int answer = 0;
        int existBookTimeNumbers = book_time.length;
        int[] existReservationCheckArr = new int[existBookTimeNumbers];

        /*
        book_time을 정렬해야 한다. 종료시간 기준으로.
        문제는 들어오는 배열의 데이터 타입이 String이다. 숫자가 아니라서 비교가 되는지부터 체크해야된다.
        -> 된다!

        그럼 2차원 배열을 정렬해야 하는데
        종료시간 기준으로 오름차순 정렬하되 종료시간이 같을 경우 시작시간이 더 이른 기준으로 정렬해야 한다.    
        -> NO 
        
        why? 
        이 문제는 한 방에 많은 예약을 넣는 것이 아니라 최소한의 방을 사용해야 한다. 비슷해 보이지만 같지 않다. 
        당장 바로 아래의 sort 방식을 변경했더니 바로 정답이 나왔다. 
         */
        Arrays.sort(book_time, new Comparator<String[]>() {
            @Override
            public int compare(String[] firstReservation, String[] secondReservation) {
                if(firstReservation[START_TIME].equals(secondReservation[START_TIME])){            
                	return firstReservation[FINISH_TIME].compareTo(secondReservation[FINISH_TIME]);
                }
                else{                              	                	       	
                	return firstReservation[START_TIME].compareTo(secondReservation[START_TIME]);
                }
            }
        });
        
        // 문제의 코드. 시작시간을 정렬해야 한다는 점. 
//        Arrays.sort(book_time, new Comparator<String[]>() {
//            @Override
//            public int compare(String[] firstReservation, String[] secondReservation) {
//                if(firstReservation[FINISH_TIME].equals(secondReservation[FINISH_TIME])){            
//                	return firstReservation[START_TIME].compareTo(secondReservation[START_TIME]);
//                }
//                else{                              	                	       	              	
//                	return firstReservation[FINISH_TIME].compareTo(secondReservation[FINISH_TIME]);
//                }
//            }
//        });
             
        for(int i=0; i<book_time.length; i++) {
        	System.out.println(book_time[i][START_TIME] + "-->" + book_time[i][FINISH_TIME]);
        }
        System.out.println("=====");
        

        while(existBookTimeNumbers > 0){
            String[][] availableReservationSetArray = new String[existBookTimeNumbers][2];
            String lastReservationFinshTime = "00:00";
            int availableReservationSetIndex = 0;

            for (int bookTimeIndex = 0; bookTimeIndex < book_time.length; bookTimeIndex++) {

                if(existReservationCheckArr[bookTimeIndex] != EXIST){
                	// 이미 조사한 예약이면 더 이상 검사해서는 안된다.
                    continue;
                }
                else if(lastReservationFinshTime.compareTo(book_time[bookTimeIndex][START_TIME]) <= 0){
                    availableReservationSetArray[availableReservationSetIndex][START_TIME] = book_time[bookTimeIndex][START_TIME];
                    availableReservationSetArray[availableReservationSetIndex][FINISH_TIME] = book_time[bookTimeIndex][FINISH_TIME];
                    existReservationCheckArr[bookTimeIndex] = NON_EXIST;

                    // 퇴실시간에서 10분을 더해야 하는데, 10분을 더할 때 변수가 좀 많다. 예를 들어 10:50이면 10분 뒤는 11:00 이 되어버려서 계산이 힘드니까 그냥 분으로 만든 다음에 10분 더하고 다시 시간:분 꼴로 만들자.
                    String[] splitTimeString = new String[2];
                    int[] splitTimeInt = new int[2];
                    int totalMin;
                    splitTimeString = book_time[bookTimeIndex][FINISH_TIME].split(":");

                    for (int j = 0; j < 2; j++) {
                        splitTimeInt[j] = Integer.parseInt(splitTimeString[j]);
                    }
                    totalMin = splitTimeInt[0]*60 + splitTimeInt[1] + 10;
                    splitTimeInt[HOUR] = totalMin / 60;
                    splitTimeInt[MINIUTE] = totalMin % 60;

                    // 문제1. 1시 1분같은 경우 13:01이 되어야 하는데 13:1 이 되어버린다.
                    String hour = String.valueOf(splitTimeInt[HOUR]);
                    String min =String.valueOf(splitTimeInt[MINIUTE]);

                    // 문제1 해결. 만약 10보다 작으면 앞에 0을 붙여준다. 
                    if(splitTimeInt[HOUR] < 10){
                        hour = "0" + String.valueOf(splitTimeInt[HOUR]);
                    }
                    if(splitTimeInt[MINIUTE] < 10){
                        min = "0" + String.valueOf(splitTimeInt[MINIUTE]);
                    }

                    lastReservationFinshTime = hour + ":" + min ;

                    availableReservationSetIndex++;
                }
            }

            for (int i = 0; i < availableReservationSetIndex; i++) {
                System.out.println(availableReservationSetArray[i][START_TIME] + "->" + availableReservationSetArray[i][FINISH_TIME]);
            }
            System.out.println("=========================");
            existBookTimeNumbers -= availableReservationSetIndex;
            answer++;
        }
        return answer;
    }
    public static void main(String[] args) {

        String[][] book_time = {{"09:10", "10:10"}, {"10:20", "12:20"},{"12:10", "12:20"},{"10:20", "11:11"},{"11:21", "22:00"}};

        System.out.println(solution(book_time));
    }
}

