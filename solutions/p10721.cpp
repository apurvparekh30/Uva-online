#include <bits/stdc++.h>

using namespace std;

long long memo[51][51];
int n,k,m;

long long dp(int n,int k){
    long long &ref = memo[n][k];
    if(ref!=-1) return ref;
    if(n==0 && k == 0) return ref=1LL;
    if(n==0) return ref = 0LL;
    if(k==0) return ref = 0LL;
    ref = 0LL;
    for(int i=1;i<=m;i++){
        if(n-i<0) break;
        ref+=dp(n-i,k-1);
    }
    return ref;
}

int main() {
    
    while(scanf("%d%d%d",&n,&k,&m) == 3){
        fill(&memo[0][0],&memo[51][0],-1);
        printf("%lld\n",dp(n,k));
    }
    return 0;
}