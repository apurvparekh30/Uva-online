// Apurv Parekh
// 15th July 2018

#include <bits/stdc++.h>

using namespace std;

struct co{int x,y; };
struct edge{ 
    int u,v; double w;
    bool operator <(const edge& b) const {
        return w<b.w;
    }
};

int rnk[1001],p[1001];
int n,r;
edge e[1000 * 1000];
co c[1000];

void init(){
    fill(rnk,rnk+n,0);
    for(int i=0;i<n;i++) p[i] = i;
}

double getDist(int x1,int x2,int y1,int y2){
    return sqrt((double) (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
}

int findset(int i){
    return (p[i] == i) ? i:(p[i] = findset(p[i]));
}

int main() {
    int tc;
    scanf("%d",&tc);
    for(int t=1;t<=tc;t++){
        scanf("%d%d",&n,&r);
        init();
        for(int i=0;i<n;i++){
            co tmp;
            scanf("%d%d",&tmp.x,&tmp.y);
            c[i] = tmp;
        } 
        int index=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(i==j) continue;
                int x1=c[i].x; int x2=c[j].x;
                int y1=c[i].y; int y2=c[j].y;
                double d = getDist(x1,x2,y1,y2);
                edge tmp;
                tmp.u=i; tmp.v=j; tmp.w=d;
                e[index++] = tmp;
            }
        }
        sort(e,e+index);
        double rd = 0,tr = 0;
        int s = 0;
        for(int i=0;i<index;i++){
            int x = findset(e[i].u);
            int y = findset(e[i].v);
            if(x!=y){
                if(rnk[x] > rnk[y]) p[y] = x;
                else {
                    p[x] = y;
                    if(rnk[x] == rnk[y]) rnk[y]++;
                } 
                if(e[i].w > r) tr+=e[i].w;
                else{
                    rd+=e[i].w;
                    s++;
                } 
            }
        }

        printf("Case #%d: %d %d %d\n",t,n-s,(int)round(rd),(int)round(tr));
    }
   

    return 0;
}