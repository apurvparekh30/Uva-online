// Apurv Parekh
// July 9th 2018

#include <bits/stdc++.h>

using namespace std;

struct drink{
    string name;
    int degree=0;
    int rank;

    bool operator<(const drink& b) const{
        return this->rank>b.rank;
    }
};

int n,m;

int main(){
    int tc=0;
    while(scanf("%d",&n)==1){
        tc++;
        drink drinks[n];
        unordered_map<string,int> mp;
        list<int> adj[n];
        for(int i=0;i<n;i++){
            char tmp[52];
            scanf("%s",tmp);
            mp[tmp]=i;
            drinks[i].rank = i;
            drinks[i].name = tmp;
        }
        scanf("%d",&m);
        for(int i=0;i<m;i++){
            char u[51],v[52];
            scanf("%s%s",u,v);
            adj[mp[u]].push_back(mp[v]);
            drinks[mp[v]].degree++;
        }

        printf("Case #%d: Dilbert should drink beverages in this order:",tc);

        priority_queue<drink> pq;
        for(int i=0;i<n;i++){
            if(drinks[i].degree==0){
                pq.push(drinks[i]);
            }
        }
        while(!pq.empty()){
            drink d = pq.top();
            pq.pop();
            printf(" %s",d.name.c_str());
            for(auto i: adj[d.rank]){
                drinks[i].degree--;
                if(drinks[i].degree!=0) continue;
                pq.push(drinks[i]);
            }
        }
        printf(".\n\n");
    }
    return 0;
}