#include <string>
#include <vector>
#include <map>

using namespace std;
struct st {
    int year, month, day;
    
    bool operator<(const st &s) const {
        if(year == s.year) {
            if(month == s.month) {
                return day < s.day;
            }
            return month < s.month;
        }
        return year < s.year;
    }
};

st convert(string str) {
    return {stoi(str.substr(0, 4)), stoi(str.substr(5, 7)), stoi(str.substr(8, 10))};
}

st addMonth(st s, int month) {
    int m = s.month + month;
    int div = m / 12;
    int mod = m % 12;
    
    if(mod == 0) {
        s.year += div - 1;
        s.month = 12;
    }
    else {
        s.year += div;
        s.month = mod;
    }
    
    return s;
}

vector<int> solution(string today, vector<string> terms, vector<string> privacies) {
    vector<int> answer;
    map<char, int> m;
    
    for(int i=0; i<terms.size(); i++) {
        m.insert({terms[i].substr(0, 1)[0], stoi(terms[i].substr(2, 3))});
    }
    
    st todaySt = convert(today);
    
    for(int i=0; i<privacies.size(); i++) {
        string date = privacies[i].substr(0, 10);
        char c = privacies[i].substr(11, 12)[0];
        
        st s = addMonth(convert(date), m[c]);
        
        if(todaySt < s) continue;
        answer.push_back(i + 1);
    }
    return answer;
}