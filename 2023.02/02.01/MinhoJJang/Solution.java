import java.util.HashMap;

/*
 * Algorithm Study 23/2/1 problem
 * https://school.programmers.co.kr/learn/courses/30/lessons/150370
 * 개인정보 수집 유효기간
 */

/*
 * 후기: 예외적 상황들 처리하는게 생각보다 쉽지 않았던 것 같다.
 * 대표적으로 (contract_start_date[month] + expiration_date) % 12 == 0 이 경우를 생각했어야 했다...
 * 또한 자바에서는 split시 '.'으로는 할 수 없다는 점도 알게 되었다.
 */

public class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = new int[privacies.length];
        int answer_index = 0;
        final int year = 0;
        final int month = 1;
        final int day = 2;

        HashMap<String, Integer> terms_map = new HashMap<String, Integer>();

        for(int i = 0; i<terms.length; i++){
            String[] terms_new = terms[i].split(" ");
            terms_map.put(terms_new[0], Integer.parseInt(terms_new[1]));
        }

        for(int i = 0; i<privacies.length; i++){

            int expiration_date; // 유효기간
            String[] privacies_new = privacies[i].split(" "); // 개인정보를 날짜와 약관종류로 나눈다
            expiration_date = terms_map.get(privacies_new[1]);

            String[] today_string = today.split("[.]");

            String[] expire_string = privacies_new[0].split("[.]");

            int[] today_date = new int[3]; // 오늘 날짜
            int[] contract_start_date = new int[3]; // 계약 시작 날짜
            int[] contract_end_date = new int[3]; // 계약 만료 날짜

            for (int j = 0; j < today_string.length; j++) {
                today_date[j] = Integer.parseInt(today_string[j]);
            }

            for (int j = 0; j < expire_string.length; j++) {
                contract_start_date[j] = Integer.parseInt(expire_string[j]);
            }

            // 계약 만료 날짜를 계산한다. (보관 가능한 날짜가 아니다!)
            /*
             *
             * ex
             * 2021.7.01 -> 약관 유효기간 18개월일 경우
             * 계약 만료날짜는 2023.01.01 이다.
             * 2023.01.01에 만료된다는 것은 오늘이 저 날짜이거나 혹은 미래라면 해당 개인정보를 파기하면 된다.
             */

            // 여기가 문제의 핵심
            // 예를 들어 7월 1일에 시작한 약관의 유효기간이 5개월이라면, 만료일자는 12월 1일이지만 if문 내부 식으로 계산하면 내년 1월 1일이 되어 버린다.
            // month가 0월이 될 위험을 제거해주자
            if((contract_start_date[month] + expiration_date) % 12 == 0){
                contract_end_date[year] = contract_start_date[year] + (contract_start_date[month] + expiration_date )/12 - 1;
                contract_end_date[month] = 12;

            }
            else {
                contract_end_date[year] = contract_start_date[year] + (contract_start_date[month] + expiration_date)/12;
                contract_end_date[month] = (contract_start_date[month] + expiration_date)%12;
            }
            contract_end_date[day] = contract_start_date[day];

            // 계약 만료 날짜가 오늘을 지났는지 확인한다.
            if(contract_end_date[year] < today_date[year]){
                answer[answer_index++] = i+1;
            }
            else if(contract_end_date[year] == today_date[year]){
                if(contract_end_date[month] < today_date[month]){
                    answer[answer_index++] = i+1;
                }
                else if(contract_end_date[month] == today_date[month]){
                    if(contract_end_date[day] <= today_date[day]){
                        answer[answer_index++] = i+1;
                    }
                }
            }
        }

        int[] real_answer = new int[answer_index];
        for(int i=0; i<answer_index; i++){
            real_answer[i] = answer[i];
        }

        return real_answer;
    }
//
//    public static void main(String[] args) {
//        Solution sol = new Solution();
//        int[] answer = sol.solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
//        System.out.println(answer);
//    }
}
