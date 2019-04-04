// Apurv Parekh
// 13th July 2018

#include <bits/stdc++.h>

using namespace std;

const int maxx  = 2001;

int n,m;
int dfsLow[maxx],dfsNum[maxx],visited[maxx];
int counter = 0;
vector<vector<int>> g(maxx,vector<int>());
stack<int> st;
int scc;

void init(){
    fill(dfsLow,dfsLow+n,0);
    fill(dfsNum,dfsNum+n,-1);
    fill(visited,visited+n,0);
    for(int i=0;i<n;i++)g[i].clear();
    counter = 0;
    scc=0;
}

void dfs(int u){
    dfsLow[u] = dfsNum[u]= counter++;
    visited[u] = 1;
    st.push(u);
    for(auto v:g[u]){
        if(dfsNum[v]==-1) dfs(v);
        if(visited[v]==1)
            dfsLow[u] = min(dfsLow[u],dfsLow[v]);
    }
    if(dfsNum[u] == dfsLow[u]){
        while(1){
            int v = st.top(); st.pop();
            visited[v] = 0;
            if(u == v){
                break;
            }
        }
        scc++;
    }
}

int main() {
    while(scanf("%d%d",&n,&m) , (n||m)){
        n++;
        init();
        while(m--){
            int u,v,p;
            scanf("%d%d%d",&u,&v,&p);
            g[u].push_back(v);
            if(p == 2) g[v].push_back(u);
        }
        for(int i=1;i<n;i++){
            if(dfsNum[i]==-1) dfs(i);
        }
        printf("%d\n",scc==1 ? 1:0);
    }
    return 0;
}