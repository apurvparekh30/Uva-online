// Apurv Parekh
// 1st Aug 2018

#include <algorithm>
#include <cstdio>


using namespace std;

const int INF =  1e9;

int memo[610][301];
int cost[610];
int n,k;


int dp(int curr,int k){
    if(curr==n+1) return 0;
    if(k<0) return INF;
    int &ref=memo[curr][k];
    if(ref!=-1) return ref;
    ref=INF;
    int sum=0;
    for(int i=curr;i<=n;i++){
        sum+=cost[i];
        ref=min(ref,max(sum,dp(i+1,k-1)));
    } 
    return ref;  
}  



int main(){
    while(scanf("%d%d",&n,&k)==2){
        n++;
        fill(cost,cost+n+1,0);
        fill(&memo[0][0],&memo[n+1][0],-1);
        for(int i=1;i<=n;i++){
            scanf("%d",&cost[i]);
        }
        printf("%d\n",dp(1,k));
    }
    return 0;
}