// Apurv Parekh
// 13th July 2018

#include <bits/stdc++.h>

using namespace std;

const int maxx = 100001;

vector<vector<int>> g(maxx,vector<int>());
int dfsLow[maxx],dfsNum[maxx],visited[maxx];
unordered_map<int,int> toDAG;
int incomingTODag[maxx];

int counter = 0;
int ans;
int n,m;

stack<int> st;
int dagNode;

void dfs(int u){
    dfsLow[u]=dfsNum[u]= counter++;
    visited[u] = 1;
    st.push(u);
    for(auto v:g[u]){
        if(dfsNum[v] == -1) dfs(v);
        if(visited[v] == 1)
            dfsLow[u] = min(dfsLow[u],dfsLow[v]);
    }
    if(dfsLow[u] == dfsNum[u]){
        while(1){
            int v = st.top();
            st.pop();
            toDAG[v] = dagNode;
            visited[v] = 0;
            if(v == u) break;
        }
        dagNode++;
    }
}

void init() {
    fill(dfsLow,dfsLow+n,0);
    fill(dfsNum,dfsNum+n,-1);
    fill(visited,visited+n,0);
    toDAG.clear();
    for(int i=1;i<n;i++) g[i].clear();
    counter = 0;
    dagNode = 1;
}

int main(){
    int tc;
    scanf("%d",&tc);
    while(tc--){
        scanf("%d%d",&n,&m);
        n=n+1;
        init();
        for(int i=0;i<m;i++){
            int u,v;
            scanf("%d%d",&u,&v);
            g[u].push_back(v);
        }

        // generate DAG from SCC
        for(int i=1;i<n;i++)
            if(dfsNum[i] == -1) dfs(i);

        
        fill(incomingTODag+1,incomingTODag+dagNode,1);
        // checking incoming node to dag or not
        for(int u=1;u<n;u++){
            for(auto v:g[u]){
                if(toDAG[u] != toDAG[v]) incomingTODag[toDAG[v]] = 0;
            }
        }
        ans = accumulate(incomingTODag+1,incomingTODag+dagNode,0);
        printf("%d\n",ans);
    }
    return EXIT_SUCCESS;
}

/*
10 10
4 9
6 8
9 5
8 1
3 10
5 9
5 6
8 6
10 7
1 8
*/