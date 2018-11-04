// Apurv Parekh
// 15th July 2018

#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

struct Edge {
    int u,v,w;
    bool operator <(const Edge& b) const{
        return w<b.w;
    }
};

int n,m;
int p[1000],r[1000];
Edge e[25000];
void init(){
    fill(r,r+n,0);
    for(int i=0;i<n;i++) p[i]=i;
}

int findSet(int i){
    return (p[i]==i) ? i:(p[i]=findSet(p[i]));
}

int main() {
    while(scanf("%d%d",&n,&m),(n||m)){
        init();
        for(int i=0;i<m;i++){
            Edge tmp;
            scanf("%d%d%d",&tmp.u,&tmp.v,&tmp.w);
            e[i]=tmp;
        }
        sort(e,e+m);
        vector<int> edges;
        for(int i=0;i<m;i++){
            int x=findSet(e[i].u);
            int y=findSet(e[i].v);
            if(x == y){
                edges.push_back(e[i].w);
            }
            else{
                if(r[x] > r[y]) p[y]=x;
                else{
                    p[x]=y;
                    if(r[x]==r[y]) r[y]++;
                }
            }
        }
        int size = edges.size();
        if(size == 0) printf("forest");
        else{
            printf("%d",edges[0]);
            for(int i=1;i<size;i++)
                printf(" %d",edges[i]);
        }
        
        printf("\n");
    }
    return 0;
}