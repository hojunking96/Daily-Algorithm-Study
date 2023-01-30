#include <string>
#include <vector>
#include <regex>

using namespace std;

string str[10] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
int solution(string s) {
    int answer = 0;
    
    for(int i=0; i<10; i++) {
        s = regex_replace(s, regex(str[i]), to_string(i));
    }
    return answer = stoi(s);
}