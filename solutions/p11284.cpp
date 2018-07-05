#include <bits/stdc++.h>

using namespace std;

#define maxn 51
#define maxp 13

const int INF = 1e7;

int D[maxn][maxn];
int n,m,p;

int value[maxp];
int Index[maxp];

int memo[maxp][1<<maxp];

void fw(){
    for(int i=0;i<n;i++) D[i][i] = 0;
    for(int k=0;k<n;k++)
     for(int i=0;i<n;i++)
      for(int j=0;j<n;j++)
        D[i][j] = min(D[i][j],D[i][k]+D[k][j]); 
}

int dp(int curr,int mask){
    if(mask == (1<<maxp)-1) return -D[Index[curr]][0];
    int &ref = memo[curr][mask];
    if(ref==-1){
        // go back immediately
        ref = -D[Index[curr]][0];
        for(int i=0;i<p;i++){
            if(mask & (1<<i)) continue;
            int t = value[i]-D[Index[curr]][Index[i]]+
                    dp(i,mask|(1<<i));
            // go back immediately for taking i'th store
            ref = max(ref,t);
        }
    }
    return ref;
}

int main() {
    int tc;
    scanf("%d",&tc);
    while(tc--){
        scanf("%d%d",&n,&m);
        n++;
        fill(&D[0][0],&D[maxn][0],INF);
        for(int i=0;i<m;i++){
            int a,b;
            double c;
            scanf("%d%d%lf",&a,&b,&c);
            int t = round(c*100);
            t = min(t,D[a][b]);
            D[a][b] = D[b][a] = t;
        }    
        fw();
        scanf("%d",&p);
        p++;
        value[0] = 0;
        Index[0] = 0; 
        for(int i=1;i<p;i++){
            double c;
            scanf("%d%lf",&Index[i],&c);
            value[i] = round(c*100);
        }

        fill(&memo[0][0],&memo[maxp][0],-1);
        int ans = dp(0,1);
        if(ans > 0)
            printf("Daniel can save $%.2f\n",double(ans)/100.0);
        else    
            printf("Don't leave the house\n");
        
    }
    return 0; 
}