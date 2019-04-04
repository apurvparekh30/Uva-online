#include<bits/stdc++.h>

using namespace std;

//int p[100005],r[100005];
int *p,*r;
void init(int n){
    p=new int[n+1];
    r=new int[n+1];
    for(int i=1;i<=n;i++){
        p[i]=i;
        r[i]=1;
    }
}

int find(int i){
    return p[i]==i ? i:(p[i]=find(p[i]));
}

int unite(int x,int y){
    int px=find(x);
    int py=find(y);
    if(px!=py){
       
        if(r[px]>r[py]){
            r[px]+=r[py];
            p[py]=px;
            return r[px];
        }
        p[px]=py;
        r[py]+=r[px];
        return r[py];
    }
    return r[px];
}

int main() {
    int cases;
    scanf("%d",&cases);
    while(cases--){
        int f;
        scanf("%d",&f);

        init(min(2*f,100000));
        char x[30],y[30];

        int fNo=0;
        map<string,int> mp;
        while(f--){
            scanf("%s %s",&x,&y);
            int nx=mp[x];
            if(nx==0){
                mp[x]=++fNo;
                nx=fNo;
            }
            int ny=mp[y];
            if(ny==0){
                mp[y]=++fNo;
                ny=fNo;
            }
            printf("%d\n",unite(nx,ny));
        }
    }
    return 0;
}