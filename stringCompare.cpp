#include <bits/stdc++.h>

using namespace std;
string s,t;

int isPossible() {
    if(s==t)
        return 1;
    if(s.length()<=t.length()){
        return 0;
    }
    int pos=-1;
    for(char i:t){
        string temp=s.substr(pos+1);
        pos=temp.find(i);
        if(pos==-1){
            return 0;
        }
    }
    return 1;
}

int main(){
    cin>>s>>t;
    cout<<isPossible(); 
    return 0;
}