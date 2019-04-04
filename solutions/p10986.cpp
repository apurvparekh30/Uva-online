// Apurv Parekh
// 19th July

#include <algorithm>
#include <queue>
#include <cstdio>

using namespace std;

struct vertex{
    int u,w;
    vertex(int a,int b){
        u=a; w=b;
    }
    bool operator< (const vertex &b) const{
        return this->w>b.w;
    }
};
vector<vector<vertex>> g(20000,vector<vertex>());
int d[20000];

int n,m,s,t;

void init(){
    for(int i=0;i<n;i++) g[i].clear();
    fill(d,d+n,1e9);
}

int main(){
    int tc;
    scanf("%d",&tc);
    for(int cs=1;cs<=tc;cs++){
        scanf("%d%d%d%d",&n,&m,&s,&t);
        init();
        while(m--){
            int u,v,w;
            scanf("%d%d%d",&u,&v,&w);
            g[u].push_back(vertex(v,w));
            g[v].push_back(vertex(u,w));
        }
        priority_queue<vertex> pq;
        pq.push(vertex(s,0));
        d[s]=0;
        while(!pq.empty()){
            vertex curr=pq.top();pq.pop();
            int u=curr.u; int w=curr.w;
            if(d[u]<w) continue;
            for(vertex next:g[u]){
                if(d[next.u]>d[u]+next.w){
                    d[next.u]=d[u]+next.w;
                    pq.push(vertex(next.u,d[next.u]));
                }
            }
        }
        printf("Case #%d: ",cs);
        if(d[t] == 1e9) printf("unreachable\n");
        else printf("%d\n",d[t]);
    }
    return 0;
}