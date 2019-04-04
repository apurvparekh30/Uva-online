// Apurv Parekh
// 31th July 2018

#include <algorithm>
#include <cstdio>
#include <cstring>
#include <cctype>

using namespace std;

const int maxx = 16;

long long memo[maxx][maxx];

int col[maxx];
char str[maxx];

int n;

long long dp(int c,int r){
    if(c==n) return 1;
    long long &ref=memo[c][r];
    if(ref!=-1) return ref;
    long long ans=0;
    if(col[c+1]!=0){
        if(col[c+1]!=r && col[c+1]!=r+1 && col[c+1]!=r-1){
            ans+=dp(c+1,col[c+1]);
        }
    }
    else{
        for(int row=1;row<=n;row++){
            if(row!=r && row!=r-1 & row!=r+1){
                ans+=dp(c+1,row);
            }
        }
    }  
    return ref=ans;
}

int main(){
    while(scanf("%s",str)!=EOF){
        n=strlen(str);
        fill(&memo[0][0],&memo[n+1][0],-1);
        for(int i=1;i<=n;i++){
            char c=str[i-1];
            if(c=='?'){
                col[i]=0;
            }
            else if(isdigit(c)){
                col[i]=c-'0';
            }
            else{
                col[i]=c-'A'+10;
            }
        }
        long long ans = 0;
        if(col[1]==0){
            for(int i=1;i<=n;i++){
                ans+=dp(1,i);
            }
        }
        else{
            ans=dp(1,col[1]);
        } 
        printf("%lld\n",ans);
    }
    return 0;
}
