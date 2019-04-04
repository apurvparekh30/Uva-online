#include <bits/stdc++.h>

using namespace std;

#define INF 1000000

int a[40],b[40];
int m,s;
int memo[41][301][301];

int dp(int i,int x,int y){
    int curr = x*x + y*y;
    if(curr == s) return 0;
    if(curr > s || i == m) return INF;
    int &v = memo[i][x][y];
    if(v != 0) return v;
    return v = min(dp(i+1,x,y),1+dp(i,x+a[i],y+b[i]));
}

int main() {
    int tc;
    scanf("%d",&tc);

    while(tc--){
        scanf("%d%d",&m,&s);
        
        for(int i=0;i<m;i++){
            scanf("%d%d",&a[i],&b[i]);
        }
        fill(&memo[0][0][0],&memo[40][300][300],0);
        s = s * s;
        int ans = dp(0,0,0);
        if(ans == INF) 
            printf("not possible\n");
        else printf("%d\n",ans);
    }
    return 0;
}