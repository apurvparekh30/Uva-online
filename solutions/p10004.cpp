#include <bits/stdc++.h>

using namespace std;

int n,l;


vector<vector<int>> g(200,vector<int>());

int color[200];

bool dfs(int u,int c){
    color[u] = c;
    for(auto i:g[u]){
        if(color[u] == color[i]){
            return false;
        }
        if(color[i]==0){
            if(!dfs(i,-color[u])){
                return false;
            }
        }
    }
    return true;
}

int main(){
    while(scanf("%d",&n), n){
        memset(color,0,sizeof(color));
        for(int i=0;i<n;i++) g[i].clear();
        scanf("%d",&l);
        while(l--){
            int u,v;
            scanf("%d%d",&u,&v);
            g[u].push_back(v);
            g[v].push_back(u);
        }
        bool ans = dfs(0,1);
        if(ans){
            printf("BICOLORABLE.\n");
        }
        else {
            printf("NOT BICOLORABLE.\n");
        }
    }
    return 0;
}