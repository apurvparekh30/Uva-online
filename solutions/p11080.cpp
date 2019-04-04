// Apurv Parekh
// July 10 2018

#include <bits/stdc++.h>

using namespace std;

vector<vector<int>> g(200,vector<int>());

int color[200];

int v,e;

int bfs(int u){
    int tot = 0;
    int black = 0;
    queue<int> q;
    q.push(u);
    while(!q.empty()){
        u = q.front();
        q.pop();
        tot++;
        int c = color[u];
        if(c == 1) black++;
        for(auto i: g[u]){
            if(color[i]==color[u]) return -1;
            if(color[i]==0) {
                color[i] = -c;
                q.push(i);
            }
        }
    }
    if(tot == 1) return 1;
    return min(black,tot-black);
}

int main() {
    int tc;
    scanf("%d",&tc);
    while(tc--){
        scanf("%d%d",&v,&e);
        memset(color,0,sizeof(color));
        for(int i=0;i<v;i++) g[i].clear();
        while(e--){
            int u,v;
            scanf("%d%d",&u,&v);
            g[u].push_back(v);
            g[v].push_back(u);
        }
        int ans=0;
        for(int i=0;i<v;i++){
            if(color[i]==0){
                color[i] = 1;
                int tmp_ans=bfs(i);
                if(tmp_ans == -1){
                    ans = tmp_ans;
                    break;
                }
                ans = ans + tmp_ans;
            }
        }
        printf("%d\n",ans);
    }
    return 0;
}