#include <bits/stdc++.h>

using namespace std;

int main() {
    int n;
    int output=0;
    while(scanf("%d",&n),n){
        
        vector<int> v(n);
        for(int i=0;i<n;i++){
            scanf("%d",&v[i]);
        }
        sort(v.begin(),v.end());
        int maxCount=0,localCount=1;
        for(int i=1;i<n;i++){
            if(v[i-1]== v[i]){
                localCount++;
            }
            else{
                localCount=1;
            }
            maxCount=max(maxCount,localCount);
        }
        if(output==0){
            output++;
        }
        else {
            printf("\n");
        }
        printf("%d\n",maxCount);
        for(int list=0;list<maxCount;list++){
            bool first = true;
            for(int j=list;j<n;j+=maxCount){
                if(first) first = false;
                else printf(" ");
                printf("%d",v[j]);
            }
            printf("\n");
        }
    }    
    return 0;
}