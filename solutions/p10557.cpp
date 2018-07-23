// Apurv Parekh
// 23th July 2018

#include <algorithm>
#include <cstdio>
#include <vector>

using namespace std;

struct edge {
    int u,c;
    edge(){}
    edge(int a,int b){
        u=a;
        c=b;
    }
};

int n;
int dist[101];
bool cycle[101];
bool v[101];
vector<vector<edge>> g(101,vector<edge>());

void init(){
    for(int i=1;i<=n;i++) g[i].clear();
    fill(dist,dist+n+1,-1e9);
    fill(cycle,cycle+n+1,false);
    fill(v,v+n+1,false);
}

bool dfs(int u){
    if(u==n) return true;
    v[u]=true;
    bool res=false;;
    for(edge e:g[u]){
        if(v[e.u]) continue;
        res|=dfs(e.u);
    }
    return res;
}

bool bf(){
    for(int i=1;i<=n;i++){
        for(int u=1;u<=n;u++){
            if(dist[u]<=0) continue;
            for(edge e:g[u]){
                if(i==n){       //check on nth loop for positive cycle
                    if(dist[e.u]<dist[u]+e.c){
                        cycle[u]=true;
                    }   
                }
                else{
                    dist[e.u]=max(dist[e.u],dist[u]+e.c);
                }
            }
        }
    }

    if(dist[n]>0)
        return true;


    for(int i=1;i<=n;i++){
        if(dist[i]<=0) continue;
        if(cycle[i]){
            if(dfs(i)){
                return true;
            }
        }
    }
    return false;
}

int main(){
    while(scanf("%d",&n), n!=-1){
        init();
        for(int i=1;i<=n;i++){
            int c,conn;
            scanf("%d%d",&c,&conn);
            while(conn--){
                int v;
                scanf("%d",&v);
                g[i].push_back(edge(v,c));
            }
        }
        dist[1]=100;
        if(bf()){
            printf("winnable\n");
        }
        else{
            printf("hopeless\n");
        }
    }
    return 0;
}