#include <bits/stdc++.h>

using namespace std;

int n,m;

int arr[1000];

int high,low;

int best;


bool truCapacity(int maxcapacity){
    int currsize = 0;
    int noContainers = 0;
    for(int i=0;i<n;i++){
        if(arr[i] > maxcapacity) return false;
        if(currsize + arr[i] > maxcapacity) currsize=0;
        if(currsize == 0) noContainers++;
        if(noContainers > m) return false;
        currsize+=arr[i];
    }
    return true;
}


int main(){ 

    while(scanf("%d %d",&n,&m)==2){
        low = 0;
        high = 0;
        for(int i=0;i<n;i++){
            scanf("%d",&arr[i]);
            high+=arr[i];
        }
        while(low<=high){
            //int mid = low + (high - low)/2;
            int mid = (high + low)/2;
            if(truCapacity(mid)){
                best = mid;
                high = mid-1;
            }
            else {
                low = mid + 1;
            }
        }
        
        printf("%d\n",best);
    }
    return 0;
}