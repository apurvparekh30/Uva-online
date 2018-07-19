// Apurv Parekh
// 18th July 2018

#include <algorithm>
#include <queue>
#include <cstdio>

using namespace std;

struct point{
    int x,y,d;
    point(int a,int b,int c){
        x=a; y=b; d=c;
    }
};
int p1,p2;
int g[2001][2001];

void init(){
    fill(&g[0][0],&g[2001][0],-1);
}

int dr[]={-1,0,1,0};
int dc[]={0,1,0,-1};

int main(){
    while(1){
        scanf("%d",&p1);
        if(p1==0) break;
        init();
        queue<point> q;
        for(int i=0;i<p1;i++){
            int x,y;
            scanf("%d%d",&x,&y);
            q.push(point(x,y,0));
        }
        scanf("%d",&p2);
        for(int i=0;i<p2;i++){
            int x,y;
            scanf("%d%d",&x,&y);
            g[x][y]=1;
        }
        while(!q.empty()){
            point front=q.front(); q.pop();
            int x=front.x; int y=front.y;
            if(x<0||x>2000||y<0||y>2000||g[x][y]==0) continue; // lazy validation
            if(g[x][y]==1) {
                printf("%d\n",front.d);
                break;
            }
            g[x][y]=0;
            for(int i=0;i<4;i++){
                q.push(point(x+dr[i],y+dc[i],front.d+1)); 
            }
        }
    }
    
    return 0;
}