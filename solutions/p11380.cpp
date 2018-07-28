// Apurv Parekh
// 28th July

#include <algorithm>
#include <queue>
#include <cstdio>
#include <string>
#include <unordered_map>
#include <iostream>

using namespace std;

const int INF = 1e5;
const int maxv = 2000;
int x,y,p;
int s=0,t;
char grid[31][31];
int res[maxv][maxv];
vector<vector<int>> ls(maxv,vector<int>());
int f,mf;

bool visited[maxv];
int pr[maxv];

int dr[]={-1,0,1,0};
int dc[]={0,1,0,-1};

int g(int x1,int y1){
    return (x1-1)*2*y + 2*y1-1; 
}

void augment(int v,int minEdge){
    if(v==s){
        f=minEdge;
        return;
    }
    else if(pr[v]!=-1){
        augment(pr[v],min(minEdge,res[pr[v]][v]));
        res[pr[v]][v]-=f;
        res[v][pr[v]]+=f;
    }
}

int main(){
    while(scanf("%d%d%d",&x,&y,&p)==3){
        t=(x*y)*2+1; 
        mf=0;
        fill(&res[0][0],&res[maxv][0],0);
        for(int i=0;i<maxv;i++) ls[i].clear();
        for(int i=1;i<=x;i++){
            scanf("% ");
            for(int j=1;j<=y;j++){
                scanf("%c",&grid[i][j]);
            }
        }
        for(int i=1;i<=x;i++){
            for(int j=1;j<=y;j++){
                if(grid[i][j]=='~') continue;
                int index=g(i,j);
                ls[index].push_back(index+1);
                ls[index+1].push_back(index);
                if(grid[i][j]=='.' || grid[i][j]=='*'){
                    res[index][index+1]=1;
                    //res[index+1][index]=1;
                }
                else{
                    res[index][index+1]=INF;
                    //res[index+1][index]=INF;
                }
            }
        }
        for(int i=1;i<=x;i++){
            for(int j=1;j<=y;j++){
                char c=grid[i][j];
                if(c=='~') continue;
                if(c=='*'){
                    ls[s].push_back(g(i,j));
                    ls[g(i,j)].push_back(s);
                    res[s][g(i,j)]=1;
                } 
                if(c=='#'){
                    ls[g(i,j)+1].push_back(t);
                    ls[t].push_back(g(i,j)+1);
                    res[g(i,j)+1][t]=p;
                }
                for(int it=0;it<4;it++){
                    int nx,ny;
                    nx=i+dr[it]; ny=j+dc[it];
                    if(nx<=0 || nx>x || ny<=0 || ny>y) continue;
                    if(grid[nx][ny]=='~') continue;
                    ls[g(i,j)+1].push_back(g(nx,ny));
                    ls[g(nx,ny)].push_back(g(i,j)+1);
                    res[g(i,j)+1][g(nx,ny)]=INF;
                }
            }
        }
        while(1){
            f=0;
            queue<int> q;
            q.push(s);
            fill(visited,visited+maxv,false);
            fill(pr,pr+maxv,-1);
            visited[s]=true;
            while(!q.empty()){
                int u=q.front(); q.pop();
                if(u==t) break;
                for(int v:ls[u]){
                    if(visited[v]) continue;
                    if(res[u][v]==0) continue;
                    visited[v]=true;
                    q.push(v);
                    pr[v]=u;
                }
            }
            augment(t,INF);
            if(f==0) break;
            mf+=f;
        }
        printf("%d\n",mf);
    }
    return 0;
}