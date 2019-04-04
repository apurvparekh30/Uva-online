#include <bits/stdc++.h>

using namespace std;
int n;
int tc = 0;

int arr[20]={1};

bool prime[33];

void backtrack(int mask,int L){
    if(L == n){
        if(prime[arr[L-1]+1]){
            printf("1");
            for(int j=1;j<n;j++){
                printf(" %d",arr[j]);
            }
            printf("\n");
        }
        return;
    }
    for(int i=2;i<=n;i++){
        if((mask&(1<<i)) != 0) continue;
        if(prime[arr[L-1]+i]){
            arr[L]=i;
            backtrack(mask|(1<<i),L+1);
        }
    }       
}

void solve() {
    
    prime[2]=prime[3]=prime[5]=prime[7]=prime[11]=true;
    prime[13]=prime[17]=prime[19]=prime[23]=prime[29]=prime[31]=true;
    while(scanf("%d",&n)!=EOF){
        if(tc++) putchar('\n');
        printf("Case %d:\n",tc);
        backtrack(1<<1,1);
    }
}

int main() {
    solve();
    return 0;
}