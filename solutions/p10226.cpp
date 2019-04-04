#include <bits/stdc++.h>

using namespace std;

int main() {
    string s;
    getline(cin,s);
    int cases=stoi(s,NULL);
    getline(cin,s);
    while(cases--){
        int total=0;
        map<string,int> mp;
        while(1){
            getline(cin,s);
            if(s.empty()) break;
            mp[s]++;
            total++;
        }
        for(auto i:mp){
            //printf("%s\n",i.first);
            cout<<i.first<<" ";
            float per=float(i.second*100)/float(total);
            printf("%.4f\n",per);
        }

        if(cases>0) printf("\n");
    }

    return 0;
}