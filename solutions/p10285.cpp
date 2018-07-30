// Apurv Parekh
// 30th July 2018

#include <algorithm>
#include <cstdio>

using namespace std;

const int maxx = 100;

int dist[maxx][maxx];
int g[maxx][maxx];

int dr[]={-1,0,1,0};
int dc[]={0,1,0,-1};

int r,c;
char name[100];

int dfs(int i,int j){
    int &length=dist[i][j];
    if(length) return length;
    for(int t=0;t<4;t++){
        int nx,ny;
        nx=i+dr[t]; ny=j+dc[t];
        if(nx<0||nx>=r||ny<0||ny>=c) continue;
        if(g[nx][ny] < g[i][j])
            length=max(length,dfs(nx,ny));
    }
    length+=1;
    return length;
}

int main(){
    int tc;
    scanf("%d",&tc);
    
    while(tc--){

        fill(&g[0][0],&g[r][0],0);
        fill(&dist[0][0],&dist[r][0],0);

        //input
        scanf("% ");
        scanf("%s",name);
        scanf("%d%d",&r,&c);
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                scanf("%d",&g[i][j]);
            }
        }

        // algorithm
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                dfs(i,j);
            }
        }

        // output
        int ans=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                ans=max(ans,dist[i][j]);
            }
        }
        printf("%s: %d\n",name,ans);
    }
    return 0;
}