#include <bits/stdc++.h>

using namespace std;

int main() {
    string s;
    start:
    while(getline(cin,s)){
        if(s.empty()){
            getline(cin,s);
        }
        int n=stoi(s,NULL);
        getline(cin,s);
        int m=stoi(s,NULL);
        int waked=0;
        int toBeWaked=0;
        bitset<26> present(0);
        getline(cin,s);

        int len=s.length();

        for(int i=0;i<len;i++){
            waked|=1<<(s[i]-'A');
            toBeWaked|=1<<(s[i]-'A');
        }

        /* waked|=1<<(s[0]-'A');
        waked|=1<<(s[1]-'A');
        waked|=1<<(s[2]-'A');

        toBeWaked|=1<<(s[0]-'A');
        toBeWaked|=1<<(s[1]-'A');
        toBeWaked|=1<<(s[2]-'A'); */

        list<char> lst[26];
        for(int i=0;i<m;i++){
            getline(cin,s);
            toBeWaked|=1<<(s[0]-'A');
            toBeWaked|=1<<(s[1]-'A');
            present[s[0]-'A']=1;
            present[s[1]-'A']=1;
            lst[s[0]-'A'].push_back(s[1]);
            lst[s[1]-'A'].push_back(s[0]);
        }   

        if(waked == toBeWaked && len==n){
            cout<< "WAKE UP IN, 0, YEARS\n";
            continue;
        }
        int year=1;
        while(1){
            int thisYear=0;
            for(int i=0;i<26;i++){
                if((!present[i]) || ((waked&(1<<i))!=0)) continue;
                int neighbours=0;
                for(auto j:lst[i]){
                    if((waked&(1<<(j-'A')))!=0)
                        neighbours++;
                    if(neighbours>=3) {
                        thisYear|=1<<i;
                        break;
                    }
                }
            }
            if(thisYear==0){
                cout<<"THIS BRAIN NEVER WAKES UP\n";
                goto start;
            }
            waked|=thisYear;
            if(waked==toBeWaked) break;
            year++;
        }     
        cout<< "WAKE UP IN, "<<year <<", YEARS\n";

    }
    return 0;
}

/*
6
11
HAB
AB
AC
AH
BD
BC
BF
CD
CF
CH
DF
FH
*/