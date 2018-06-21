#include <bits/stdc++.h>

using namespace std;

int main() {
    int b;
    scanf("%d",&b);
    for(int tc=1;tc<=b;tc++){
        int s;
        scanf("%d",&s);
        int arr[s];
        for(int i=1;i<s;i++){
            scanf("%d",&arr[i]);
        }
        int ans=0;
        int start,end;
        int newstart=1;
        int sum=0;
        for(int i=1;i<s;i++){
            sum+=arr[i];
            if(ans<=sum){
                if(ans == sum){
                    if((end-start) < (i-newstart)){
                        start=newstart;
                        end=i;
                    } 
                }
                else{
                    ans=sum;
                    start=newstart;
                    end=i;
                }
                
            }
            if(sum<0){
                sum=0;
                newstart=i+1;
            }
        }
        if(ans == 0){
            printf("Route %d has no nice parts\n",tc);
        }
        else{
            printf("The nicest part of route %d is between stops %d and %d\n",tc,start,end+1);
        }
    }
    return 0;
}