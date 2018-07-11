// Apurv Parekh
// July 10 2018

#include <bits/stdc++.h>

using namespace std;

int v;

int color[301];

vector<vector<int>> g(301,vector<int>());

bool dfs(int u,int c){
    color[u] = c;
    for(auto i:g[u]){
        if(color[i] == color[u]) return false;
        if(color[i] == 0) {
            if(dfs(i,-color[u])==false) return false;
        }
    }
    return true;
}

int main() {
    while(scanf("%d",&v),v){
        int x,y;
        for(int i=1;i<=v;i++) g[i].clear();
        memset(color,0,sizeof(color));
        while(scanf("%d%d",&x,&y), (x||y)){
            g[x].push_back(y);
            g[y].push_back(x);
        }
        if(dfs(1,1)){
            printf("YES\n");
        }
        else{
            printf("NO\n");
        }
    }
    return 0;
}