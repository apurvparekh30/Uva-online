#include <algorithm>
#include <unordered_map>
#include <queue>
#include <cstdio>
#include <string>
#include <iostream>

using namespace std;

int n;
unordered_map<string,int> wordIndex,langIndex;

struct vertex {
    string word,lang1,lang2;
    vertex(){

    }
    vertex(string a,string b,string c){
        word=a; lang1=b; lang2=c;
    }
};
vector<vertex> words(2001);
struct edge{
    int v,w;
    edge(int a,int b){
        v=a; w=b;
    }
    bool operator <(const edge& b) const{
        return this->w>b.w;
    }
};
vector<vector<edge>> g(2002,vector<edge>());
string o,d;
int dist[2002];
void init(){
    wordIndex.clear();
    langIndex.clear();
    words.clear();
    fill(dist,dist+n+2,1e9);
    for(int i=0;i<=n+1;i++) g[i].clear();
}
int main(){
    while(scanf("%d",&n),n){
        init();
        cin>>o>>d;
        for(int i=1;i<=n;i++){
            string l1,l2,w;
            cin>>l1>>l2>>w;
            wordIndex[w]=i;
            for(vertex wrd:words){
                if(w[0]!=wrd.word[0]){
                    if(l1==wrd.lang1||l1==wrd.lang2||l2==wrd.lang1||l2==wrd.lang2){
                        int wIndex = wordIndex[wrd.word];
                        g[i].push_back(edge(wIndex,w.length()));
                        g[wIndex].push_back(edge(i,wrd.word.length()));
                    }
                }
            }
            if(l1==o||l2==o) g[0].push_back(edge(i,0));
            if(l1==d||l2==d) g[i].push_back(edge(n+1,w.length()));
            words.push_back(vertex(w,l1,l2));
        }
        priority_queue <edge> pq;
        pq.push(edge(0,0));
        dist[0]=0;
        while(!pq.empty()){
            edge curr=pq.top();pq.pop();
            int u=curr.v; int w=curr.w;
            if(dist[u] < w) continue;
            for(edge e:g[u]){
                if(dist[e.v] > dist[u]+e.w){
                    dist[e.v]=dist[u]+e.w;
                    pq.push(edge(e.v,dist[e.v]));
                }
            }
        }
        if(dist[n+1]==1e9){
            printf("impossivel\n");
        }
        else{
            printf("%d\n",dist[n+1]);
        }
    }
    return EXIT_SUCCESS;
}