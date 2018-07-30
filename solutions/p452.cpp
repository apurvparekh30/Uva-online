// Apurv Parekh
// 30th July 2018

#include <algorithm>
#include <queue>
#include <iostream>
#include <cstdio>
#include <unordered_map>
#include <sstream>

using namespace std;

const int maxx = 26;

int cost[maxx];
vector<vector<int>> g(maxx,vector<int>());
int dist[maxx];

int dfs(int u){
    int &time=dist[u];
    if(time) return time;
    for(int i:g[u]){
        time=max(time,dfs(i));
    }
    time+=cost[u];
    return time;
}

int main(){
    int tc;
    scanf("%d",&tc);
    bool flag=false;
    while(tc--){
        for(int i=0;i<maxx;i++) g[i].clear();
        fill(cost,cost+maxx,0);
        // input
        scanf("% ");
        string str;
        while(1){
            getline(cin,str);
            if(str.empty()) break;
            stringstream ss(str);
            char n;
            int w;
            string s;
            ss>>n>>w>>s;
            cost[n-'A']=w;
            for(char c:s){
                g[c-'A'].push_back(n-'A');
            }
        }

        // algorithm
        fill(dist,dist+maxx,0);
        for(int i=0;i<maxx;i++){
            dfs(i);
        }

        int worstTime=0;
        for(int i=0;i<maxx;i++){
            worstTime=max(worstTime,dist[i]);
        }

        // output
        if(flag) printf("\n"); flag=true;
        printf("%d\n",worstTime);
    }
    return 0;   
}