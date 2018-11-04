// Apurv Parekh
// 26th July

#include <algorithm>
#include <cstdio>
#include <unordered_map>
#include <vector>
#include <iostream>

using namespace std;

int nc,ne,nm;

bool mat[201][201];
unordered_map <string,int> toIndex;
unordered_map <int,string> toName;

int main(){
    int tc=0;
    while(scanf("%d",&nc), nc){
        fill(&mat[0][0],&mat[201][0],0);
        tc++;
        int eventIndex=0;
        for(int i=0;i<nc;i++){
            scanf("%d",&ne);
            string event="",prev;
            while(ne--){
                prev=event;
                cin>>event;
                toIndex[event]=eventIndex;
                toName[eventIndex]=event;
                eventIndex++;
                if(prev=="") continue;
                mat[toIndex[prev]][toIndex[event]]=true;
            }
        }
        scanf("%d",&nm);
        while(nm--){
            string e1,e2;
            cin>>e1>>e2;
            mat[toIndex[e1]][toIndex[e2]]=true;
        }
        for(int k=0;k<eventIndex;k++){
            for(int i=0;i<eventIndex;i++){
                for(int j=0;j<eventIndex;j++){
                    if(mat[i][j]) continue;
                    mat[i][j]=mat[i][k]&mat[k][j];
                }
            }
        }
        int count=0;
        vector<pair<int,int>> ans;
        for(int i=0;i<eventIndex;i++){
            for(int j=0;j<eventIndex;j++){
                if(mat[i][j]) continue;
                if(i==j) continue;
                if(mat[j][i]) continue;
                ans.push_back(make_pair(i,j));
                mat[i][j]=1;
                count++;
            }
        }
        if(count==0){
            printf("Case %d, no concurrent events.\n",tc);
        }
        else{
            printf("Case %d, %d concurrent events:\n",tc,count);
            //bool flag=true;
            int count=0;
            for(pair<int,int> i: ans){
                if(count==2) break;
                /* if(flag)
                    printf("(%s,%s)",toName[i.first].c_str(),toName[i.second].c_str()); */
                //else
                    printf("(%s,%s) ",toName[i.first].c_str(),toName[i.second].c_str());
                //flag=false;
                count++;
            }
            printf("\n");
        }
    }
    return 0;
}