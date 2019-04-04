// Apurv Parekh
// 12th July 2018

#include <bits/stdc++.h>
using namespace std;

int const maxx = 100001;

int servers;

vector<vector<int>> g (maxx,vector<int>());

int dfs_low[maxx];
int dfs_num[maxx];
int parent[maxx];
int counter;
vector<pair<int,int>> bridges;

void dfs(int u){
    dfs_low[u] = dfs_num[u] = counter++;
    for(auto v:g[u]){
        if(dfs_num[v]== -1){
            parent[v] = u;
            dfs(v);
            if(dfs_num[u] < dfs_low[v]){
                bridges.push_back(make_pair(min(u,v),max(u,v)));
            }
            dfs_low[u] = min(dfs_low[u],dfs_low[v]);
        }
        else if(parent[u] != v){
            dfs_low[u] = min(dfs_low[u],dfs_num[v]);
        }
    }
}

int main(){
    while(scanf("%d",&servers)==1){
        memset(dfs_low,0,sizeof(dfs_low));
        memset(dfs_num,-1,sizeof(dfs_num));
        memset(parent,-1,sizeof(parent));
        bridges.clear();
        counter=0;
        for(int i=0;i<servers;i++) g[i].clear();
        for(int i=0;i<servers;i++){
            int u,n,c,v;
            scanf("%d",&u);
            scanf("% ");
            scanf("%c%c%c",&c,&n,&c);
            for(int j=0;j<n-'0';j++){
                scanf("%d",&v);
                g[u].push_back(v);
            }   
        }
        for(int i=0;i<servers;i++){
            if(dfs_num[i] == -1){
                dfs(i);
            }
        }
        sort(bridges.begin(),bridges.end());

        printf("%d critical links\n",bridges.size());
        for(auto i: bridges){
            printf("%d - %d\n",i.first,i.second);
        }
        printf("\n");
    }
    return 0;
}