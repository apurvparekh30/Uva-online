// Apurv Parekh

#include <iostream>
#include <cstdio>
#include <string>
#include <algorithm>

using namespace std;

bool isplm(string s){
    string tmp = s;
    reverse(s.begin(),s.end());
    return s==tmp;
}

int main(){
    string s;
    while(getline(cin,s), s!="DONE"){
        int len=s.length();
        string s1;
        int i=0;
        for(char c:s){
            if(c>='A' && c<='Z'){
                s1+=c+32;
            }
            else if(c>='a' && c<='z'){
                s1+=c;
            }
        }
        if(isplm(s1))
            printf("You won't be eaten!\n");
        else    
            printf("Uh oh..\n");
    }
    return 0;
}