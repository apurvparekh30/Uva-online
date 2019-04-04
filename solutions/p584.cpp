// Apurv Parekh

#include <algorithm>
#include <cstdio>
#include <iostream>
#include <sstream>

using namespace std;

int rolls[25];

inline int g(char c,char p){
    return (c=='X') ? 10:(c=='/') ? (10-g(p,'.')): c-'0';
}

int main(){
    string in;
    while(getline(cin,in), in!="Game Over"){
        fill(rolls,rolls+25,0);
        string s=""; char ch;
        stringstream ss(in);
        int i=0;
        while(ss>>ch){
            rolls[i]=g(ch,s.back());
            s+=ch;
            i++;
        }
        int score=0;
        int f=1;
        i=0;
        int curr;
        while(i<s.length()){
            if(f==11) break;
            char a,b;
            a=s[i];
            score+=rolls[i];
            if(a=='X'){
                score+=rolls[i+1]+rolls[i+2];
                f++;
                i++;
                continue;
            }
            i++;
            b=s[i];
            score+=rolls[i];
            if(b=='/'){
                score+=rolls[i+1];
            }
            i++;
            f++;
        }
        printf("%d\n",score);
    }
    return 0;
}