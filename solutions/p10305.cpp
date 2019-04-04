#include <bits/stdc++.h>

using namespace std;

const int maxx = 101;

int n,m;

bool g[maxx][maxx];
bitset<maxx> b;

bool invalid(int v){
    for(int u=1;u<=n;u++){
        if(g[u][v]){
            if(b.test(u)) continue;
            return true;
        }
    }
    return false;
}

bool flag = false;

void dfs(int u){
    if(b.test(u)) return;
    if(invalid(u)) return;
    b.set(u);
    if(flag) printf(" ");
    printf("%d",u);
    if(!flag) flag = true;
    for(int v=1;v<=n;v++){
        if(g[u][v]){
            dfs(v);
        }
    }
}

int main(){
    while(scanf("%d%d",&n,&m), (n||m)){
        memset(g,false,sizeof(g));
        b.reset();
        flag = false;
        while(m--){
            int u,v;
            scanf("%d%d",&u,&v);
            g[u][v] = true;
        }
        for(int i=1;i<=n;i++){
            dfs(i);
        }
        printf("\n");
    }
    return 0;
}