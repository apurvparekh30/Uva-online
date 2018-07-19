#include <algorithm>
#include <queue>
#include <cstdio>

using namespace std;

struct vertex{
    int x,y,w;
    vertex(int a,int b,int c){
        x=a;y=b;w=c;
    }
    bool operator< (const vertex &b) const{
        return w>b.w;
    }
};

int dr[]={-1,0,1,0};
int dc[]={0,1,0,-1};

int g[1000][1000];
int d[1000][1000];
int n,m;
int main(){
    int tc;
    scanf("%d",&tc);
    while(tc--){
        scanf("%d%d",&n,&m);
        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++)
                scanf("%d",&g[i][j]);
        fill(&d[0][0],&d[1000][0],1e9);
        priority_queue<vertex> pq;
        pq.push(vertex(1,1,g[1][1]));
        d[1][1]=g[1][1];
        while(!pq.empty()){
            int x,y,c;
            vertex curr=pq.top();pq.pop();
            x=curr.x; y=curr.y; c=curr.w;
            
            if(c > d[x][y]) continue;
            for(int i=0;i<4;i++){
                int tx,ty;
                tx=x+dr[i]; ty=y+dc[i];
                if(tx<=0||tx>n||ty<=0||ty>m) continue;
                if(d[tx][ty]>c+g[tx][ty]){
                    d[tx][ty]=c+g[tx][ty];
                    pq.push(vertex(tx,ty,d[tx][ty]));
                }
            }
        }
        printf("%d\n",d[n][m]);
    }

    return 0;
}