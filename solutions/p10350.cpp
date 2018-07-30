// Apurv Parekh
// 30th July 2018

#include <algorithm>
#include <cstdio>

using namespace std;

const int INF=1e9;

int memo[121][16];
int lift[121][16][16];
int n,m;

int dp(int i,int hole){
    if(i==n-1) return 0;
    int &ref=memo[i][hole];
    if(ref!=INF) return ref;
    for(int k=0;k<m;k++){
        ref=min(ref,lift[i][hole][k]+dp(i+1,k)+2);
    }
    return ref;
}

int main(){
    char name[100];
    while(scanf("%s",name)==1){
        
        scanf("%d%d",&n,&m);
        for(int i=0;i<n-1;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<m;k++){
                    scanf("%d",&lift[i][j][k]);
                }
            }
        }
        fill(&memo[0][0],&memo[n][0],INF);
        int ans = INF;
        for(int i=0;i<m;i++){
            ans=min(ans,dp(0,i));
        }
        printf("%s\n",name);
        printf("%d\n",ans);
    }
    return 0;
}


