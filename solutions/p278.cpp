// Apurv Parekh
// 11th Aug 2018

#include <cstdio>
#include <algorithm>
#include <cmath>

using namespace std;

int main(){
    int tc;
    scanf("%d",&tc);
    while(tc--){
        scanf("% ");
        char ch; int r,c;
        scanf("%c%d%d",&ch,&r,&c);
        int ans;
        if(ch=='r' || ch == 'Q'){
            ans=min(r,c);
        }
        else if(ch=='K'){
            ans=((r+1)/2)*((c+1)/2);
        }
        else{
            ans=((r+1)/2)*((c+1)/2)+(r/2)*(c/2);
        }
        printf("%d\n",ans);
    }
    return 0;
}