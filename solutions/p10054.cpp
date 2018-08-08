// Apurv Parekh
// 8th Aug 2018

#include <algorithm>
#include <vector>
#include <cstdio>
#include <list>

using namespace std;

const int maxx = 51;

int g[maxx][maxx];
int degree[maxx];
int n;

void euler(int u){
    for(int i=1;i<maxx;i++){
        if(g[u][i] > 0){
            g[u][i]--;
            g[i][u]--;
            euler(i);
            printf("%d %d\n",i,u);
        }
    }
}

int main(){
    int tc;
    scanf("%d",&tc);
    bool flag=false;
    for(int t=1;t<=tc;t++){
        scanf("%d",&n);
        n++;
        fill(&g[0][0],&g[maxx][0],0);
        fill(degree,degree+maxx,0);
        int start = -1;
        for(int i=1;i<n;i++){
            int u,v;
            scanf("%d%d",&u,&v);
            g[u][v]++; g[v][u]++;
            degree[u]++; degree[v]++;
            if(start == -1) start = u;
        }
        bool bad = false;
        for(int i=1;i<maxx;i++){
            if(degree[i]%2==1){
                bad = true;
                break;
            }
        }
        if(flag) printf("\n"); flag=true;
        printf("Case #%d\n",t);
        if(bad) 
            printf("some beads may be lost\n");
        else euler(start);
    }
    return 0;
}