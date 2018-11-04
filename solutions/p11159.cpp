// Apurv Parekh
// 10th Aug 2018

#include <algorithm>
#include <cstdio>
#include <vector>

using namespace std;
using vi=vector<int>;

const int maxx = 201;

vector<vi> g(maxx,vi());
vector<int> A,B;
int match[maxx];
bool v[maxx];

int n,m;

int Aug(int u){
    if(v[u]) return 0;
    v[u]=true;
    for(int v:g[u]){
        if(match[v]==-1 || Aug(match[v])){
            match[v]=u;
            return 1;
        }
    }
    return 0;
}

int main(){
    int tc; scanf("%d",&tc);
    for(int t=1;t<=tc;t++){
        A.clear();
        B.clear();
        fill(match,match+maxx,-1);
        for(int i=0;i<maxx;i++) g[i].clear();
        scanf("%d",&n);
        for(int i=0;i<n;i++){
            int no; scanf("%d",&no);
            A.push_back(no);
        }
        scanf("%d",&m);
        for(int i=0;i<m;i++){
            int no; scanf("%d",&no);
            B.push_back(no);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!B[j] || (A[i] && B[j]%A[i]==0))
                    g[i].push_back(j+n);
            }
        }
        int MCBM=0;
        for(int i=0;i<n;i++){
            fill(v,v+maxx,false);
            MCBM+=Aug(i);
        }
        printf("Case %d: %d\n",t,MCBM);
    }
    return 0;   
}