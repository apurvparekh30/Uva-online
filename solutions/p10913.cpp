// Apurv Parekh
// 3rd Aug 2018

#include <algorithm>
#include <cstdio>
#include <climits>

using namespace std;

const int maxx = 76;
const int mk = 6;
const int INF=INT_MAX;
const int RIGHT=1;
const int LEFT=2;

int n,k;
int grid[maxx][maxx];
long long memo[maxx][maxx][mk][3];

long long dp(int r,int c,int k,int from){
    if(r>=n || c<=0 || c>=n) return -INF;
    auto v=grid[r][c];
    if(v<0) k--;
    if(k<0) return -INF;    
    if(r==n-1 && c==n-1) return v;
    long long &ref=memo[r][c][k][from];
    if(ref!=INF) return ref;
    ref=-INF;
    long long t;
    if(from!=RIGHT){
        t=dp(r,c+1,k,LEFT);
        if(t!=-INF)ref=max(ref,t+v);
    }
    if(from!=LEFT){
        t=dp(r,c-1,k,RIGHT);
        if(t!=-INF)ref=max(ref,t+v);
    }
    t=dp(r+1,c,k,0);
    if(t!=-INF)ref=max(ref,t+v);
    return ref;
}

int main(){
    int tc=0;
    while(scanf("%d%d",&n,&k) ,(n||k)){
        tc++;
        n++;
        fill(&grid[0][0],&grid[maxx][0],0);
        fill(&memo[0][0][0][0],&memo[maxx][0][0][0],INF);
        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                scanf("%d",&grid[i][j]);
            }
        }
        printf("Case %d: ",tc);
        long long ans = 0;
        ans=dp(1,1,k,0);
        if(ans==-INF){
            printf("impossible\n");
        }
        else{
            printf("%lld\n",ans);
        }
    }
    return 0;
}