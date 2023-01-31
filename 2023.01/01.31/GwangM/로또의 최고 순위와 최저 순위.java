class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int count0=0;
        int same=0;
        for(int i=0;i<6;i++){
            if (lottos[i]==0){
                count0++;
            }
            else{
            for(int j=0;j<6;j++){
              if (lottos[i]==win_nums[j]){
                  same++;
                  break;
              }
            }
            }
        }
        int low=0, high=0;
        if(same==0) 
            low=6;
        else 
            low=7-same;
        int count=same+count0;
        if(count==0) 
            high=6;
        else 
            high=7-count;
        int[] answer = {high,low};
        return answer;
    }
}