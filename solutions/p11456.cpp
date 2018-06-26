#include <bits/stdc++.h>

using namespace std;

int main() {
    int tc;
    scanf("%d",&tc);
    while(tc--){
        int n;
        scanf("%d",&n);
        int arr[n];
        int lis[n],lds[n];
        for(int i=0;i<n;i++)
            scanf("%d",&arr[i]);
        
        for(int i=n-1;i>=0;i--){
            lis[i] = 1;
            for(int j=i+1;j<n;j++){
                if(arr[j]>arr[i]){
                    lis[i] = max(lis[i],1+lis[j]);
                }
            }
        }
        for(int i=n-1;i>=0;i--){
            lds[i] = 1;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[i]){
                    lds[i] = max(lds[i],1+lds[j]);
                }
            }
        }

        //printf("\n\n");
        int ans=0;
        for(int i=0;i<n;i++){
            ans=max(ans,lis[i]+lds[i]-1);
        }
        printf("%d\n",ans);
    }
    return 0;
}