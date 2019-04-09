// Apurv Parekh
// 25th July

#include <cstdio>
#include <algorithm>
#include <vector>

using namespace std;

int n;
double mat[21][21][21];
int path[21][21][21];

int main(){
    while(scanf("%d",&n)==1){
        fill(&mat[0][0][0],&mat[21][0][0],0.0);
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                path[0][i][j]=i;
            }
        }

        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++){
                if(i==j) mat[0][i][j]=1.0;
                else scanf("%lf",&mat[0][i][j]);
            }
        
        for(int s=1;s<=n;s++){
            for(int k=1;k<=n;k++)
                for(int i=1;i<=n;i++)
                    for(int j=1;j<=n;j++){
                        double temp=mat[s-1][i][k]*mat[0][k][j];  /// why not mat[s-1][k][j]
                        if(mat[s][i][j]<temp){
                            mat[s][i][j]=temp;
                            path[s][i][j]=k;
                        }
                    }
        }
            
        bool flag=true;
        vector<int> ans;
        for(int s=1;s<=n && flag;s++){
            for(int i=1;i<=n;i++){
                if(mat[s][i][i]>1.01){
                    flag=false;
                    int p=i;
                    ans.push_back(i);
                    for(int j=s;j>=0;j--){
                        ans.push_back(path[j][i][p]);
                        p=path[j][i][p];
                    }
                    break;
                }
                
            }
        }
        if(flag){
            printf("no arbitrage sequence exists\n");
        }
        else{
            bool flag=true;
            while(!ans.empty()){
                if(flag){
                    printf("%d",ans.back());
                    flag=false;
                } 
                else {
                    printf(" %d",ans.back());
                }
                ans.pop_back();
            }
            printf("\n");
        }
    }
    return 0;
}