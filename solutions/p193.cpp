#include <bits/stdc++.h>

using namespace std;

int n,k;

vector<vector<int>> v(101,vector<int> (101));
vector<int> ans(101);
vector<int> color(101,0);


void backtrack(int u,vector<int> tmp){
    tmp.push_back(u);
    color[u]=-1;
    vector<int> save;
    for(auto i:v[u]){
        if(color[i]==0){
            color[i]=1;
            save.push_back(i);
        }
    }
    bool found = false;
    for(int i=u+1;i<=n;i++){
        if(color[i]==0){
            found = true;
            backtrack(i,tmp);
            break;
        }
    }
    if(!found){
        if(ans.size() < tmp.size()) ans = tmp;
    }

    for(auto i:save){
        color[i]=0;
    }
    color[u]=1;
    tmp.pop_back();
    for(int i=u+1;i<=n;i++){
        if(color[i]==0){
            backtrack(i,tmp);
            break;
        }
    }
    color[u]=0;
}

int main(){
    int tc;
    scanf("%d",&tc);
    while(tc--){
        //v.clear()
       
        scanf("%d %d",&n,&k);
        for(int i=0;i<=n;i++){
            v[i].clear();
            color[i]=0;
        }
        ans.clear();
        while(k--){
            int a,b;
            scanf("%d%d",&a,&b);
            v[a].push_back(b);
            v[b].push_back(a);
        }
        backtrack(1,vector<int> ());
        printf("%d\n",ans.size());
        printf("%d",ans[0]);
        for(int i=1;i<ans.size();i++){
            printf(" %d",ans[i]);
        }
        printf("\n");
    }
    return 0;
}