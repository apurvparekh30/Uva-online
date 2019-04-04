// Apurv Parekh
// 15th July 2018

#include <cstdio>
#include <algorithm>

using namespace std;

struct Edge { 
    int u,v,w;
    bool operator <(const Edge &b) const {
        return w<b.w;
    }
};
int m,n;
int total;
Edge e[200001];
int rnk[200001];
int mst;
int p[200001];
void init(){
    fill(rnk,rnk+m,0);
    for(int i=0;i<m;i++) p[i] = i;
    total=0;
    mst=0;
}
int findSet(int i){
    return (p[i]==i)? i:(p[i]=findSet(p[i]));
}
int main() {
    while(scanf("%d%d",&m,&n), (n||m)){
        init();
        for(int i=0;i<n;i++){
            Edge tmp;
            scanf("%d%d%d",&tmp.u,&tmp.v,&tmp.w);
            total+=tmp.w;
            e[i]=tmp;
        }
        sort(e,e+n);
        for(int i=0;i<n;i++){
            int x = findSet(e[i].u);
            int y = findSet(e[i].v);
            if(x!=y){
                if(rnk[x] > rnk[y]) p[y]=x;
                else{
                    p[x]=y;
                    if(rnk[x]==rnk[y]) rnk[y]++;
                }
                mst+=e[i].w;
            }
        }
        printf("%d\n",total-mst);
    }
    return 0;
}