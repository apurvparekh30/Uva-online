// Apurv Parekh

#include <algorithm>
#include <queue>
#include <cstdio>
#include <iostream>
#include <sstream>

using namespace std;

struct vertex{
    int f,l,c;
    vertex(int a,int b,int c){
        f=a; l=b; this->c=c;
    }
    bool operator <(const vertex& b)const{
        return this->c>b.c;
    }
};

vector<vector<vertex>> g(101,vector<vertex>());
int dist[6][101];
int t[6];
int n,k;

void init(){
    for(int i=0;i<101;i++) g[i].clear();
    fill(&dist[0][0],&dist[6][0],1e9);
}
int main(){
    while(scanf("%d%d",&n,&k) == 2){
        init();
        for(int i=1;i<=n;i++) scanf("%d",&t[i]);
        cin.ignore();
        priority_queue<vertex>pq;
        for(int i=1;i<=n;i++){
            string line;
            getline(cin,line);
            stringstream ss(line);
            int curr=-1;
            int to;
            while(ss>>to){
                if(to==0){
                    pq.push(vertex(to,i,0));
                    dist[i][0]=0;
                }
                if(curr==-1){
                    curr=to; 
                    continue;
                }
                g[curr].push_back(vertex(to,i,t[i]*(to-curr)));
                g[to].push_back(vertex(curr,i,t[i]*(to-curr)));
                curr=to;
            }
        }
        while(!pq.empty()){
            vertex curr=pq.top();pq.pop();
            int f=curr.f; int l=curr.l; int c=curr.c;
            if(dist[l][f]<c) continue;
            for(vertex next: g[f]){
                int nf=next.f;int nl=next.l;int nc=next.c;
                if(l==nl){
                    if(dist[nl][nf]>dist[l][f]+nc){
                        dist[nl][nf]=dist[l][f]+nc;
                        pq.push(vertex(nf,nl,dist[nl][nf]));
                    }
                }
                else{
                    if(dist[nl][nf]>dist[l][f]+nc+60){
                        dist[nl][nf]=dist[l][f]+nc+60;
                        pq.push(vertex(nf,nl,dist[nl][nf]));
                    }
                }  
            }
        }
        int ans=1e9;
        for(int i=1;i<=n;i++){
            ans=min(ans,dist[i][k]);
        }
        if(ans==1e9){
            printf("IMPOSSIBLE\n");
        }
        else{
            printf("%d\n",ans);
        }
    }
    return 0;   
}



