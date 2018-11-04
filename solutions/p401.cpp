// Apurv Parekh

#include <algorithm>
#include <string>
#include <iostream>
#include <unordered_map>
#include <cstdio>

using namespace std;

unordered_map<char,char> mp;
bool mirr,pln;

int main(){
    mp.insert(make_pair('E','3'));
    mp.insert(make_pair('3','E'));
    mp.insert(make_pair('J','L'));
    mp.insert(make_pair('L','J'));
    mp.insert(make_pair('O','O'));
    mp.insert(make_pair('Z','5'));
    mp.insert(make_pair('5','Z'));
    mp.insert(make_pair('S','2'));
    mp.insert(make_pair('2','S'));
    mp.insert(make_pair('A','A'));
    mp.insert(make_pair('H','H'));
    mp.insert(make_pair('I','I'));
    mp.insert(make_pair('M','M'));
    mp.insert(make_pair('T','T'));
    mp.insert(make_pair('U','U'));
    mp.insert(make_pair('V','V'));
    mp.insert(make_pair('W','W'));
    mp.insert(make_pair('X','X'));
    mp.insert(make_pair('Y','Y'));
    mp.insert(make_pair('1','1'));
    mp.insert(make_pair('8','8'));

    string s;
    while(cin>>s){
        pln=mirr=true;
        int ei = s.length()-1;
        int i=0;
        int len=ei+1;
        for(;i<len;i++,ei--){
            if(pln){
                if(s[i]!=s[ei]){
                    pln=false;
                }
            }
            if(mirr){
                if(s[ei]!=mp[s[i]]){
                    mirr=false;
                }
            }
        }
        if(pln && mirr)
            printf("%s -- is a mirrored palindrome.\n\n",s.c_str());
        else if(pln)
            printf("%s -- is a regular palindrome.\n\n",s.c_str());
        else if(mirr)
            printf("%s -- is a mirrored string.\n\n",s.c_str());
        else    
            printf("%s -- is not a palindrome.\n\n",s.c_str());
    }
}