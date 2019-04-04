#include <bits/stdc++.h>

using namespace std;

#define INF 10000000

//int memo[20001];
pair<int,int> memo[100][10001];
int n;
int arr[100];


pair<int,int> copy(pair<int,int> tmp){
    return make_pair(tmp.first,tmp.second+1);
}
/* pair<int,int> dp(int amt){
    if(amt <= 0) {
        return make_pair(amt,0);
    }
    if(memo[amt].second != -1) return memo[amt];
    pair<int,int> minimum = make_pair(INT_MIN,INT_MAX);
    for(int i=0;i<n;i++){
        pair<int,int> tmp = dp(amt-arr[i]);
        if(tmp.first > minimum.first){
            minimum = copy(tmp);
        }
        else if(tmp.first == minimum.first){
            if(tmp.second < minimum.second) 
                minimum = copy(tmp);
        }
    }
    return memo[amt] = minimum;
} */

pair<int,int> dp(int i,int amt){
    if(amt <= 0) return make_pair(0,0);
    if(i == n) return make_pair(INF,INF);
    if(memo[i][amt].second !=-1) return memo[i][amt];
    pair<int,int> & v = memo[i][amt];
    v = dp(i+1,amt-arr[i]);
    v.first+=arr[i];
    v.second++;
    v=min(v,dp(i+1,amt));
    return v;
}

int main() {

    int tc;
    scanf("%d",&tc);
    while(tc--){
        int amt; 
        scanf("%d",&amt);
        scanf("%d",&n);
        for(int i=0;i<n;i++){
            scanf("%d",&arr[i]);
        }
        //fill(&memo[0][0],&memo[10001][10001],make_pair(-1,-1));
        for(int i=0;i<n;i++) for(int j=0;j<=amt;j++)
            memo[i][j].second = -1;
        pair<int,int> ans = dp(0,amt);
        printf("%d %d\n",ans.first,ans.second);
    }
}