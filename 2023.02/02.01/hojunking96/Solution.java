import java.util.HashMap;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer;
        int privacySize = privacies.length;
        int[] tmpAnswer = new int[privacySize];

        HashMap<Character, Integer> termsMap = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            termsMap.put(terms[i].charAt(0), Integer.parseInt(terms[i].substring(2)));
        }

        int ptr = 0;
        for (int i = 0; i < privacySize; i++) {
            char termType = privacies[i].charAt(11);
            int duration = termsMap.get(termType);
            String privacyDate = privacies[i].substring(0, 10);
            //(index) 0 : year , 1 : month, 2 : day
            int[] todayArr = stringToIntArr(today);
            int[] tempDeadLineArr = stringToIntArr(privacyDate);
            int[] deadLineArr = calculateDeadLine(tempDeadLineArr, duration);

            if (isExpired(todayArr, deadLineArr)) {
                tmpAnswer[ptr] = i + 1;
                ptr++;
            }
        }
        answer = new int[ptr];
        for (int i = 0; i < ptr; i++) {
            answer[i] = tmpAnswer[i];
        }
        return answer;
    }

    public static int[] stringToIntArr(String date) {
        int[] dateArr = new int[3];
        String[] dates = date.split("\\.");
        for (int i = 0; i < 3; i++) {
            dateArr[i] = Integer.parseInt(dates[i]);
        }
        return dateArr;
    }

    public static int[] calculateDeadLine(int[] deadLineArr, int duration) {
        deadLineArr[1] += duration;
        while (deadLineArr[1] > 12) {
            deadLineArr[1] -= 12;
            deadLineArr[0]++;
        }
        return deadLineArr;
    }

    public static boolean isExpired(int[] todayArr, int[] deadLineArr) {
        if (todayArr[0] > deadLineArr[0])
            return true;
        if (todayArr[0] == deadLineArr[0]) {
            if (todayArr[1] > deadLineArr[1])
                return true;
            if (todayArr[1] == deadLineArr[1]) {
                if (todayArr[2] >= deadLineArr[2])
                    return true;
            }
        }
        return false;
    }
}
