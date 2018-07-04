#include <bits/stdc++.h>
using namespace std;

const int MAX = 11;
const int INF = 1000000;

struct B{
    int x,y;
};

vector<B> v(11);
int max_x, max_y;
int n;

int memo[MAX][1 << MAX];

int dist(B a,B b){
    return abs(a.x - b.x) + abs (a.y - b.y);
}

int dp(int curr,int mask){
    if(mask == (1<<n)-1) return dist(v[curr],v[0]);
    int &ref = memo[curr][mask];
    if(ref!=0) return ref;
    int minimum = numeric_limits<int> :: max();
    for(int i=0;i<n;i++){
        if(mask & (1<< i)) continue;
        minimum = min(minimum,dist(v[curr],v[i])+dp(i,mask | (1<<i)));
    }
    return ref = minimum;
}

int main() {
    int tc;
    scanf("%d",&tc);
    while (tc--) {
        scanf("%d%d",&max_x,&max_y);
        scanf("%d%d",&v[0].x,&v[0].y);
        scanf("%d",&n);
        n++;
        for (int i = 1; i < n; i++) scanf("%d%d",&v[i].x,&v[i].y);
        fill(&memo[0][0], &memo[MAX][0], 0);
        printf("The shortest path has length %d\n", dp(0, 1));
    }
}