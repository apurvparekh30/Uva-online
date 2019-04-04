#include <bits/stdc++.h>

using namespace std;

const int mod = 1e6;

int memo[101][101];

int n,k;

// n to 0
// k to 0
int dp(int n,int k){
    if(k == 1) return memo[n][k] = 1;
    int &ref = memo[n][k];
    if(ref==-1) {
        ref = 0;
        for(int i=0;i<=n;i++){
            ref=(ref%mod + dp(n-i,k-1)%mod)%mod;
        }
    }
    return ref;
}

int main(){
    fill(&memo[0][0],&memo[101][0],-1);
    while(scanf("%d%d",&n,&k), n||k){
        printf("%d\n",dp(n,k));
    }
    return 0;
}