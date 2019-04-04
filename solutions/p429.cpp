// Apurv Parekh
// 17th May 2016

#include <algorithm>
#include <cstdio>
#include <queue>
#include <unordered_map>
#include <vector>
#include <string>
#include <iostream>
#include <sstream>

using namespace std;

vector<string> words(201);
unordered_map <string,int> toIndex;
vector<vector<int>> g(201,vector<int>());

void init(){
    for(int i=0;i<201;i++) g[i].clear();
    toIndex.clear();
}

bool validEdge(string a, string b){
    if(a.length()!=b.length()) return false;
    int len = a.length();
    int diff=0;
    for(int i=0;i<len;i++){
        if(a[i]!=b[i]) diff++;
        if(diff > 1) return false;
    }
    return true;
}

int main(){
    int tc;
    bool flag=false;
    scanf("%d",&tc);
    while(tc--){
        init();
        if(flag) printf("\n"); flag=true;
        int wcount=0;
        while(1){
            cin>>words[wcount];
            if(words[wcount]=="*") break;
            toIndex[words[wcount]] = wcount;
            wcount++;
        }
        for(int i=0;i<wcount;i++){
            for(int j=i+1;j<wcount;j++){
                if(validEdge(words[i],words[j])){
                    g[toIndex[words[i]]].push_back(toIndex[words[j]]);
                    g[toIndex[words[j]]].push_back(toIndex[words[i]]);
                }
            }
        }
        cin.ignore();
        
        string line;
        while(getline(cin,line), line!=""){
            stringstream ss(line);
            string s1,s2;
            ss>>s1>>s2;
            int u=toIndex[s1],v=toIndex[s2];
            queue<int> q;
            q.push(u);
            int visited[201],level[201],p[201];
            fill(visited,visited+201,0);
            int steps;
            visited[u]=1;
            p[u]=u;
            level[u]=-1;
            while(!q.empty()){
                u = q.front(); q.pop();
                level[u] = level[p[u]]+1;
                if(u == v) break;
                for(auto i:g[u]){
                    if(visited[i])continue;
                    visited[i]=1;
                    p[i]=u;
                    q.push(i);
                }
            } 
            printf("%s %s %d\n",s1.c_str(),s2.c_str(),level[v]);          
        }
    }
    return 0;
}