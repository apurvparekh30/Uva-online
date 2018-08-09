// Apurv Parekh
// 8th Aug 2018


#include <algorithm>
#include <cstdio>

using namespace std;

const int maxx = 200;

int inDec[maxx];
int outDec[maxx];

int n,r;

int main(){
    while(scanf("%d%d",&n,&r)==2){
        fill(inDec,inDec+maxx,0);
        fill(outDec,outDec+maxx,0);
        while(r--){
            int u,v;
            scanf("%d%d",&u,&v);
            outDec[u]++;
            inDec[v]++;
        }
        int bad=false;
        int inDiff=0;
        int outDiff=0;
        for(int i=0;i<n;i++){
            int res = inDec[i]-outDec[i];
            if(res==0) continue;
            else if(res>1 || res<-1){
                bad=true;
                break;
            }
            else if(res==1) inDiff++;
            else if(res==-1) outDiff++;
        }
        if(bad || inDiff>1 || outDiff>0){
            printf("Not Possible\n");
        }
        else{
             printf("Possible\n");
        }
    }
    return 0;
}