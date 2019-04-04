// Apurv Parekh
// 16th July 2018

#include <algorithm>
#include <vector>
#include <cstdio>

using namespace std;

struct Edge {
    int u,v,w;
    bool operator <(const Edge& b) const{
        return w<b.w;
    }
};

int n,m,q;
int p[101],r[101];
int visited[101];
vector<vector<pair<int,int>>> g(101,vector<pair<int,int>>());
Edge e[1001];

void init(){
    fill(r,r+n,0);
    for(int i=1;i<=n;i++) g[i].clear();
    for(int i=1;i<n;i++) p[i]=i;
}

int findSet(int i){
    return (i==p[i]) ? i:(p[i]=findSet(p[i]));
}
int dfs(int u,int v,int mx){
    visited[u] = 1;
    if(u == v) return mx;
    for(auto i:g[u]){
        if(visited[i.first]) continue;
        int tmp =dfs(i.first,v,max(mx,i.second));
        if(tmp) return tmp;
    }
    return 0;
}

int main(){
    int tc=0;
    int flag = false;
    while(scanf("%d%d%d",&n,&m,&q), (n||m||q)){
        n=n+1;
        tc++;
        init();
        for(int i=0;i<m;i++){
            Edge tmp;
            scanf("%d%d%d",&tmp.u,&tmp.v,&tmp.w);
            e[i]=tmp;
        }

        sort(e,e+m);
        for(int i=0;i<m;i++){
            int x = findSet(e[i].u);
            int y = findSet(e[i].v);
            if(x!=y){
                if(r[x]>r[y]) p[y]=x;
                else{
                    p[x]=y;
                    if(r[x]==r[y]) r[y]++;
                }
                g[e[i].u].push_back(make_pair(e[i].v,e[i].w));
                g[e[i].v].push_back(make_pair(e[i].u,e[i].w));
            }
        }
        if(flag) printf("\n"); flag = true;
        printf("Case #%d\n",tc);
        while(q--){
            int u,v;
            scanf("%d%d",&u,&v);
            if(findSet(u)!=findSet(v)){
                printf("no path\n");
                continue;
            } 
            fill(visited,visited+n,0);
            printf("%d\n",dfs(u,v,0));
            
        }
    }
    return EXIT_SUCCESS;
}