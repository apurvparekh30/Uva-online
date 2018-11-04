// Apurv Parekh
// 4th Aug 2018

#include <algorithm>
#include <cstdio>
#include <queue>

using namespace std;

const int MAX = 10;
const int mod = 20437;

struct cell{
    int x,y,w;
    char fm;
    cell(){}
    cell(int x,int y,int w,char fm):x(x),y(y),w(w),fm(fm){}
};
int n;
char grid[MAX][MAX];
bool visited[11][11][100];
cell s;

char last;

int dp[11][11][100][130];
int dr[]={1,0,-1,0};
int dc[]={0,-1,0,1};
int tc=0;

void bfs(){
    queue<cell> q;
    q.push(s);
    while(!q.empty()){
        cell u=q.front(); q.pop();
        int x=u.x; int y=u.y; int w=u.w; char fm=u.fm;
        if(visited[x][y][fm]) continue;
        if(fm == last){
            printf("%d %d\n",w,dp[x][y][fm][w]);
            return;
        }
        visited[x][y][fm]=true;
        if(grid[x][y]==fm){
            grid[x][y]='.';
        }
        int paths=dp[x][y][fm][w];
        for(int i=0;i<4;i++){
            int nx=x+dr[i]; int ny=y+dc[i];
            if(nx<0||nx>=n||ny<0||ny>=n) continue;
            if(visited[nx][ny][fm]) continue;
            char next = grid[nx][ny];
            if(next=='.'){
                q.push(cell(nx,ny,w+1,fm));
            }
            else if(next==fm+1){
                fm++;
                int &ref=dp[nx][ny][fm][w+1];
                ref=((ref%mod)+(paths%mod))%mod;
                q.push(cell(nx,ny,w+1,fm));
            } 
        }
    }
    printf("Impossible\n");
}

int main(){
   
    while(scanf("%d",&n),n){
        tc++;
        last='A';
        fill(&dp[0][0][0][0],&dp[11][0][0][0],0);
        fill(&visited[0][0][0],&visited[11][0][0],false);
        for(int i=0;i<n;i++){
            scanf("% ");
            for(int j=0;j<n;j++){
                scanf("%c",&grid[i][j]);
                if(grid[i][j]=='A'){
                    dp[i][j]['A'][0]=1;
                    s=cell(i,j,0,'B');
                }
                if(grid[i][j]>last){
                    last=grid[i][j];
                }
            }
        }
        printf("Case %d: ",tc);
        bfs();
    }
    return 0;
}
