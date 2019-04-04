// Apurv Parekh

#include <algorithm>
#include <cstdio>

using namespace std;

const int maxx = 101;

char war(char a,char b){
    if(a==b) return a;
    if(a=='.') return b;
    if(b=='.') return a;
    if(a=='R' && b=='S') return a;
    if(a=='S' && b=='R') return b;
    if(a=='P' && b=='R') return a; 
    if(a=='R' && b=='P') return b;
    if(a=='S' && b=='P') return a;
    if(a=='P' && b=='S') return b;
}

int r,c,n;
char g[maxx][maxx],q[maxx][maxx];

int dr[]={1,0,-1,0};
int dc[]={0,-1,0,1};

void cp(){
    for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            if(q[i][j]=='.') continue;
            g[i][j]=q[i][j];
        }
    }
}

int main(){
    int tc;
    scanf("%d",&tc);
    bool flag=false;
    while(tc--){
        fill(&g[0][0],&g[maxx][0],'.');
        scanf("%d%d%d",&r,&c,&n);
        for(int i=0;i<r;i++){
            scanf("% ");
            for(int j=0;j<c;j++){
                scanf("%c",&g[i][j]);
            }
        }
        while(n--){
            fill(&q[0][0],&q[maxx][0],'.');
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    for(int k=0;k<4;k++){
                        int ni=i+dr[k]; int nj=j+dc[k];
                        if(ni<0||ni>=r||nj<0||nj>=c) continue;
                        char x,y; x=g[i][j]; y=g[ni][nj];
                        char ans = war(x,y);
                        if(ans==x){
                            x=g[i][j];
                            y=q[ni][nj];
                            ans=war(x,y);
                            if(ans==x){
                                q[ni][nj]=x;
                            }
                        }
                        else {
                            x=g[ni][nj];
                            y=q[i][j];
                            ans = war(x,y);
                            if(ans==x){
                                q[i][j]=x;
                            }
                        }
                    }
                }
            }
            cp();
        }
        if(flag) printf("\n"); flag=true;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                printf("%c",g[i][j]);
            }
            printf("\n");
        }
    }
    return 0;
}