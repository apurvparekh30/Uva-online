// Apurv Parekh
// 27th July

#include <algorithm>
#include <cstdio>
#include <queue>

using namespace std;

const int maxx = 101;
const int inf = 1e9;

int n,s,t,c,f,mf;



vector<vector<int>> g(maxx,vector<int>());
int res[maxx][maxx];
bool visited[maxx];
int p[maxx];

void augment( int v, int minEdge){
    if(v==s) {
        f=minEdge;
        return;
    }
    else if(p[v]!=-1){
        augment(p[v],min(minEdge,res[p[v]][v]));
        res[p[v]][v]-=f;
        res[v][p[v]]+=f;
    }
}

int main() {

    int tc=0;

    while(scanf("%d",&n),n){
        tc++;
        mf=0;
        for(int i=1;i<maxx;i++) g[i].clear();
        fill(&res[0][0],&res[maxx][0],0);
        scanf("%d%d%d",&s,&t,&c);
        while(c--){
            int u,v,w;
            scanf("%d%d%d",&u,&v,&w);
            g[u].push_back(v);
            g[v].push_back(u);
            res[u][v]+=w;
            res[v][u]+=w;
        }
        while(1){
            f=0;
            queue<int> q;
            fill(visited,visited+maxx,false);
            fill(p,p+maxx,-1);
            q.push(s);
            visited[s]=true;
            while(!q.empty()){
                int u=q.front(); q.pop();
                if(u==t) break;
                for(int v:g[u]){
                    if(visited[v]) continue;
                    if(res[u][v]==0) continue;
                    visited[v]=true;
                    p[v]=u;
                    q.push(v);
                }
            }
            augment(t,inf);
            if(f==0) break;
            mf+=f;
        }
        printf("Network %d\n",tc);
        printf("The bandwidth is %d.\n\n",mf);
        
    }
    return 0;
}