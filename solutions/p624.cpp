#include <bits/stdc++.h>

using namespace std;

int n,t;
int *trackLength;
/*int solution(int i,int sum){
    //printf("ghello\n");
    int c=0;
    if(i>=t) return sum;
    if(sum+trackLength[i] > n){
        c=solution(i+1,sum);
        return c;
    }
    else {
        int a = solution(i+1,sum+trackLength[i]);
        int b = solution(i+1,sum);
        return max(a,b);
    }
}*/

int ans,mask=0;

void solution(int i,int total,int m){
    if(total>n) return;
    if(total > ans) {
        ans = total;
        mask=m;
    }
    if(i>=t) return;
    solution(i+1,total+trackLength[i],m|(1<<i));
    solution(i+1,total,m);
}

void solve() {
    while(scanf("%d",&n)!=EOF){
        trackLength=new int[n];
        scanf("%d",&t);
        for(int i=0;i<t;i++){
            scanf("%d",&trackLength[i]);
        }
        mask=0;
        ans=0;
        solution(0,0,0);
        for(int i=0;i<t;i++){
            if(mask & (1<<i)){
                printf("%d ",trackLength[i]);
            }
        }
        printf("sum:%d\n",ans);
    }
}

int main() {
    solve();
    return 0;
}