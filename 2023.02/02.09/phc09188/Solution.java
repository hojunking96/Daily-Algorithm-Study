package Programmerslv3;

public class Solution {
    public static int solution(int[][] scores) {
        int a = scores[0][0]; int b = scores[0][1];
        int front = 0; int error = 0;
        for (int i = 1; i < scores.length; i++) {
            int[] score = scores[i];
            if(score[0] >a && score[1] >b){
                error +=1;
            }if(score[0] + score[1] >a+b){
                if(check(i, scores)) {
                    front += 1;
                }
            }
        }
        if(error >=2) return -1;
        else return front+1;
    }

    private static boolean check(int i, int[][] scores) {
        int error = 0;
        for (int j = 0; j < scores.length; j++) {
            if(j == i) continue;
            int[] score = scores[j];
            if(score[0] > scores[i][0] && score[1] > scores[i][1] ){
                error +=1;
                if(error >=2) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2},{2,2},{4,3},{3,2},{2,1}};
        System.out.println(solution(arr));
    }
}
