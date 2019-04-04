#include <bits/stdc++.h>

using namespace std;

long long  memo[5][30001];


int arr[]={1,5,10,25,50};

long long dp(int i,int n){
    if(n==0) return 1;
    if(n<0) return 0;
    if(i==5) return 0;
    if(memo[i][n]!=-1) return memo[i][n];
    return memo[i][n] = dp(i+1,n) + dp(i,n-arr[i]);
}

int main() {
    int n;
    memset(memo,-1,sizeof(memo));
    while(scanf("%d",&n)==1){
        
        long long  ans = dp(0,n);
        if(ans == 1 ){
            printf("There is only 1 way to produce %d cents change.\n",n);
        }
        else{
            printf("There are %lld ways to produce %d cents change.\n",ans,n);
        }
    }
}