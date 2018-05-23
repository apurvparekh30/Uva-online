#include <bits/stdc++.h>

using namespace std;

int main() {
    int cases;
    scanf("%d",&cases);
    while(cases--){
        int n;
        scanf("%d",&n);

        map<int,int>mp;
        int lastUniqueIndex=0;
        int uniqueBalls=0;

        for(int i=1;i<=n;i++){
            int ballNo;
            scanf("%d",&ballNo);
            int start=max(lastUniqueIndex,mp[ballNo]);
            uniqueBalls=max(uniqueBalls,(i-start));
            lastUniqueIndex=start;
            mp[ballNo]=i;
        }
        printf("%d\n",uniqueBalls);
    }
    return 0;
}