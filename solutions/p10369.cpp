// Apurv Parekh
// 16th July 2018

#include <algorithm>
#include <cstdio>
#include <vector>
#include <cmath>

using namespace std;

struct Edge {
    int u,v;
    double w;
    bool operator< (const Edge &b) const{
        return w<b.w;
    }
};

struct co {int x,y;};

int s,p;
co c[500];
int pr[500],r[500];
Edge e[500 * 500];
vector<Edge> mstEdges;
bool has[500];

void init(){
    fill(r,r+p,0);
    fill(has,has+p,false);
    for(int i=0;i<p;i++) pr[i]=i; 
}

double getDist(int x1,int x2,int y1,int y2){
    return sqrt((double)(x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
}

int findSet(int i){
    return (pr[i]==i) ? i:(pr[i]=findSet(pr[i]));
}

int main(){
    int tc;
    scanf("%d",&tc);
    while(tc--){
        scanf("%d%d",&s,&p);
        for(int i=0;i<p;i++){
            scanf("%d%d",&c[i].x,&c[i].y);
        }
        init();
        int index=0;
        for(int i=0;i<p;i++){
            for(int j=i+1;j<p;j++){
                int x1=c[i].x; int x2=c[j].x;
                int y1=c[i].y; int y2=c[j].y;
                double d = getDist(x1,x2,y1,y2);
                Edge tmp;
                tmp.u=i;
                tmp.v=j;
                tmp.w=d;
                e[index++]=tmp;
            }
        }
        sort(e,e+index);
        double ans;
        int noOfSets = p;
        for(int i=0;i<index;i++){
            if(p == s) break;
            int x=findSet(e[i].u);
            int y=findSet(e[i].v);
            if(x!=y){
                if(r[x]>r[y]) pr[y]=x;
                else{
                    pr[x]=y;
                    if(r[x]==r[y]) r[y]++;
                }
                p--;
                ans = e[i].w;
            }
        }
        printf("%.2lf\n",ans);
    }
    return 0;
}

