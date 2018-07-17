// Apurv Parekh
// 17th July 2018

#include <algorithm>
#include <queue>
#include <cstdio>

using namespace std;

int r,c;
int g[1000][1000];

int dr[]={1,0,-1,0};
int dc[]={0,-1,0,1};

int main() {
    while(scanf("%d%d",&r,&c), (r||c)){
        fill(&g[0][0],&g[1000][0],0);
        int rows;
        scanf("%d",&rows);
        while(rows--){
            int rno,n,cno;
            scanf("%d%d",&rno,&n);
            while(n--){
                scanf("%d",&cno);
                g[rno][cno]=-1;
            }
        }
        pair<int,int> s,d;
        int u,v;
        scanf("%d%d",&u,&v); s=make_pair(u,v);
        scanf("%d%d",&u,&v); d=make_pair(u,v);
        queue<pair<int,int>> q;
        q.push(s);
        while(!q.empty()){
            s=q.front(); q.pop();
            if(s == d) break;
            for(int i=0;i<4;i++){
                int x,y;
                x=s.first+dr[i]; y=s.second+dc[i];
                if(x<0||x>=r||y<0||y>=c||g[x][y]!=0) continue;
                g[x][y]=g[s.first][s.second]+1;
                q.push(make_pair(x,y));
            }  
        }
        printf("%d\n",g[d.first][d.second]);
    }
    return 0;
}