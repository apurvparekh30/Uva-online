#include <bits/stdc++.h>

using namespace std;

int n,m;
int q;
int L,U;
vector<vector<int>>  arr(500,vector<int>(500));

int solve() {
    int res = 0;
    for(int i=0;i<n;i++){
        int s=0;
        auto lo_it=lower_bound(arr[i].begin(),arr[i].begin()+m-1,L);
        int col = distance(arr[i].begin(),lo_it);
        for(int j=0;(i+j)< n && (col+j) < m;j++){
            int rDiag = i+j;
            int colDiag = col+j;
            if(arr[rDiag][colDiag] >=L && arr[rDiag][colDiag] <= U){
                s++;
            }
            else {
                break;
            }
        }
        res = max(res,s);
    }
    return res;
}

int main(){
    while(scanf("%d %d",&n,&m),(n && m)){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                scanf("%d",&arr[i][j]);
            }
        }
        scanf("%d",&q);
        while(q--){
            scanf("%d %d",&L,&U);
            printf("%d\n",solve());
        }
        printf("-\n");
    }
    return 0;
}


//17110 33060