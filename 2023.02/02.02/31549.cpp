#include <iostream>
#include <queue>
#include <vector>

#define MAX 200001
#define INF 2000000000
using namespace std;

int N, K;
int d[3] = {-1, 1, 2};

int main() {
    cin >> N >> K;

    if(N > K) {
        cout << N - K << "\n";
        return 0;
    }
    vector<int> v(MAX, INF);
    queue<int> q;
    q.push(N);
    v[N] = 1;

    while(!q.empty()) {
        int now = q.front();
        q.pop();

        for(int i=0; i<3; i++){
            int next = -1;
            if(i == 2) next = now * d[i];
            else next = now + d[i];

            if(next < 0 ||  next > K * 2) continue;
            
            if(i == 2) {
                if(v[next] <= v[now]) continue;
                v[next] = v[now];
                q.push(next);
            }
            else {
                if(v[next] <= v[now] + 1) continue;
                v[next] = v[now] + 1;
                q.push(next);
            }
        }
    }

    cout << v[K] - 1 << "\n";
}