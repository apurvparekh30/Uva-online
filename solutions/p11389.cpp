#include <bits/stdc++.h>

using namespace std;

int main() {
    int n,d,r;
    while(scanf("%d%d%d",&n,&d,&r), (n || d || r)){
        int morning[n];
        int evening[n];
        for(int i=0;i<n;i++){
            scanf("%d",&morning[i]);
        }
        sort(morning,morning+n);
        for(int i=0;i<n;i++){
            scanf("%d",&evening[i]);
        }
        sort(evening,evening+n,greater<int>());
        int extraHours=0;
        for(int i=0;i<n;i++){
            int hrs = morning[i] + evening[i];
            if(hrs > d){
                extraHours += (hrs-d);
            }
        }
        printf("%d\n",(extraHours*r));
    }
    return 0;
}