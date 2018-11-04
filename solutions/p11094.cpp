#include <bits/stdc++.h>

using namespace std;

const int maxx = 21;

int m,n;
char land;

string g [maxx];
bool used[maxx][maxx];

int dr[]={1,0,-1,0};
int dc[]={0,1,0,-1};

int dfs(int x,int y){
    if(y<0) y=n-1;
    if(y>=n) y=0;
    if(x<0 || x>=m) return 0;
    if(g[x][y]!=land || used[x][y]) return 0;
   
    used[x][y]=true;
    int tot = 1;
    for(int i=0;i<4;i++)
        tot+=dfs(x+dr[i],y+dc[i]);
    return tot;
}

int main(){
    while(scanf("%d%d",&m,&n)==2){
        memset(used,false,sizeof(used));
        for(int i=0;i<m;i++) {
            scanf("% ");
            getline(cin,g[i]);
        }
        int x,y;
        scanf("%d%d",&x,&y);
        land = g[x][y];
        dfs(x,y);
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans = max(ans,dfs(i,j));
            }
        }
        printf("%d\n",ans);
        scanf("% ");
    }
    return EXIT_SUCCESS;
}