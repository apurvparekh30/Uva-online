#include <bits/stdc++.h>

using namespace std;

const int maxx = 'Z' - 'A' + 1;

char chars[21];
int len;

int g[maxx][maxx];

bool invalid(int i,int mask){
    for(int j=0;j<len;j++){
        if(g[chars[j]-'A'][i]){
            if(mask&(1<<(chars[j]-'A'))) continue;
            return true;
        } 
    }
    return false;
}

bool  backtrack(string s,int mask,int count){
    if(count==0){
        printf("%c",s[0]);
        for(int i=1;i<len;i++) printf(" %c",s[i]);
        printf("\n");
        return true;
    }
    bool ans = false;
    for(int i=0;i<len;i++){
        if(mask&(1<<(chars[i]-'A'))) continue;
        if(invalid(chars[i]-'A',mask)) continue;
        ans = (backtrack(s+chars[i],mask|(1<<(chars[i]-'A')),count-1)||ans);
    }
    return ans;
}

int main(){
    int tc;
    scanf("%d",&tc);
    bool flag = false;
    while(tc--){
        if(flag) printf("\n"); else flag=true;
        memset(g,0,sizeof(g));
        len=0;
        string line;
        scanf("% ");
        getline(cin,line);
        stringstream ss(line);
        while(ss>>chars[len]) len++;
        sort(chars,chars+len);
        getline(cin,line);
        string token;
        ss.clear();
        ss.str(line);
        while(ss>>token){
            g[token[0]-'A'][token[2]-'A'] = 1;
        }
        if(!backtrack("",0,len)){
            printf("NO\n");
        }
    }
    return 0;
}