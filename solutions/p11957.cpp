// Apurv Parekh
// 31th July 2018

#include <algorithm>
#include <cstdio>

using namespace std;

const int mod = 1e6 + 7;
const int maxx = 100;

char b[maxx][maxx];
int memo[maxx][maxx];

int dx[]={-1,1};
int dy[]={-1,-1};

int n;

int dp(int x,int y){
    if(y==0){
        if(b[y][x]=='B') return 0;
        return 1;
    }
        
    int &ref=memo[x][y];
    if(ref) return ref;
    for(int i=0;i<2;i++){
        int nx=x; int ny=y;
        bool flag=true;
        nx=nx+dx[i];
        ny=ny+dy[i];
        if(nx<0||nx>=n||ny<0||ny>=n){
            continue;
        
        if(b[ny][nx]=='B'){
            nx=nx+dx[i];
            ny=ny+dy[i];
        }
        if(nx<0||nx>=n||ny<0||ny>=n){
            continue;
        } 
        if(b[ny][nx]=='B') continue;
        /* while(1){
            nx=nx+dx[i];
            ny=ny+dy[i];
            if(nx<0||nx>=n||ny<0||ny>=n){
                flag=false;
                break;
            }
            if(b[nx][ny]!='B') break;
        } 
        if(flag) */
        ref=(ref+(dp(nx,ny))%mod)%mod;
    }
    return ref%mod;
}

int main(){
    int tc;
    scanf("%d",&tc);
    for(int t=1;t<=tc;t++){
        scanf("%d",&n);
        fill(&memo[0][0],&memo[n][0],0);
        int x,y;
        for(int i=0;i<n;i++){
            scanf("% ");
            for(int j=0;j<n;j++){
                scanf("%c",&b[i][j]);
                if(b[i][j]=='W'){
                    x=j;
                    y=i;
                }
            }
        }
        printf("Case %d: %d\n",t,dp(x,y));
    }
    return 0;
}