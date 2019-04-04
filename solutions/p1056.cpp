// Apurv Parekh
// 26th July 2018

#include <algorithm>
#include <string>
#include <iostream>
#include <cstdio>
#include <unordered_map>

using namespace std;

int p,r;
int mat[52][52];
unordered_map <string,int> toIndex;

int main(){
    int tc=0;
    bool flag=false;
    while(scanf("%d%d",&p,&r), (p||r)){
        tc++;
        fill(&mat[0][0],&mat[52][0],1e9);
        toIndex.clear();
        int n=1;
        while(r--){
            string a,b;
            cin>>a>>b;
            if(toIndex[a]==0)
                toIndex[a]=n++;
            if(toIndex[b]==0)
                toIndex[b]=n++;
            mat[toIndex[a]][toIndex[b]]=1;
            mat[toIndex[b]][toIndex[a]]=1;
        }
        for(int i=1;i<=p;i++) mat[i][i]=0;
        for(int k=1;k<=p;k++)
            for(int i=1;i<=p;i++)
                for(int j=1;j<=n;j++){
                    mat[i][j]=min(mat[i][j],mat[i][k]+mat[k][j]);
                }
        int ans=-1;
        for(int i=1;i<=p;i++)
            for(int j=1;j<=p;j++)
                ans=max(ans,mat[i][j]);
                
        printf("Network %d: ",tc);
        if(ans == 1e9)
            printf("DISCONNECTED\n\n");
        else   
            printf("%d\n\n",ans);
    }
    return 0;
}