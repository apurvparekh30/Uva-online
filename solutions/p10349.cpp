// Apurv parekh
// 9th Aug

#include <algorithm>
#include <cstdio>
#include <vector>

using namespace std;

const int maxx = 41;

char g[maxx][maxx];
vector<vector<int>> adj(500,vector<int>());
int r,c;

int dr[]={1,0,-1,0};
int dc[]={0,-1,0,1};

vector<int> left;
int match[500];
bool visited[500];
int cnt;

int Aug(int u){
    if(visited[u]) return 0;
    visited[u]=true;
    for(int v:adj[u]){
        if(match[v]==-1 || Aug(match[v])){
            match[v]=u;
            return 1;
        }
    }
    return 0;
}

int main(){
    int tc;
    scanf("%d",&tc);
    while(tc--){
        //fill(&g[0][0],&g[maxx][0],'');
        left.clear();
        fill(match,match+500,-1);
        for(int i=0;i<500;i++) adj[i].clear();
        cnt=0;
        scanf("%d%d",&r,&c);
        for(int i=0;i<r;i++){
            scanf("% ");
            for(int j=0;j<c;j++){
                scanf("%c",&g[i][j]);
                if(g[i][j]=='*')
                    cnt++;
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(g[i][j]=='o') continue;
                int no = i + j;
                if(no%2) continue;
                int index = i*c+j;
                left.push_back(index);
                for(int k=0;k<4;k++){
                    int ni=i+dr[k]; int nj=j+dc[k];
                    if(ni<0||ni>=r||nj<0||nj>=c) continue;
                    int nindex=ni*c+nj;
                    if(g[ni][nj]=='*'){
                        adj[index].push_back(nindex);
                    }
                }
            }
        }
        int MCBM=0;
        for(int i=0;i<left.size();i++){
            fill(visited,visited+500,false);
            MCBM+=Aug(left[i]);
        }
        printf("%d\n",cnt-MCBM);
    }
    return 0;
}