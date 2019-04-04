#include <algorithm>
#include <queue>
#include <cstdio>

using namespace std;

struct edge{
    int v,c;
    edge(int a,int c){
        this->v=a;
        this->c=c;
    }
    bool operator< (const edge&b) const{
        return this->c > b.c;
    }
};


int d[101];
vector<vector<edge>> g(101,vector<edge>());
int n,m,u,t;
void init(){
    for(int i=1;i<=n;i++) g[i].clear();
    fill(d,d+(n+1),1e9);
}

int main(){
    int tc;
    scanf("%d",&tc);
    bool flag=false;
    while(tc--){
        scanf("%d%d%d",&n,&u,&t);
        init();
        scanf("%d",&m);
        while(m--){
            int u,v,w;
            scanf("%d%d%d",&u,&v,&w);
            g[v].push_back(edge(u,w));
        }
        priority_queue<edge> pq;
        pq.push(edge(u,0));
        d[u]=0;
        while(!pq.empty()){
            edge curr=pq.top();pq.pop();
            int v=curr.v; int w=curr.c;
            if(d[v] < w) continue;
            for(edge i:g[v]){
                if(d[v]+i.c < d[i.v]){
                    d[i.v]=d[v]+i.c;
                    pq.push(edge(i.v,d[i.v]));
                }
            }
        }
        int count=0;
        for(int i=1;i<=n;i++){
            if(d[i]<=t) count++;
        }
        if(flag) printf("\n"); flag=true;
        printf("%d\n",count);
    }
    return 0;
}