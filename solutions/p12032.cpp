#include <bits/stdc++.h>

using namespace std;

int tc;
int n;

int arr[100001];
int ans;
int main() {
    scanf("%d",&tc);
    for(int i=1;i<=tc;i++){
        int k=0;
        scanf("%d",&n);
        arr[0]=0;
        for(int j=1;j<=n;j++){
            scanf("%d",&arr[j]);
            k = max(k,arr[j]-arr[j-1]);
        }
        ans = k;
        for(int j=1;j<=n;j++){
            if(arr[j]-arr[j-1] == k) 
                k--;
            else if(arr[j] -arr[j-1] > k){
                ans++;
                break;
            } 
        }
        printf("Case %d: %d\n",i,ans);
    }
    return 0;
}