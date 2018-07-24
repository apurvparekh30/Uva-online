// Apurv Parekh
// 24th July

#include <algorithm>
#include <cstdio>

using namespace std;

int mat[101][101];
int a,b;

int main(){
    int tc=0;
    while(scanf("%d%d",&a,&b), (a||b)){
        tc++;
        fill(&mat[0][0],&mat[101][0],1e9);
        mat[a][b]=1;
        while(scanf("%d%d",&a,&b), (a||b))
            mat[a][b]=1;
        for(int k=1;k<=100;k++)
            for(int i=1;i<=100;i++)
                for(int j=1;j<=100;j++)
                    mat[i][j]=min(mat[i][j],mat[i][k]+mat[k][j]);
                
        int sum=0,count=0;
        for(int i=1;i<=100;i++)
            for(int j=1;j<=100;j++){
                if(i==j) continue;
                if(mat[i][j]!=1e9){
                    sum+=mat[i][j];
                    count++;
                }
            }
        printf("Case %d: average length between pages = %.3lf clicks\n",tc,(double)sum/(double)count);
    }
    return 0;
}