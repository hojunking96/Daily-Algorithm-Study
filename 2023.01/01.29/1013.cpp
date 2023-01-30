#include <iostream>
#include <regex>
#include <string>

using namespace std; 

int N;
string str;

int main () {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    //(100+1+ | 01)+
    regex r("(100+1+|01)+");
    cin >> N;

    while(N-- > 0) {
        cin >> str;
        auto it = *sregex_iterator(str.begin(), str.end(), r);
        smatch m;

        regex_match(str, m, r);
        if(m.str() == str) cout << "YES\n";
        else cout << "NO\n";
    }

}