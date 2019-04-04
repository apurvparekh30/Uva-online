// Apurv Parekh
// 16th July 2018

#include <algorithm>
#include <cstdio>
#include <vector>

const int INF = 1e9;

using namespace std;

struct Edge { 
    int u,v,w;
    bool operator<(const Edge &b) const{
        return w<b.w;
    }
};

int n,m;
int p[301],r[301];
Edge e[300 * 300];
vector<int> mstEdgeIndex;
int flag[300 * 300];

void init(){
    fill(r,r+n,0);
    for(int i=1;i<n;i++) p[i]=i;
    fill(flag,flag+m,0);
    mstEdgeIndex.clear();
}   

int findSet(int i){
    return (p[i]==i) ? i:(p[i]=findSet(p[i]));
}

int unionSet(int x,int y){
    if(r[x]>r[y]) p[y]=x;
    else{
        p[x]=y;
        if(r[x]==r[y]) r[y]++;
    }
}

int main(){
    int tc;
    scanf("%d",&tc);
    while(tc--){
        scanf("%d%d",&n,&m);
        n++;
        init();
        for(int i=0;i<m;i++){
            Edge tmp;
            scanf("%d%d%d",&tmp.u,&tmp.v,&tmp.w);
            e[i]=tmp;
        }
        sort(e,e+m);
        int ans1=0,ans2=0;
        for(int i=0;i<m;i++){
            int x=findSet(e[i].u); int y=findSet(e[i].v);
            if(x!=y){
                unionSet(x,y);
                ans1+=e[i].w;
                mstEdgeIndex.push_back(i);
            }
        }
        ans2=INF;
        
        for(auto index:mstEdgeIndex){
            flag[index] = 1;
            int tmp=0;
            fill(r,r+n,0);
            for(int i=0;i<n;i++) p[i]=i;
            int noComp = n-1;
            for(int i=0;i<m;i++){
                if(flag[i]) continue;
                int x=findSet(e[i].u); int y=findSet(e[i].v);
                if(x!=y){
                    unionSet(x,y);
                    tmp+=e[i].w;
                    noComp--;
                }
            }
            //printf("%d %d\n",noComp,tmp);
            if(noComp==1) ans2 = min(tmp,ans2);
            flag[index] = 0;
        }
        printf("%d %d\n",ans1,ans2);
    }
    return 0;
}