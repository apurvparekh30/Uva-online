// Apurv Parekh
// 17th July 2018

#include <algorithm>
#include <queue>
#include <cstdio>
#include <cstring>

using namespace std;

struct Robot{
    int x,y,dir,time;
    Robot(int a,int b,int c,int d){
        x=a;
        y=b;
        dir=c;
        time=d;
    }
};

int r,c;
int g[51][51];
bool v[4][51][51];

int dr[]={-1,0,1,0};
int dc[]={0,1,0,-1};

bool validMove(int x, int y){
    if(x<=0 || y<=0 || x>=r || y>=c) return false;
    if(g[x-1][y-1]) return false;
    if(g[x-1][y]) return false; 
    if(g[x][y-1]) return false;
    if(g[x][y]) return false;
    
    return true;
}


int shortestTime(int startx,int starty,int endx,int endy,int dir){
    queue<Robot> Q;
    if(validMove(startx,starty)){
        Q.push(Robot(startx,starty,dir,0));
        v[dir][startx][starty]=true;
    }
    while(!Q.empty()){
        Robot curr = Q.front(); Q.pop();
        if(curr.x == endx && curr.y==endy) return curr.time;
        if(!v[(curr.dir+1)%4][curr.x][curr.y]){
            v[(curr.dir+1)%4][curr.x][curr.y] = true;
            Q.push(Robot(curr.x,curr.y,(curr.dir+1)%4,curr.time+1));
        }
        if(!v[(curr.dir+3)%4][curr.x][curr.y]){
            v[(curr.dir+3)%4][curr.x][curr.y] = true;
            Q.push(Robot(curr.x,curr.y,(curr.dir+3)%4,curr.time+1));
        }
        for(int i=1;i<=3;i++){
            if(validMove(curr.x+dr[curr.dir]*i,curr.y+dc[curr.dir]*i)){
                if(v[curr.dir][curr.x+dr[curr.dir]*i][curr.y+dc[curr.dir]*i]) continue;
                v[curr.dir][curr.x+dr[curr.dir]*i][curr.y+dc[curr.dir]*i]=true;
                Q.push(Robot(curr.x+dr[curr.dir]*i,curr.y+dc[curr.dir]*i,curr.dir,curr.time+1));
            }else break;
        }
    }
    return -1;
}

 int main(){
    while(scanf("%d%d",&r,&c),(r||c)){
        memset(v,false,sizeof(v));
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++) 
                scanf("%d",&g[i][j]);
        int x1,y1,x2,y2,dir;
        char s[6];
        scanf("%d%d%d%d%s",&x1,&y1,&x2,&y2,s);
        if(s[0]=='n') dir=0;
        else if(s[0]=='e') dir=1;
        else if(s[0]=='s') dir=2;
        else dir=3;
        printf("%d\n",shortestTime(x1,y1,x2,y2,dir));
    }
    return 0;
}
 