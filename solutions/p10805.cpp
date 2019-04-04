// Apurv Parekh
// 6th Aug 2018


#include <algorithm>
#include <cstdio>
#include <queue>

using namespace std;

const int maxx = 30;

vector<vector<int>> g(maxx,vector<int>());
int tc;
int n,m;

int d,fs;
bool vi[maxx];

int dist[maxx];

vector<vector<int>> bfstree(maxx,vector<int>());

void dfs(int u,int p,int len){
    if(d<len){
        d=len;
        fs=u;
    }
    for(int v:bfstree[u]){
        if(v==p) continue;
        dfs(v,u,len+1);
    }
}


int bfs(int u){
    vi[u]=true;
    queue<int> q;
    q.push(u);
    while(!q.empty()){
        int u=q.front(); q.pop();
        for(int v:g[u]){
            if(vi[v]) continue;
            vi[v]=true;
            bfstree[u].push_back(v);
            bfstree[v].push_back(u);
            q.push(v);
        }
    }
    d=0;
    dfs(u,-1,0);
    d=0;
    dfs(fs,-1,0);
    return d;
}

int bfs2(int a,int b){
    vi[a]=true; vi[b]=true;
    queue<int> q;
    bfstree[a].push_back(b);
    bfstree[b].push_back(a);
    q.push(a); q.push(b);
    while(!q.empty()){
        int u=q.front(); q.pop();
        for(int v:g[u]){
            if(vi[v]) continue;
            vi[v]=true;
            bfstree[u].push_back(v);
            bfstree[v].push_back(u);
            q.push(v);
        }
    }
    d=0;
    dfs(a,-1,0);
    d=0;
    dfs(fs,-1,0);
    return d;
}


/* int bfs2(int u){
    int dummy=n;
    vi[u]=true;
    queue<int> q;
    q.push(u);
    while(!q.empty()){
        int u=q.front(); q.pop();
        bool flag=false;
        for(int v:g[u]){
            if(vi[v]) continue;
            vi[v]=true;
            bfstree[dummy].push_back(v);
            bfstree[v].push_back(dummy);
            flag=true;
            q.push(v);
        }
        if(flag){
            bfstree[u].push_back(dummy);
            bfstree[dummy].push_back(u);
        } 
        dummy++;
    }
    d=0;
    dfs(u,-1,0);
    d=0;
    dfs(fs,-1,0);
    return d/2;
} */


int main(){
    int tc;
    scanf("%d",&tc);
    for(int t=1;t<=tc;t++){
        for(int i=0;i<maxx;i++) g[i].clear();
        scanf("%d%d",&n,&m);
        while(m--){
            int u,v;
            scanf("%d%d",&u,&v);
            g[u].push_back(v);
            g[v].push_back(u);
        }
        int ans=1e9;
        for(int u=0;u<n;u++){
            for(int i=0;i<maxx;i++) bfstree[i].clear();
            fill(vi,vi+maxx,false);
            ans=min(ans,bfs(u));
        }
        for(int u=0;u<n;u++){
            for(int v:g[u]){
                if(v<u) continue;
                for(int i=0;i<maxx;i++) bfstree[i].clear();
                fill(vi,vi+maxx,false);
                ans=min(ans,bfs2(u,v));
            }
            
        } 
        printf("Case #%d:\n",t);
        printf("%d\n\n",ans);
    }
    return 0;
}