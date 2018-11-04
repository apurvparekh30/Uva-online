#include <bits/stdc++.h>

using namespace std;


int x;

int wind[10][10001];
int memo[10][10001];

// current altitude and current distance covered

int dp(int alt,int dist){
    if(alt>9 || alt<0 || dist>x) return 1e9;
    if(dist == x){
        if( alt == 0) return 0;
        return 1e9;
    }
    int &ref = memo[alt][dist];
    if(ref == -1){
        ref = min(60-wind[alt][dist] + dp(alt+1,dist+1),
                min(30-wind[alt][dist]+dp(alt,dist+1),
                20-wind[alt][dist]+dp(alt-1,dist+1)));
    }
    return ref;
}

int main() {
    int tc;
    scanf("%d",&tc);
    while(tc--){
        scanf("%d",&x);
        x/=100;
        for(int i=9;i>=0;i--){
            for(int j=0;j<x;j++){
                scanf("%d",&wind[i][j]);
            }
        }
        fill(&memo[0][0],&memo[10][0],-1);
        //memset(memo,-1,sizeof(memo));
        printf("%d\n\n",dp(0,0));
    }
    return 0;
}