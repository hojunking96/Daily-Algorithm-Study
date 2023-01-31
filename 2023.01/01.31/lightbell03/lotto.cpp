#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int arr[46];

vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    vector<int> answer;
    for(int i=0; i<lottos.size(); i++){
        arr[lottos[i]]++;
    }
    
    int cnt = 0;
    for(int i=0; i<win_nums.size(); i++) {
        cnt += arr[win_nums[i]];
    }
    
    int val1 = cnt + arr[0] == 0 ? 6 : 6 - cnt - arr[0] + 1;
    int val2 = cnt == 0 ? 6 : 6 - cnt + 1;
    
    answer.push_back(min(val1, val2));
    answer.push_back(max(val1, val2));
    return answer;
}