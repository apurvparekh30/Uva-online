#include <bits/stdc++.h>

using namespace std;

struct computer{
    int x,y;
};

double dist(computer a, computer b){
    return 16.0 + sqrt((double)(a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
}

vector<computer> comp(8);


double memo[8][256];
int memoNext[8][256];
int n;
int limit;

double dp(int curr,int mask){
    if(mask == limit) return 0;
    if(memo[curr][mask]!=0) return memo[curr][mask];
    double minimum = numeric_limits<double>::max();
    for(int i=0;i<n;i++){
        if((mask & (1<<i)) == 0){
            double ans = dist(comp[curr],comp[i]) + dp(i,(mask|(1<<i)));
            if(ans < minimum){
                minimum = ans;
                memoNext[curr][mask] = i;
            }
        }
    }
    return memo[curr][mask] = minimum;
}

int main(){
    int tc=0;
    while(scanf("%d",&n), n){
        tc++;
        for(int i=0;i<n;i++){
            computer c;
            scanf("%d%d",&c.x,&c.y);
            comp[i] = c;
        }
        limit = pow(2,n)-1;
        memset(memo,0,sizeof(memo));
        memset(memoNext,-1,sizeof(memoNext));
        double total = numeric_limits<int>::max();        
        int current = 0;
        for(int i=0;i<n;i++){
            double d = dp(i,1<<i);
            if(d<total){
                total = d;
                current = i;
            }
        }
        printf("**********************************************************\nNetwork #%d\n", tc);
        int mask = 0;
        for (int i=0;i<n-1;i++){
            mask|=(1<<current);
            int next = memoNext[current][mask];
            double d = dist(comp[current],comp[next]);
            printf("Cable requirement to connect (%d,%d) to (%d,%d) is %.2f feet.\n",
                comp[current].x,comp[current].y,comp[next].x,comp[next].y,d);
            current = next;
        }
        printf("Number of feet of cable required is %.2f.\n", total);
    }
}
