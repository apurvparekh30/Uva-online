#include <bits/stdc++.h>

using namespace std;

int g[50001];
int sum[50001];
bitset<50001> b; 
int n;

int dfs(int u){
    b.set(u);
    int cc = 0;
    if(g[u]!=-1 && !b.test(g[u]))
        cc+=1+dfs(g[u]);
    b.reset(u);
    return sum[u] = cc;
}

int main(){
    int tc;
    scanf("%d",&tc);
    for(int t=1;t<=tc;t++){
        scanf("%d",&n);
        b.reset();
        memset(g,-1,sizeof(g));
        memset(sum,-1,sizeof(sum));
        for(int i=0;i<n;i++){
            int u,v;
            scanf("%d%d",&u,&v);
            g[u] = v;
        }  
        int ans;
        int cc=0; 
        for(int i=1;i<=n;i++){
            if(sum[i]==-1) sum[i]=dfs(i);
            if(sum[i] > cc){
                cc = sum[i];
                ans = i;
            }
        }
        printf("Case %d: %d\n",t,ans);
    }
    return 0;
}