// Apurv Parekh
// 9th Aug 2018

#include <algorithm>
#include <cstdio>
#include <vector>

using namespace std;

const int maxx = 500;

using vi=vector<int>;

int tc,r,c;
vector<vi> adj(maxx,vi());
int g[maxx][maxx];
int match[maxx];
bool v[maxx];

int Aug(int u){
    if(v[u]) return 0;
    v[u]=true;
    for(int v:adj[u]){
        if(match[v]==-1 || Aug(match[v])){
            match[v]=u;
            return 1;
        }
    }   
    return 0;
}

int main(){
    scanf("%d",&tc);
    for(int t=1;t<=tc;t++){
        // init
        for(int i=0;i<maxx;i++) adj[i].clear();
        fill(match,match+maxx,-1);

        //input
        scanf("%d%d",&r,&c);
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                scanf("%d",&g[i][j]);
                if(g[i][j]==1){
                    adj[i].push_back(j);
                }
            }
        }

        int MCBM=0;
        for(int i=0;i<r;i++){
            fill(v,v+maxx,false);
            MCBM+=Aug(i);
        }
        printf("Case %d: ",t);
        printf("a maximum of %d nuts and bolts can be fitted together\n",MCBM);
    }
    return 0;
}