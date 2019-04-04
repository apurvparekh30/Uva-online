#include <bits/stdc++.h>

using namespace std;

int i1,i2,d1,d2;
int p[14];
int q[14];

int n,m;

bool backtrack(int curr,int L,int mask){
    if(L==n){
        if(curr==d1) return true;
        return false;
    }
    for(int i=0;i<m;i++){
        if((mask&(1<<i))!=0) continue;
        if(p[i]==curr || q[i]==curr){
            if(p[i]==curr){
                if(backtrack(q[i],L+1,mask|(1<<i))){
                    return true;
                }
            }
            else {
                if(backtrack(p[i],L+1,mask|(1<<i))){
                    return true;
                }
            }
        }
    }
    return false;
}

int main() {
    while(scanf("%d",&n),n){
        scanf("%d",&m);
        scanf("%d %d",&i1,&i2);
        scanf("%d %d",&d1,&d2);

        for(int i=0;i<m;i++){
            scanf("%d %d",&p[i],&q[i]);
        }   
    
        if(backtrack(i2,0,0)){
            printf("YES\n");
        }
        else {
            printf("NO\n");
        }
    }
    return 0;
}