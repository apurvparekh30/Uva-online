#include <bits/stdc++.h>

using namespace std;

int main() {
    int cases;
    while(scanf("%d",&cases) && cases){
        map<string,int> mp;
        int maxN=-1;
        string s[5];
        while(cases--){
            cin>>s[0]>>s[1]>>s[2]>>s[3]>>s[4];
            sort(s,s+5);
            string combination="";
            for(auto i:s)
                combination+=i;
            if(!mp[combination]){
                mp[combination]++;
                maxN=max(maxN,1);
            }
            else {
                mp[combination]++;
                maxN=max(maxN,mp[combination]);
            }
        }
        int count=0;
        for(auto i:mp){
            if(i.second==maxN)
                count+=i.second;
        }
        printf("%d\n",count);
    }
    return 0;
}