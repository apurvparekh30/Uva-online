// Apurv Parekh
// July 11 2018

#include <bits/stdc++.h>

using namespace std;

int e;

int parent[10];
bool ar[10];
vector<vector<int>> g(10,vector<int>());
int dfs_low[10],dfs_num[10];
int counter = 0;
void dfs(int u){
    dfs_low[u] = dfs_num[u] = counter++;
    for(auto i:g[u]){
        if(dfs_num[i]==-1){
            parent[i] = u;
            dfs(i);
            if(dfs_low[i] >= dfs_num[u]){
                ar[u] = true;
            }
            dfs_low[u]=min(dfs_low[u],dfs_low[i]);
        }
        else if(parent[u]!=i){
            dfs_low[u] = min(dfs_low[u],dfs_num[i]);
        }
    }
}

int main(){
    scanf("%d",&e);
    memset(dfs_num,-1,sizeof(dfs_num));
    for(int i=0;i<e;i++){
        int u,v;
        scanf("%d%d",&u,&v);
        g[u].push_back(v);
        g[v].push_back(u);
    }
    dfs(1);
    for(int i=0;i<10;i++){
        if(ar[i]) printf("%d ",i);
    }
    printf("\n");
    return EXIT_SUCCESS;
}