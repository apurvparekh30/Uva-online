// Apurv Parekh

#include <algorithm>
#include <iostream>
#include <cstdio>
#include <vector>
#include <cctype>

using namespace std;

string inp;
vector<string> v;

void checkAnagram(string a, string b){
    string c=a; string d=b;
    a.erase(remove(a.begin(),a.end(),' '),a.end());
    b.erase(remove(b.begin(),b.end(),' '),b.end());
    sort(a.begin(),a.end()); sort(b.begin(),b.end());
    if(a==b){
        printf("%s = %s\n",c.c_str(),d.c_str());
    }
}   

int main() {
    int tc;
    scanf("%d",&tc);
    bool flag=false;
    while(tc--) {
        if(flag) printf("\n"); flag=true;
        v.clear();
        scanf("% ");
        while(getline(cin,inp), !inp.empty()) {
            v.push_back(inp);
        }
        sort(v.begin(),v.end());
        for(int i=0;i<v.size();i++){
            for(int j=i+1;j<v.size();j++){
                if(i==j) continue;
                checkAnagram(v[i],v[j]);
            }
        }
    }
    return 0;
}