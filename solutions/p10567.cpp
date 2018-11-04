#include <bits/stdc++.h>

using namespace std;

string s,ss;
vector<int> v[52];
int first,last;
int getIdx(char c){
    if(c>='a'){
        return (c-'a')+26;
    }
    return c-'A';
}

bool solve(string ss){
    last=-1;
    bool firstChar=true;

    for(char c:ss){
        int idx=getIdx(c);
        auto it = lower_bound(v[idx].begin(),v[idx].end(),last+1);
        if(it==v[idx].end()){
            return false;
        }
        if(firstChar) {
            first=*it;
            firstChar=false;
        } 
        last = *it;
    }
    return true;
}   

int main() {
    cin>>s;
    for(int i=0;i<s.length();i++){
        int idx = getIdx(s[i]);
        v[idx].push_back(i);
    }
    int q;
    scanf("%d",&q);
    
    while(q--){
        cin>>ss;
        if(solve(ss)){
            printf("Matched %d %d\n",first,last);
        }
        else {
            printf("Not matched\n");
        }
    }
    return 0;
}