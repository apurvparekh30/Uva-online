// Apurv Parekh
// 13th July 2018

#include <bits/stdc++.h>

const int maxx = 25;

using namespace std;

int n,m;

unordered_map<string,int> toIndex;
unordered_map<int,string> toName;

int dfs_low[26]; int visited[26]; int dfs_num[26];
int counter;
vector<vector<int>>  g(26,vector<int>());
vector<int> s;
void dfs(int u){
    dfs_num[u] = dfs_low[u] = counter++;
    s.push_back(u);
    visited[u] = 1;
    for(int v: g[u]){
        if(dfs_num[v] == -1) dfs(v);
        if(visited[v]) dfs_low[u] = min(dfs_low[u],dfs_low[v]);
    }
    if(dfs_low[u] == dfs_num[u]){
        while(1){
            int t = s.back();
            s.pop_back();
            visited[t] = 0;
            if(t == u){
                printf("%s\n",toName[u].c_str());
                break;
            }
            printf("%s, ",toName[t].c_str());
        }
    }
    
}

int main(){
    int tc=0;
    bool blank = false;
    while(scanf("%d%d",&n,&m), (n&&m)){
        toName.clear();
        toIndex.clear();
        tc++;
        int index = 0;
        counter = 0;
        fill(&dfs_num[0],&dfs_num[n+1],-1);
        fill(&dfs_low[0],&dfs_low[n+1],0);
        fill(&visited[0],&visited[n+1],0);
        s.clear();
        for(int i=0;i<=n;i++) g[i].clear();
        for(int i=0;i<m;i++){
            char u[26],v[26];
            scanf("%s %s",u,v);
            if(toIndex[u] == 0){
                toIndex[u] = ++index;
                toName[index] = u;
            }
            if(toIndex[v] == 0){
                toIndex[v] = ++index;
                toName[index] = v;
            }
            g[toIndex[u]].push_back(toIndex[v]);
        }
        if(blank) printf("\n");  blank = true;
        printf("Calling circles for data set %d:\n",tc);
        for(int i=1;i<=n;i++){
            if(dfs_num[i] == -1){
                dfs(i);
            }
        }
        
    }
    return 0;
}