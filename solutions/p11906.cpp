#include <bits/stdc++.h>

using namespace std;

const int maxx = 100;

int grid[maxx][maxx];
bool v[maxx][maxx];
int r,c,m,n,w;

int incr[] = {1,-1};

void dfs(int x,int y){
    if(x<0 || x>=r || y<0 || y>=c || (grid[x][y]==-1 && (x||y))) return;
    grid[x][y]++;
    if(v[x][y]) return;
    v[x][y] = true;
    int nx,ny;
    for(int i=0;i<2;i++){
        for(int j=0;j<2;j++){
            dfs(x+incr[i]*m,y+incr[j]*n);
            dfs(x+incr[i]*n,y+incr[j]*m);
        }
    }
}   

int main(){
    int tc;
    scanf("%d",&tc);
    for(int t=1;t<=tc;t++){
        scanf("%d%d%d%d",&r,&c,&m,&n);
        scanf("%d",&w);
        memset(grid,0,sizeof(grid));
        memset(v,false,sizeof(v));
        while(w--){
            int i,j;
            scanf("%d%d",&i,&j);
            grid[i][j] = -1;
        }
        grid[0][0] = -1; //adjustment for recursion
        dfs(0,0);
        int even=0,odd=0;
        // count even odd code.
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(m==0 || n==0 || m==n){
                    grid[i][j]/=2;
                }
                if(grid[i][j]>0 || (!i && !j)){
                    if(grid[i][j]%2==0)
                        even++;
                    else odd++;
                }
            }
        }
        printf("Case %d: %d %d\n",t,even,odd);
    }
    return 0;
}