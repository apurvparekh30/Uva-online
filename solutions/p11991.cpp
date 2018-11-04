#include <bits/stdc++.h>
#define MAX 1000005
using namespace std;

int main() {
    int N,Q,k,v;
    vector<vector<int>> ls;
    while(scanf("%d %d",&N,&Q)==2){
        ls=vector<vector<int>>(MAX, vector<int>(0));
        for(int i=1;i<=N;i++){
            int x;
            scanf("%d",&x);
            ls[x].push_back(i);
        }
        for(int i=1;i<=Q;i++){
            scanf("%d %d",&k,&v);
            if(ls[v].size()< k){
                printf("0\n");
            }
            else {
                printf("%d\n",ls[v][k-1]);
            }
        } 
    }
    return 0;
}