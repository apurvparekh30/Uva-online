// Apurv Parekh

#include <cstdio>
#include <algorithm>

using namespace std;

const int maxx = 100;

int dr[]={1,1,0,-1,-1,-1,0,1};
int dc[]={0,-1,-1,-1,0,1,1,1};

char arr[maxx][maxx];
int n,m;

int main(){
    int tc=0;
    bool flag = false;
    while(scanf("%d%d",&n,&m),(n||m)){
        tc++;
        fill(&arr[0][0],&arr[maxx][0],'.');
        for(int i=0;i<n;i++){
            scanf("% ");
            for(int j=0;j<m;j++){
                scanf("%c",&arr[i][j]);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]=='*') continue;
                int cnt=0;
                for(int k=0;k<8;k++){
                    int ni=i+dr[k]; int nj=j+dc[k];
                    if(ni<0||ni>=n||nj<0||nj>=m) continue;
                    if(arr[ni][nj]=='*') cnt++;
                }
                arr[i][j]='0'+cnt;
            }
        }
        if(flag) printf("\n"); flag=true;
        printf("Field #%d:\n",tc);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                printf("%c",arr[i][j]);
            }
            printf("\n");
        }
    }
    return 0;
}