// Apurv Parekh
// 17th July 2018

#include <algorithm>
#include <cstdio>
#include <queue>

using namespace std;

int E,tc;
vector<vector<int>> g(2500,vector<int>());
int main(){
    scanf("%d",&E);
    for(int u=0;u<E;u++){
        int n;scanf("%d",&n);
        while(n--){
            int v;
            scanf("%d",&v);
            g[u].push_back(v);
        }
    }
    scanf("%d",&tc);
    while(tc--){
        int u;
        scanf("%d",&u);
        if(g[u].empty()){
            printf("0\n");
            continue;
        } 
        queue<int> q;
        q.push(u);
        vector<bool> inQ(2500);
        int boom=0,boomday;
        int day[2500],informed[2500];
        int p[2500];
        fill(day,day+2500,0);
        fill(informed,informed+2500,0);
        p[u]=u;
        inQ[u]=true;
        informed[u]=-1;
        int source = u;
        while(!q.empty()){
            u=q.front(); q.pop();
            informed[u]=informed[p[u]]+1;
            day[informed[u]]++;
            if(boom < day[informed[u]] || p[u]==source){
                boom=day[informed[u]];
                boomday=informed[u];
            }
            for(auto v:g[u]){
                if(inQ[v]) continue;
                inQ[v]=true;
                p[v]=u;
                q.push(v);
            }
        }
        printf("%d %d\n",boom,boomday);
    }
    return 0;
}