// Apurv Parekh
// 11th July 2018

#include <bits/stdc++.h>

using namespace std;

int n;

int dfs_num[100];
int dfs_low[100];
bool ar[100];
int parent[100];
int rootchildren;
int dfsroot;

vector<vector<int>> g(100,vector<int>());

int counter = 0;

void dfs(int u){
    dfs_low[u] = dfs_num[u] = counter++;
    for(auto i: g[u]){
        if(dfs_num[i]==-1){
            parent[i] = u;
            if(u == dfsroot) rootchildren++;
            dfs(i);
            if(dfs_low[i] >= dfs_num[u]){
                ar[u]=true;
            }
            dfs_low[u] = min(dfs_low[u],dfs_low[i]);
         }
         else{
             if(parent[u]!=i){
                 dfs_low[u] = min(dfs_low[u],dfs_num[i]);
             }
         }
    }
}

int main(){
    while(scanf("%d",&n),n){
        memset(dfs_num,-1,sizeof(dfs_num));
        memset(ar,false,sizeof(ar));
        memset(parent,0,sizeof(parent));
        for(int i=1;i<=n;i++) g[i].clear();
        while(1){
            string line;
            int place;
            scanf("% ");
            getline(cin,line);
            stringstream ss(line);
            ss>>place;
            if(place == 0) break;
            int to;
            while(ss>>to){
                g[place].push_back(to);
                g[to].push_back(place);
            }
        }
        for(int i=1;i<=n;i++){
            if(dfs_num[i]==-1){
                dfsroot = i;
                rootchildren = 0;
                counter = 0;
                dfs(i);
                ar[i] = (rootchildren > 1);
            }
        }
        int count=0;
        for(int i=1;i<=n;i++){
            if(ar[i]){
                count++;
            }
        }
        printf("%d\n",count);
    }
    return 0;
}