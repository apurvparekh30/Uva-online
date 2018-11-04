// Apurv Parekh

#include <algorithm>
#include <unordered_map>
#include <iostream>
#include <vector>
#include <sstream>
#include <cstdio>

using namespace std;

string s;
vector<string> v;
unordered_map<string,int> mp;

char easytolower(char in) {
  if(in <= 'Z' && in >= 'A')
    return in - ('Z' - 'z');
  return in;
}

int main() {
    
    while(getline(cin,s), s!="#"){
        stringstream ss(s);
        string token;
        while(ss>>token){
            v.push_back(token);
            transform(token.begin(),token.end(),token.begin(),easytolower);
            sort(token.begin(),token.end());
            mp[token]++;
        }
    }
    sort(v.begin(),v.end());
    for(string st:v){
        string str=st;
        transform(st.begin(),st.end(),st.begin(),easytolower);
        sort(st.begin(),st.end());
        if(mp[st]==1) printf("%s\n",str.c_str());
    }
    return 0;
}