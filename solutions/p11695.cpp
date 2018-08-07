// Apurv Parekh
// 7th Aug 2018

/*
Remove edge from diameter and add one
 */

#include <algorithm>
#include <cstdio>
#include <vector>
#include <cmath>

using namespace std;

const int maxx = 2505;
int n;

vector<vector<int>> g(maxx, vector<int>());

int d,fn;
int pr[maxx];

void dfs(int u,int len,int c,int p){
    if(d<len) {
        d=len;
        fn=u;
    }
    for(int v: g[u]){
        if(v==p) continue;
        if(v==c) continue;
        pr[v]=u;
        dfs(v,len+1,c,u);
    }
}

vector <int> getDiameter(int u,int c){
    d=0;
    fill(pr,pr+maxx,-1);
    fn=u    ;
    dfs(u,0,c,-1);
    d=0;
    fill(pr,pr+maxx,-1);
    dfs(fn,0,c,-1);
    vector<int> path;
    int i=fn;
    path.push_back(i);
    while(pr[i]!=-1){
        i=pr[i];
        path.push_back(i);
    }
    return path;
}

int c1,c2,a1,a2;

int main(){
    int tc; scanf("%d",&tc);
    while(tc--){
        scanf("%d",&n);
        for(int i=1;i<=n;i++) g[i].clear();
        for(int i=1;i<=n-1;i++){
            int u,v;
            scanf("%d%d",&u,&v);
            g[u].push_back(v);
            g[v].push_back(u);
        }
        vector<int> path = getDiameter(1,-1);
        int sol = n-1;
        for(int i=1;i<=path.size();i++){
            int u=path[i-1]; int v=path[i];
            vector<int> left = getDiameter(u,v);
            vector<int> right = getDiameter(v,u);
            int ls=left.size()-1;
            int rs=right.size()-1;
            int dia=max(ceil(ls/2.0)+ceil(rs/2.0)+1,max(ls*1.0,rs*1.0));
            if(dia<sol){
                sol=dia;
                c1=u; c2=v;
                a1=left[ls/2];
                a2=right[rs/2];
            }
        }   
        printf("%d\n%d %d\n%d %d\n",sol,c1,c2,a1,a2);
    }
    return 0;
}