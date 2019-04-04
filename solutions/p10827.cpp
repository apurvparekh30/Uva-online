#include <bits/stdc++.h>

using namespace std;

int main() {
    int tc;
    scanf("%d",&tc);
    while(tc--){
        int n;
        scanf("%d",&n);
        int arr[2*n][2*n];
        for(int i=0;i<n;i++) 
            for(int j=0;j<n;j++){
                scanf("%d",&arr[i][j]);
                arr[i+n][j]=arr[i][j+n]=arr[i+n][j+n]=arr[i][j];
            }
        for(int i=0;i<2*n;i++) for(int j=0;j<2*n;j++){
            int no=arr[i][j];
            if(i>0) no+=arr[i-1][j];
            if(j>0) no+=arr[i][j-1];
            if(i>0 && j>0) no-=arr[i-1][j-1];
            arr[i][j]=no;
        }
        int i,j,i1,j1;
        int max_sum = INT_MIN;
        for(i=0;i<2*n;i++) for(j=0;j<2*n;j++)
        for(i1=i;i1<2*n && i1<i+n;i1++) 
        for(j1=j;j1<2*n && j1<j+n;j1++){
            int ans = arr[i1][j1];
            if(i>0) ans-=arr[i-1][j1];
            if(j>0) ans-=arr[i1][j-1];
            if(i>0 && j>0) ans+=arr[i-1][j-1];
            if(ans > max_sum) max_sum = ans;
        }
        printf("%d\n",max_sum); 
    }
    return 0;  
}