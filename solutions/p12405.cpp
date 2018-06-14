#include <bits/stdc++.h>

using namespace std;

int main() {
    int tc;
    scanf("%d",&tc);
    int t=0;
    while(tc--){
        int n;
        scanf("%d",&n);
        char arr[n];
        bool cover[n];
        memset(cover,false,sizeof(cover));
        scanf("%s",arr);
        int count=0;
        for(int i=1;i<n;i++){
            if(arr[i-1]!='#' && !cover[i-1]){
                count++;
                cover[i-1]=true;
                cover[i]=true;
                cover[i+1]=true;
            }
        }
        if(arr[n-1]!='#' && !cover[n-1]){
            count++;
        }
        printf("Case %d: %d\n",++t,count);
    }
    return 0;
}