#include <bits/stdc++.h>

using namespace std;

int N,Q,D,M;
int SET[200];

long long  memo[202][21][11];

int mod(int no,int m){
    if(no>=0) return (no%m);
    return (m + (no%m)) % m;
}

long long dp(int i,int sum,int c){
    if(c==M && sum==0) return 1;
    if(c==M && sum!=0) return 0;
    if(i==N) return 0;
    if(memo[i][sum][c]!=-1) return memo[i][sum][c];

    memo[i][sum][c]=dp(i+1,sum,c) + dp(i+1,((sum+SET[i])%D+D)%D,c+1);
    return memo[i][sum][c];
}
int main() {
    int tc=1;
    while(scanf("%d%d",&N,&Q), N||Q){
        for(int i=0;i<N;i++){
            scanf("%d",&SET[i]);
        }
        printf("SET %d:\n",tc);
        for(int i=1;i<=Q;i++){
            memset(memo,-1,sizeof(memo));
            scanf("%d%d",&D,&M);
            printf("QUERY %d: %lld\n",i,dp(0,0,0));
        }
        tc++;
    }
    return 0;
}