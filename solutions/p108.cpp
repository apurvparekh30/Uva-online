#include <bits/stdc++.h>

using namespace std;

int main() {
    int n;
    scanf("%d",&n);
    int arr[n][n];
    for(int i=0;i<n;i++)
        for(int j=0;j<n;j++){
            int no;
            scanf("%d",&no);
            if(i>0) no+=arr[i-1][j];
            if(j>0) no+=arr[i][j-1];
            if(i>0 && j>0) no-=arr[i-1][j-1];
            arr[i][j]=no;
        }
    int max_sum=-100*100*127;
    for(int i=0;i<n;i++) for(int j=0;j<n;j++)
    for(int i1=i;i1<n;i1++) for(int j1=j;j1<n;j1++){
        int ans = arr[i1][j1];
        if(i>0) ans-= arr[i-1][j1];
        if(j>0) ans-= arr[i1][j-1];
        if(i>0 && j>0) ans+=arr[i-1][j-1];
        if(ans > max_sum) max_sum = ans;
    }
    printf("%d\n",max_sum);
    return 0;
}