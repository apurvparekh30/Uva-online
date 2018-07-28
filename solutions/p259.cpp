// Apurv Parekh
// 27th July

#include <algorithm>
#include <cstdio>
#include <iostream>
#include <string>
#include <queue>

using namespace std;

const int maxx=38;
const int INF=1e9;

inline int g(char a) { return a-'A'+1; }
inline int gg(char a) { return a-'0'+27; }

int res[maxx][maxx];
int f,sr=0,t=37;
int visited[maxx];
int p[maxx];

void augment(int v,int minEdge){
    if(v==sr) {f=minEdge; return; }
    else if(p[v]!=-1){
        augment(p[v],min(minEdge,res[p[v]][v]));
        res[p[v]][v]-=f;
        res[v][p[v]]+=f;
    }
}

int main(){
    string s;
    while(getline(cin,s)){
        fill(&res[0][0],&res[maxx][0],0);
        int total=0;
        do{
            char a=s[0];
            int n=s[1]-'0';
            res[sr][g(a)]=n;
            for(int i=3;;i++){
                if(s[i]==';') break;
                res[g(a)][gg(s[i])]=INF;
                res[gg(s[i])][t]=1;
            }
            total+=n;
            getline(cin,s);
        }while(!s.empty());
        int count=0;
        while(1){
            f=0;
            queue<int> q;
            fill(visited,visited+maxx,0);
            fill(p,p+maxx,-1);
            visited[sr]=1;
            q.push(sr);
            while(!q.empty()){
                int u=q.front(); q.pop();
                if(u==t) break;
                for(int v=0;v<maxx;v++){
                    if(!visited[v] && res[u][v]>0){
                        visited[v]=1;
                        p[v]=u;
                        q.push(v);
                    }
                }
            }
            augment(t,INF);
            if(f==0) break;
            count++;
        }
        if(count!=total){
            printf("!\n");
            continue;
        }
        for(int i=27;i<=36;i++){
            bool flag=true;
            for(int j=1;j<=26;j++){
                if(res[i][j]==1){
                    printf("%c",j+'A'-1);
                    flag=false;
                    break;
                }
            }
            if(flag) printf("_");
        } 
        printf("\n");
    }
}