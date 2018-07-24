// Apurv Parekh
// 24th July 2018

#include <algorithm>
#include <cstdio>

using namespace std;

int n,r,s,d;
int memo[100][100];

int main(){
    int tc;
    scanf("%d",&tc);
    for(int t=1;t<=tc;t++){
        fill(&memo[0][0],&memo[100][0],1e9);
        scanf("%d%d",&n,&r);
        while(r--){
            int u,v;
            scanf("%d%d",&u,&v);
            memo[u][v]=1;
            memo[v][u]=1;
        }
        scanf("%d%d",&s,&d);
        for(int i=0;i<n;i++) memo[i][i]=0;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    memo[i][j]=min(memo[i][j],memo[i][k]+memo[k][j]);
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            int tmp;
            if(memo[s][i]==1e9) continue;
            if(memo[i][d]==1e9) continue;
            tmp=memo[s][i]+memo[i][d];
            if(ans<tmp) ans=tmp; 
        }
        printf("Case %d: %d\n",t,ans);
    }
    return 0;
}