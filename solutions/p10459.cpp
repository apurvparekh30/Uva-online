// Apurv Parekh
// 6th Aug 2018

#include <algorithm>
#include <cstdio>
#include <vector>

using namespace std;

const int maxx = 5005;

vector<vector<int>> g(maxx,vector<int> ());
int n;

int dist[maxx];
int d;
int fs;

void dfs(int u,int p,int len){
    dist[u]=max(dist[u],len);
    if(len>d){
        fs=u;
        d=len;
    }
    for(int v:g[u]){
        if(p==v) continue;
        dfs(v,u,len+1);
    }   
}

int main(){ 
    while(scanf("%d",&n)==1){
        fill(dist,dist+maxx,0);
        for(int i=1;i<=n;i++) g[i].clear();
        for(int i=1;i<=n;i++){
            int ct; scanf("%d",&ct);
            while(ct--){
                int in; scanf("%d",&in);
                g[i].push_back(in);
            }
        }

        d=0;
        dfs(1,-1,0);
        d=0;
        dfs(fs,-1,0);
        d=0;
        dfs(fs,-1,0);

        int best=1e9;
        int worst=0;
        for(int i=1;i<=n;i++){
            best=min(best,dist[i]);
            worst=max(worst,dist[i]);
        }
        printf("Best Roots  :");
        for(int i=1;i<=n;i++){
            if(best == dist[i]) printf(" %d",i);
        }
        printf("\n");
        printf("Worst Roots :");
        for(int i=1;i<=n;i++){
            if(worst == dist[i]) printf(" %d",i);
        }
        printf("\n");
    }
    return 0;
}