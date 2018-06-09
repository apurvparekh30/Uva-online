#include <bits/stdc++.h>

using namespace std;

int n;
int arr[10000];
int m;

int binarySearch(int low,int high,int val){
    if(low<=high){
        int mid = (low+high)/2;
        if(arr[mid]==val) return mid;
        if(val < arr[mid]) high=mid-1;
        else if(val > arr[mid]) low=mid+1;
        return binarySearch(low,high,val);
    }
    return -1;
}

int main(){
    while(scanf("%d",&n)!=EOF){
        for(int i=0;i<n;i++){
            scanf("%d",&arr[i]);
        }
        sort(arr,arr+n,less<int>());
        scanf("%d",&m);
        int a,b;
        int res,i;
        for(i=0;i<n && (2 * arr[i])<= m;i++){
            if((res=binarySearch(i+1,n-1,m-arr[i]))!=-1) {
                a = i;
                b= res;
            }
        }
        printf("Peter should buy books whose prices are %d and %d.\n\n",arr[a],arr[b]);
    }
    return 0;
}