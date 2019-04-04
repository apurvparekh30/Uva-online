#include <bits/stdc++.h>

using namespace std;

int n,s,o;

int ft[8];

int res;

struct order{
    int source,dest,passengers;
};

order od[22];

/* int LSOne(int a){
    return a & (-a);
}

int rsq(int a){
    int sum=0;
    for(;a;a-=LSOne(a)){
        sum+=ft[a];
    }
    return sum;
}

int rsq(int s,int d){
    return rsq(d) - (s==1 ? 0:rsq(s-1));
} */

bool can(int s,int p){
    return ((ft[s]+p)<=n);
}

void adjust(int s,int d,int v){
    for(;s<d;s++) ft[s]+=v;
}

bool compare(order a,order b){
    return a.source < b.source;
}

void recur(int i,int cost){

    if(i >= o) return;

    int s=od[i].source;
    int d=od[i].dest;
    int p=od[i].passengers;
    if(can(s,p)){
        cost+= p * (d-s);
        if(res < cost){
            res = cost;
        }
        adjust(s,d,p);
        recur(i+1,cost);
        adjust(s,d,-p);
        cost-=p * (d-s);
        recur(i+1,cost);
    } 
    else {
        recur(i+1,cost);
    }
}  

/* void recur(int i,int cost,int s,int d,int p){
    if(!can(s,p)) return;

    if(cost > res){
        res=cost;
    }

    if(i>=o) return;

    adjust(s,d,p);
    recur(i+1,cost+(od[i].passengers*(od[i].dest-od[i].source)),od[i].source,od[i].dest,od[i].passengers);
    adjust(s,d,-p);
    recur(i+1,cost,0,0,0);
} */

int main() {
    while(scanf("%d %d %d",&n,&s,&o), (n || s || o)){
        res=0;
        memset(ft,0,sizeof(ft));
        memset(od,0,sizeof(od));
        
        for(int i=0;i<o;i++){
            scanf("%d %d %d",&od[i].source,&od[i].dest,&od[i].passengers);
        }
        sort(od,od+o,compare);
        recur(0,0);
        printf("%d\n",res);
    }
    return 0;
}