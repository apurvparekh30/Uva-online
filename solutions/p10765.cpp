// Apurv Parekh
// 12th July

#include <bits/stdc++.h>
using namespace std;

const int maxx = 10000;
const int unvisited = -1;

struct station{
    int no=-1;
    int p=-1;
};

vector<vector<int>> g(maxx,vector<int> ());
int n,m;
int counter;
int dfs_low[maxx],dfs_num[maxx],dfs_parent[maxx];
vector<station> st;
int p[maxx];

bool compare(station a, station b){
    if(a.p == b.p){
        return a.no < b.no;
    }
    return a.p>b.p;
}

void dfs(int u){
    dfs_num[u] = dfs_low[u] = counter++;
    for(auto v:g[u]){
        if(dfs_num[v]==-1){
            dfs_parent[v] = u;
            dfs(v);
            if(dfs_num[u] <= dfs_low[v]) p[u]++;
            dfs_low[u] = min(dfs_low[u],dfs_low[v]);
        } 
        else if(dfs_parent[u] != v ){
            dfs_low[u] = min(dfs_low[u],dfs_num[v]);
        }
    }
}

int main(){
    while(scanf("%d%d",&n,&m), (n||m)){
        counter = 0;
        st.clear();
        memset(p,0,sizeof(p));
        memset(dfs_low,-1,sizeof(dfs_low));
        memset(dfs_num,-1,sizeof(dfs_num));
        memset(dfs_parent,-1,sizeof(dfs_parent));
        fill(&p[0],&p[n],1);
        for(int i=0;i<n;i++) g[i].clear();
        int u,v;
        while(scanf("%d%d",&u,&v), (u!=-1 && v!=-1)){
            g[u].push_back(v);
            g[v].push_back(u);
        }
        for(int i=0;i<n;i++)
            if(dfs_num[i] == -1){
                p[i] = 0;
                dfs(i);
            } 
        
        for(int i=0;i<n;i++){
            station s;
            s.no = i;
            s.p = p[i];
            st.push_back(s);
        } 
        
        sort(st.begin(),st.begin()+n,compare);
        for(int i=0;i<m;i++){
            printf("%d %d\n",st[i].no, st[i].p);
        }
        printf("\n");
    }
    return 0;
}