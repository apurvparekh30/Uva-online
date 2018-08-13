// Apurv Parekh

#include <algorithm>
#include <cstdio>

using namespace std;

int index[76];
int g[5][5];
int v[5][5];

int main(){
    int tc; scanf("%d",&tc);
    while(tc--){
        fill(index,index+76,0);
        fill(&v[0][0],&v[5][0],0);
        int cnt=1;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(cnt==13){
                    cnt++;
                    continue;
                } 
                scanf("%d",&g[i][j]);
                index[g[i][j]]=cnt++;
            }
        }

        for(int i=1;i<=75;i++){
            int no; scanf("%d",&no);
            int r=index[no]/5;
            int c=(index[no]%5)-1;
            v[r][c]=i;
        }

        int a=10000;
        for(int i=0;i<5;i++){
            a=min(a,*max_element(v[i],v[i]+5));
        }
        int b=10000;
        for(int i=0;i<5;i++){
            int mx=-10;
            for(int j=0;j<5;j++){
                mx=max(mx,v[j][i]);
            }
            b=min(b,mx);
        }
        int c=-10;
        for(int i=0;i<5;i++){
            c=max(c,v[i][i]);
        }
        int d=-10;
        for(int i=0;i<5;i++){
            d=max(d,v[i][4-i]);
        }
        int ans;
        ans=min(a,min(b,min(c,d)));
        printf("BINGO after %d numbers announced\n",ans);
    }
    return 0;
}