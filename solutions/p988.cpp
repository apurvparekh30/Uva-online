// Apurv Parekh
// 31th July 2018

#include <algorithm>
#include <cstdio>
#include <vector>

using namespace std;

const int maxx = 1e4;
const int INF = 1e9;

int n;
vector<vector<int>> g(maxx,vector<int> ());
int memo[maxx];

int dp(int u){
    int &ref=memo[u];
    if(ref) return ref;
    for(int v:g[u]){
        ref+=dp(v);
    }
    return ref;
}

int main(){
    bool flag=false;
    while(scanf("%d",&n)==1){
        fill(memo,memo+n,0);
        for(int i=0;i<n;i++) g[i].clear();
        for(int i=0;i<n;i++){
            int c; scanf("%d",&c);
            if(c==0) {
                memo[i]=1;
                continue;
            }
            while(c--){
                int v; scanf("%d",&v);
                g[i].push_back(v);
            }
        }
        if(flag) printf("\n"); flag=true;
        printf("%d\n",dp(0));
    }
    return 0;
}