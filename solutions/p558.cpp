// Apurv Parekh

#include <algorithm>
#include <cstdio>
#include <vector>

using namespace std;

struct edge{
    int v,c;
    edge(){}
    edge(int a,int b){
        v=a;c=b;
    }
};
vector<vector<edge>> g(1000,vector<edge>());
int dist[1000];
int n,m;

void init(){
    for(int i=0;i<n;i++) g[i].clear();
    fill(dist,dist+n,1e9);
}
bool bf(){
    for(int i=0;i<n-1;i++){
        for(int u=0;u<n;u++){
            for(edge e:g[u]){
                dist[e.v]=min(dist[e.v],dist[u]+e.c);
            }
        }
    }
    for(int u=0;u<n;u++){
        for(edge e:g[u]){
            if(dist[e.v] > dist[u]+e.c)
                return true;
        }
    }
    return false;
}

int main(){
    int tc;
    scanf("%d",&tc);
    while(tc--){
        scanf("%d%d",&n,&m);
        init();
        while(m--){
            int u,v,c;
            scanf("%d%d%d",&u,&v,&c);
            g[u].push_back(edge(v,c));
        }
        bool ans = bf();
        if(ans){
            printf("possible\n");
        }
        else{
            printf("not possible\n");
        }
    }
    return 0;
}