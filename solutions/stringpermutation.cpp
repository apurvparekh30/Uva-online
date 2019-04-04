// Apurv Parekh

#include <algorithm>
#include <cstdio>
#include <string>
#include <unordered_map>

using namespace std;

int l;
string s;
bool v[100];

unordered_map<string,bool> mp;

void bk(string tmp){
    if(tmp.length() == l){
        if(mp[tmp]) return;
        printf("%s\n",tmp.c_str());
        mp[tmp]=true;
        return;
    }
    for(int i=0;i<l;i++){
        if(v[i]) continue;
        v[i]=true;
        bk(tmp+s[i]);
        v[i]=false;
    }
}

bool cmp(char a,char b){
    if(a > 'Z') a=a-32;
    if(b > 'Z') b=b-32;
    return a<b;
}

int main(){
    int tc;
    scanf("%d",&tc);
    while(tc--){
        mp.clear();
        fill(v,v+100,false);
        char str[100];
        scanf("%s",str);
        s = string(str);
        sort(s.begin(),s.end(),cmp);
        l=s.length();
        bk("");
    }
    return 0;
}