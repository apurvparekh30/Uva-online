// Apurv Parekh
// 29th July

#include <algorithm>
#include <cstdio>
#include <queue>
#include <unordered_map>

using namespace std;

const int maxx=105;
const int INF=1e9;

int m,w,n;
int s=1,t;
vector<vector<int>> g(maxx,vector<int>());
int res[maxx][maxx];
unordered_map <int,int> mp;
int f,mf;
bool visited[maxx];
int p[maxx];


void augment(int v,int minEdge){
    if(v==s){
        f=minEdge;
        return;
    }
    else if(p[v]!=-1){
        augment(p[v],min(minEdge,res[p[v]][v]));
        res[p[v]][v]-=f;
        res[v][p[v]]+=f;
    }
}

int main(){
    while(scanf("%d%d",&m,&w),(m||w)){
        t=m;
        n=t+m-2;
        for(int i=1;i<=n;i++) g[i].clear();
        mp.clear();
        mp.insert(make_pair(1,1));
        mp.insert(make_pair(t,t));
        fill(&res[0][0],&res[n+1][0],0);
        int index=t+1;
        for(int i=0;i<m-2;i++){
            int u,v;
            scanf("%d%d",&u,&v);
            mp[u]=index;
            g[u].push_back(index);
            g[index].push_back(u);
            //  res[index][u]=v;
            res[u][index]=v;
            index++;
        }
        while(w--){
            int u,v,d;
            scanf("%d%d%d",&u,&v,&d);
            g[mp[u]].push_back(v);
            g[v].push_back(mp[u]);
            g[mp[v]].push_back(u);
            g[u].push_back(mp[v]);
            res[mp[u]][v]=d;
            res[mp[v]][u]=d;    
        }
        mf=0;
        while(1){
            f=0;
            fill(visited,visited+n+1,false);
            fill(p,p+n+1,-1);
            queue<int> q;
            q.push(s);
            visited[s]=true;
            while(!q.empty()){
                int u=q.front();q.pop();
                if(u==t) break;
                for(int v:g[u]){
                    if(visited[v]) continue;
                    if(res[u][v]==0) continue;
                    visited[v]=true;
                    q.push(v);
                    p[v]=u;
                }
            }
            augment(t,INF);
            if(f==0) break;
            mf+=f;
        }   
        printf("%d\n",mf);
    }
    return 0;
}