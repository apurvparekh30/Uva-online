// Apurv Parekh
// 29th July 2018

#include <algorithm>
#include <cstdio>
#include <queue>
#include <unordered_map>
#include <cmath>

using namespace std;

const int maxx=210;
const int INF=1e9; 

struct ice{
    int x,y,cap,count;
    ice(){}
    ice(int x,int y,int count,int cap):x(x),y(y),count(count),cap(cap){}
};
int n; double jump;
int total;
vector<vector<int>> g(maxx,vector<int>());
int res[maxx][maxx];
int s=0,t;
int f,mf;
bool visited[maxx];
int p[maxx];

inline double getDist(int x1,int y1,int x2, int y2){
    return sqrt((double)((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)));
}

void augment(int v,int midEdge){
    if(v==s) {
        f=midEdge;
        return;
    }
    else if(p[v]!=-1){
        augment(p[v],min(midEdge,res[p[v]][v]));
        res[p[v]][v]-=f;
        res[v][p[v]]+=f;
    }
}

int main(){
    int tc;
    scanf("%d",&tc);
    while(tc--){
        scanf("%d%lf",&n,&jump);

       
        int maxxx = 2+(2*n);
        
        int total=0;

        // input 
        ice loc[n+1];
        for(int i=1;i<=n;i++){
            int a,b,c,d;
            scanf("%d%d%d%d",&a,&b,&c,&d);
            loc[i] = ice(a,b,c,d);
            total+=c;
        }
        

        // algorithm
        vector<int> ans;
        for(int i=1;i<=n;i++){
            for(int i=0;i<maxxx;i++) g[i].clear();
            fill(&res[0][0],&res[maxxx][0],0);
            for(int i=1;i<=n;i++){
                if(loc[i].count>0){
                    int index=i*2-1;
                    g[s].push_back(index);
                    g[index].push_back(s);
                    res[s][index]=loc[i].count;
                }
                int j=i*2;
                g[j-1].push_back(j);
                g[j].push_back(j-1);
                res[j-1][j]=loc[i].cap;
            }
            for(int i=1;i<=n;i++){
                for(int j=i+1;j<=n;j++){
                    double d=getDist(loc[i].x,loc[i].y,loc[j].x,loc[j].y);
                    if(d <= jump){
                        g[i*2].push_back(j*2-1);
                        g[j*2-1].push_back(i*2);
                        res[i*2][j*2-1]=total;
                        g[j*2].push_back(i*2-1);
                        g[i*2-1].push_back(j*2);
                        res[j*2][i*2-1]=total;
                    }
                }
            }

            t=i*2-1;
            mf=0;
            while(1){
                f=0;
                queue<int> q;
                fill(visited,visited+maxxx,false);
                fill(p,p+maxxx,-1);
                q.push(s);
                visited[s]=true;
                while(!q.empty()){
                    int u=q.front(); q.pop();
                    if(u==t) break;
                    for(int v:g[u]){
                        if(visited[v]) continue;
                        if(res[u][v]==0) continue;
                        visited[v]=true;
                        q.push(v);
                        p[v]=u;
                    }
                }
                augment(t,INF);
                if(f==0) break;
                mf+=f;
            }
            if(mf==total) ans.push_back(i);
        }
        if(ans.empty()){
            printf("-1\n");
        }
        else{
            bool flag=false;
            for(int i:ans){
                if(flag){
                    printf(" %d",i-1);
                } 
                else{
                    printf("%d",i-1);
                    flag=true;
                }
            }
            printf("\n");
        }
    }
    return 0;
}