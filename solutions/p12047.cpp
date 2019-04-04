// Apurv Parekh
// 20th July

#include <algorithm>
#include <cstdio>
#include <queue>

using namespace std;


struct edge{
    int v,c;
    edge(){}
    edge(int a,int b){
        v=a; c=b;
    }
    bool operator <(const edge &b) const{
        this->c>b.c;
    }
};
int n,m,s,t,p;
vector<vector<edge>> g(10001,vector<edge>());
vector<vector<edge>> back(10001,vector<edge>());
int fDist[10001],bDist[10001];
void init(){
    for(int i=1;i<=n;i++){
        g[i].clear();
        back[i].clear();
    } 
    fill(fDist,fDist+n+1,1e9);
    fill(bDist,bDist+n+1,1e9);
}
void dijkstra(int s,int *dist,vector<vector<edge>>& g){
    priority_queue<edge> pq;
    pq.push(edge(s,0));
    dist[s]=0;
    while(!pq.empty()){
        edge curr=pq.top();pq.pop();
        int u=curr.v; int uc=curr.c;
        if(dist[u]<uc) continue;
        for(edge e:g[u]){
            int v=e.v; int vc=e.c;
            if(dist[v]>dist[u]+vc){
                dist[v]=dist[u]+vc;
                pq.push(edge(v,dist[v]));
            }
        }
    }
}
int main() {
    int tc;
    scanf("%d",&tc);
    while(tc--){
        scanf("%d%d%d%d%d",&n,&m,&s,&t,&p);
        init();
        while(m--){
            int u,v,c;
            scanf("%d%d%d",&u,&v,&c);
            g[u].push_back(edge(v,c));
            back[v].push_back(edge(u,c));
        }
        dijkstra(s,fDist,g);
        if(fDist[t]>p || fDist[t]==1e9){
            printf("-1\n");
            continue;
        }
        dijkstra(t,bDist,back);
        int ans=-1;
        for(int u=1;u<=n;u++){
            for(edge v:g[u]){
                int next=v.v;
                int c=v.c;
                int total=c+fDist[u]+bDist[next];
                if(total<=p) ans = max(ans,c);
            }
        }
        printf("%d\n",ans);
    }
    return 0;
}