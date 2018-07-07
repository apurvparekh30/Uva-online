#include <bits/stdc++.h>

using namespace std;

const int mx = 101;

int n;
char g[mx][mx];

int dr[]={1,0,-1,0};
int dc[]={0,1,0,-1};

void dfs(int x,int y,char c1){
    if(x<0||x>=n||y>=n||y<0) return;
    if(g[x][y]=='.') return;
    g[x][y]='.';
    for(int i=0;i<4;i++){
        dfs(x+dr[i],y+dc[i],g[x][y]);
    }
}

int main(){
    int T;
    scanf("%d",&T);
    for(int t=1;t<=T;t++){
        scanf("%d",&n);
        for(int i=0;i<n;i++){
            scanf("%s",g[i]);
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(g[i][j]!='@' && g[i][j]!='.'){
                    ans++;
                    dfs(i,j,g[i][j]);
                }
            }
        }
        printf("Case %d: %d\n",t,ans);
    }
    return EXIT_SUCCESS;
}