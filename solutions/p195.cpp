// Apurv Parekh

#include <algorithm>
#include <cstdio>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

int l;
string s;
bool v[100];

unordered_map<string,bool> mp;

bool cmp(char a,char b){
    if(tolower(a) == tolower(b))
        return a<b;
    return tolower(a) < tolower(b);
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
        do{
            printf("%s\n",s.c_str());
        }while(next_permutation(s.begin(),s.end(),cmp));
    }
    return 0;
}