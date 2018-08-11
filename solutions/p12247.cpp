// Apurv Parekh
// 11th Aug 2018

#include <algorithm>
#include <cstdio>

using namespace std;

bool v[53];
int main(){
    int a,b,c,x,y;
    while(scanf("%d%d%d%d%d",&a,&b,&c,&x,&y), (a||b||c||x||y)){
        fill(v,v+53,false);
        v[a]=v[b]=v[c]=v[x]=v[y]=true;
        int p[3]; p[0]=a; p[1]=b; p[2]=c;
        sort(p,p+3);
        int q[3]; 
        int z;
        int ans=-1;
        for(int i=1;i<=52;i++){
            if(v[i]) continue;
            z=i;
            q[0]=x; q[1]=y; q[2]=z;
            sort(q,q+3);
            int qi=0;
            int pi;
            for(pi=0;pi<3;pi++){
                if(p[pi]>q[qi]) break;
            }
            bool flag=true;
            qi++;
            pi++;
            for(;pi<3;pi++){
                if(p[pi]>q[qi]){
                    flag=false;break;
                }
            }
            if(flag){
                ans=z;
                break;
            }
        }
        printf("%d\n",ans);
    }
    return 0;
}