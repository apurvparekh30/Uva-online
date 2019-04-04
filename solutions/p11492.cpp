// Apurv Parekh

#include <algorithm>
#include <unordered_map>
#include <queue>
#include <cstdio>
#include <string>
#include <iostream>

using namespace std;

int n;
string o,d;

struct edge{
    string v;
    int w;
    int i;
    edge(){}
    edge(string b,int c,int d){
        v=b; w=c; i=d;
    }
    bool operator< ( const edge &b) const{
        return this->w>b.w;
    }
};

unordered_map<string,int> toIndex;
vector<vector<edge>> g(5001,vector<edge>());

int dist[5001][27];

int index;

void init(){
    index=1;
    toIndex.clear();
    for(int i=0;i<5001;i++) g[i].clear();
    fill(&dist[0][0],&dist[5001][0],1e9);
}

int main(){
    while(scanf("%d",&n), n){
        cin>>o>>d;
        
        init();
        if(toIndex[o]==0) toIndex[o]=index++;
        if(toIndex[d]==0) toIndex[d]=index++;
        for(int i=0;i<n;i++){
            string u,v,w;
            cin>>u>>v>>w;
            if(toIndex[u]==0) toIndex[u]=index++;
            if(toIndex[v]==0) toIndex[v]=index++;
            g[toIndex[u]].push_back(edge(v,w.length(),w[0]-'a'));
            g[toIndex[v]].push_back(edge(u,w.length(),w[0]-'a'));
        }
        
        priority_queue<edge> pq;
        pq.push(edge(o,0,26));
        dist[toIndex[o]][26]=0;
        while(!pq.empty()){
            edge curr=pq.top(); pq.pop();
            string u=curr.v; int uw=curr.w; int ui=curr.i;
            if(dist[toIndex[u]][ui] < uw) continue;
            for(edge e:g[toIndex[u]]){
                string v=e.v;
                int vw=e.w;
                int vi=e.i;
                if(vi == ui) continue;
                if(dist[toIndex[v]][vi] > dist[toIndex[u]][ui]+vw){
                    dist[toIndex[v]][vi]=dist[toIndex[u]][ui]+vw;
                    pq.push(edge(v,dist[toIndex[v]][vi],vi));
                }
            }
        }
        int best=1e9;
        for(int i=0;i<27;i++){
            best=min(best,dist[toIndex[d]][i]);
        }
        if(best==1e9){
            printf("impossivel\n");
        }
        else{
            printf("%d\n",best);
        }
    }
    return 0;
}
