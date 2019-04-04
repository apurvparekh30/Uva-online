// Apurv Parekh
// 8th Aug 2018


#include <algorithm>
#include <cstdio>
#include <vector>

using namespace std;

const int maxx = 200;

int dec[maxx];
int n,r;
int g[maxx][maxx];

void dfs(int u){
    for(int v=0;v<n;v++){
        if(g[u][v]>0){
            g[u][v]--;
            g[v][u]--;
            r--;
            dfs(v);
        }
    }
}

int main(){
    while(scanf("%d%d",&n,&r)==2){
        fill(dec,dec+maxx,0);
        fill(&g[0][0],&g[maxx][0],0);
        if(r==0) {
            printf("Not Possible\n");
            continue;
        }
        int start = -1;
        for(int i=0;i<r;i++){
            int u,v;
            scanf("%d%d",&u,&v);
            g[u][v]++;
            g[v][u]++;
            dec[u]++;
            dec[v]++;
            if(start == -1) start = u;
        }
        int bad=false; 
        for(int i=0;i<n;i++){
            if(dec[i]%2==1){
                bad=true;
                break;
            }
        }

        if(!bad){
            dfs(start);
            if(r!=0) bad = true;
        }
        
        if(bad){
            printf("Not Possible\n");
        }
        else{
             printf("Possible\n");
        }
    }
    return 0;
}