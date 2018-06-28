#include <bits/stdc++.h>

using namespace std;

int m,n;
int p[100],f[100];

int memo[101][10001];

int dp(int i,int money){
    if(money>m && m<1800) return -6;
    if(money>m+200) return -6;
    if(i==n){
        if(money>m && money<=2000) return -6;
        return 0;
    } 
    if(memo[i][money]!=-1) return memo[i][money];
    return (memo[i][money] = max(dp(i+1,money),f[i]+dp(i+1,money+p[i])));
}

int main() {
    while(scanf("%d%d",&m,&n)==2){
        for(int i=0;i<n;i++){
            scanf("%d",&p[i]);
            scanf("%d",&f[i]);
        }
        memset(memo,-1,sizeof(memo));
        
        printf("%d\n",dp(0,0));
    }
    return 0;
}