#include <iostream>
#include <algorithm>
#include <vector>

#define MAX 100001
using namespace std;

struct st {
    int u, v, w;
    bool operator<(const st &s) const {
        return w < s.w;
    }
};

int V, E, A, B, C;
int parent[MAX];

int find(int u) {
    if(parent[u] == u) return u;
    else return parent[u] = find(parent[u]);
}

void merge(int u, int v) {
    u = find(u);
    v = find(v);

    if(u == v) return;
    parent[v] = u;
}

void init() {
    for(int i=0; i<MAX; i++){
        parent[i] = i;
    }
}
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    init();
    cin >> V >> E;

    vector<st> edge(V);
    for(int i=0; i<E; i++){
        cin >> A >> B >> C;
        edge.push_back({A, B, C});
    }

    sort(edge.begin(), edge.end());

    int sum = 0;
    for(int i=0; i<edge.size(); i++){
        int u = find(edge[i].u);
        int v = find(edge[i].v);
        int w = edge[i].w;

        if(u == v) continue;
        merge(u, v);
        sum += w;
    }

    cout << sum << "\n";
}