#include <bits/stdc++.h>

using namespace std;

int main() {
    int n;
    while(scanf("%d",&n), n){
        int arr[n];
        for(int i=0;i<n;i++){
            scanf("%d",&arr[i]);
        }
        int ans=0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            ans=max(ans,sum);
            sum=max(sum,0);
        }
        if(ans){
            printf("The maximum winning streak is %d.\n",ans);
        }
        else{
            printf("Losing streak.\n");
        }
    }
    return 0;
}