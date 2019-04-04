#include <algorithm>
#include <cstdio>
#include <queue>

using namespace std;

int getLeast(int no){
    int n=0;
    for(int i=1;i!=10000;i=i*10){
        int rem = no%10;
        n=n+(rem*i);
        no=no/10;
    }
    return n;
}
int L,U,R;
vector<vector<int>> g(10000,vector<int>());
bool visited[10000];
int buttons[10];
struct vertex{
    int u,c;
    vertex(int a,int b){
        u=a;
        c=b;
    }
};
void init(){
    for(int i=0;i<=9999;i++) g[i].clear();
    fill(visited,visited+10000,false);
}
int main(){
    //printf("%d\n",getLeast(1235));
    int tc=0;
    while(scanf("%d%d%d",&L,&U,&R), (L||U||R)){
        tc++;
        init();
        for(int i=0;i<R;i++){
            scanf("%d",&buttons[i]);
        }
        for(int i=0;i<=9999;i++){
            for(int j=0;j<R;j++){
                g[i].push_back(getLeast(i+buttons[j]));
            }
        }
        int ans=-1;
        queue<vertex> q;
        q.push(vertex(L,0));
        while(!q.empty()){
            vertex curr=q.front();q.pop();
            int n=curr.u;
            int c=curr.c;
            if(n==U) {
                ans=c;  
                break;
            }
            for(auto i: g[n]){
                if(visited[i]) continue;
                visited[i]=true;
                q.push(vertex(i,c+1));
            }
        }
        printf("Case %d: ",tc);
        if(ans==-1){
            printf("Permanently Locked\n");
        }
        else{
            printf("%d\n",ans);
        }
    }
    return 0;
}