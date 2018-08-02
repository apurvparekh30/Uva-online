// Apurv Parekh
// 1st Aug 2018

#include <algorithm>
#include <cstdio>


using namespace std;

const int INF = 1e9;

int memo[610][301];
int cost[610];
int n,k;

int dp(int i,int k,int ct){
	if(i==n) return 0;
	if(k<0) return INF;
	int &r=memo[i][k];
} 

int main(){
    while(scanf("%d%d",&n,&k)==2){
        n++;
        fill(cost,cost+n,0);
        fill(&memo[0][0],&memo[n][0],-1);
        for(int i=0;i<n;i++){
            scanf("%d",&cost[i]);
        }
        printf("%d\n",dp(1,k,cost[0]));
    }
    return 0;
}