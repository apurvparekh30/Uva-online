// Apurv Parekh
// 23th July 2018


#include <bits/stdc++.h>


using namespace std;

int n,r,q;
struct edge{
    int v,c;
    edge(){}
    edge(int a,int b){
        v=a; c=b;
    }
};
vector<vector<edge>> g(201,vector<edge>());
int dist[201];
int busy[201];


void init(){
    for(int i=1;i<=n;i++) g[i].clear();
    fill(dist,dist+n+1,INT_MAX);
}

void bf(){
    for(int i=0;i<n-1;i++){
        for(int u=1;u<=n;u++){
            if(dist[u]==INT_MAX) continue; 
            for(edge e:g[u]){
                    dist[e.v]=min(dist[e.v],dist[u]+e.c);
            }
        }
    }
    for(int i=0;i<n-1;i++){
        for(int u=1;u<=n;u++){
            for(edge e:g[u]){
                if(dist[u] == INT_MAX) continue;
                if(dist[e.v]>dist[u]+e.c)
                    dist[e.v]=-1e9;
            }
        }
    }
    
}
int main(){
    int tc=0;
    while(scanf("%d",&n)==1){
        tc++;
        init();
        for(int i=1;i<=n;i++)
            scanf("%d",busy+i);
        scanf("%d",&r);
        while(r--){
            int u,v,c;
            scanf("%d%d",&u,&v);
            int temp=busy[v]-busy[u];
            c=temp*temp*temp;
            g[u].push_back(edge(v,c));
        }  
        dist[1]=0;
        bf(); 
        printf("Set #%d\n",tc);
        scanf("%d",&q);
        while(q--){
            int v;
            scanf("%d",&v);
            if(dist[v]==INT_MAX || dist[v]<3)
                printf("?\n");
            else
                printf("%d\n",dist[v]);
        }
    }
    return 0;
}