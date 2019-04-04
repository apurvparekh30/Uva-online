#include <bits/stdc++.h>

using namespace std;

int main() {
    int tc;
    scanf("%d",&tc);
    while(tc--){
        int n;
        scanf("%d",&n);
        unsigned long arr[n];
        
        for(int i=0;i<n;i++){
            scanf("%lu",&arr[i]);
        }
        unsigned long sum=0;
        int count=1;
        for(int i=0;i<n-1;i++){
            if(sum + arr[i] < arr[i+1]){
                sum=sum+arr[i];
                count++;
            }
        }
        printf("%d\n",count);
    }
    return 0;
}