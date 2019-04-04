/* The trick with this problem is we can choose at most 2
 Dim Sum. Its better 2 double the dim sum 
 
 Got hint to do
  // total = total + ceil ((total * 10) / 100)
    total = ceil((double)total * 1.1L);
  */

#include <bits/stdc++.h>

using namespace std;

int N,x,T,K;

int p[200];
int f[200];

int memo[201][20001][21];

int dp(int i,int sum,int c){
    int total = sum + (N+1) * T;
    // total = total + ceil ((total * 10) / 100)
    total = ceil((double)total * 1.1L);
    if(total>(N+1)*x) return INT_MIN;
    if(c>(2*(N+1))) return INT_MIN;
    if(i==2*K) return 0;
    int &ref = memo[i][sum][c];
    if(ref!=-1) return ref;
    return ref=max(dp(i+1,sum,c),f[i]+dp(i+1,sum+p[i],c+1));
}

int main() {

    while(scanf("%d%d%d%d",&N,&x,&T,&K), N+x+T+K!=0 ){
        for(int i=0;i<2*K;i+=2){
            scanf("%d",&p[i]);
            p[i+1] = p[i];
            int total = 0;
            for(int j=1;j<=N+1;j++){
                int curr;
                scanf("%d",&curr);
                total+=curr;
            }
            f[i]=(f[i+1]=total);
        }
        memset(memo,-1,sizeof(memo));
        printf("%.2lf\n",(double)dp(0,0,0)/(double)(N+1));
    }
    return 0;
}