import java.util.*;

class Solution {
    public int solution(String s) {
         int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        String newString = "";
        insertMap(map);
        int ptr = 0;
        while (ptr < s.length()) {
            char letter = s.charAt(ptr);
            if (letter <= '9' && letter >= '0') {
                newString += letter;
                ptr++;
                continue;
            }
            String threeWord = s.substring(ptr, ptr + 3);
            if (map.containsKey(threeWord)) {
                newString += map.get(threeWord);
                ptr += 3;
                continue;
            }
            String fourWord = s.substring(ptr, ptr + 4);
            if (map.containsKey(fourWord)) {
                newString += map.get(fourWord);
                ptr += 4;
                continue;
            }
            String fiveWord = s.substring(ptr, ptr + 5);
            if (map.containsKey(fiveWord)) {
                newString += map.get(fiveWord);
                ptr += 5;
                continue;
            }
        }
        answer = Integer.parseInt(newString);
        return answer;
    }
    
       public static void insertMap(Map<String, Integer> map) {
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
    }
}
