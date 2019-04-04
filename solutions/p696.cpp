// Apurv Parekh
// 12th Aug 2018

#include <algorithm>
#include <cstdio>

using namespace std;

int solve(int n,int m){
    if(n==0 || m==0) return 0;
    if(n==1 || m==1) return max(n,m);
    if(m==2 || n==2) return ((min((max(n,m)%4),2)*2)+((max(n,m)/4)*4));
    return (n*m+1)>>1;
}

int main(){
    int n,m;
    while(scanf("%d%d",&n,&m), (n||m)){
        printf("%d knights may be placed on a %d row %d column board.\n",solve(n,m),n,m);
    }
    return 0;
}