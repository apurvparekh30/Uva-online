#include <bits/stdc++.h>
using namespace std;

int main() {
    uint n,m;
    while(scanf("%u %u",&n,&m) , (n || m)){
        unordered_map<uint,bool> mp;
        uint num;
        while(n--){
            scanf("%u",&num);
            mp[num]=true;
        }
        uint count=0;
        while(m--){
            scanf("%u",&num);
            if(mp[num]) count++;
        }
        printf("%u\n",count);
    }

    return 0;
}