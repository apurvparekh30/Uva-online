#include <bits/stdc++.h>

using namespace std;

int main() {
    bool newline = false;
    int tc;
    scanf("%d",&tc);
    while(tc--){
        if(newline) printf("\n"); else newline=true;
        int a,b,c;
        scanf("%d%d%d",&a,&b,&c);
        long long arr[a][b][c];
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                for(int k=0;k<c;k++){
                    long long g; scanf("%lld",&g);
                    if(i>0) g+=arr[i-1][j][k];
                    if(j>0) g+=arr[i][j-1][k];
                    if(k>0) g+=arr[i][j][k-1];
                    if(i>0 && j>0) g-=arr[i-1][j-1][k];
                    if(j>0 && k>0) g-=arr[i][j-1][k-1];
                    if(i>0 && k>0) g-=arr[i-1][j][k-1];
                    if(i>0 && j>0 && k>0) g+=arr[i-1][j-1][k-1];
                    arr[i][j][k]=g; 
                }
            }       
        }
        long long max_sum=INT_MIN;
        for(int i=0;i<a;i++) for(int j=0;j<b;j++) for(int k=0;k<c;k++)
        for(int i1=i;i1<a;i1++) for(int j1=j;j1<b;j1++) for(int k1=k;k1<c;k1++){
            long long s = arr[i1][j1][k1];
            if(i>0) s-=arr[i-1][j1][k1];
            if(j>0) s-=arr[i1][j-1][k1];
            if(k>0) s-=arr[i1][j1][k-1];

            if(i>0 && j>0) s+=arr[i-1][j-1][k1];
            if(j>0 && k>0) s+=arr[i1][j-1][k-1];
            if(i>0 && k>0) s+=arr[i-1][j1][k-1];

            if(i>0 && j>0 && k>0) s-=arr[i-1][j-1][k-1];

            if(max_sum < s) max_sum=s;
        }
        printf("%lld\n",max_sum);
    }
    return 0;
}



/*
for(int i=0;i<a;i++){
    for(int j=0;j<b;j++){
        for(int k=0;k<c;k++){
            printf("%d ",arr[i][j][k]);
        }
        printf("\n");
    }       
    printf("\n");
}
 */