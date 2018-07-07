#include <bits/stdc++.h>

using namespace std;

int h,w;

int g[201][201];
int val[210];

int dr[]={1,0,-1,0};
int dc[]={0,1,0,-1};

void fill(int x,int y,int c,int d){
    if( x<0 || x>=h || y<0 || y>=w) return;
    if(g[x][y]!=c) return ;
    g[x][y] = d;
    for(int i=0;i<4;i++){
        fill(x+dr[i],y+dc[i],c,d);
    }
}

int main(){
    int tc=0;
    while(scanf("%d%d",&h,&w),(h||w)){
        tc++;
        memset(g,0,sizeof(g));
        memset(val,0,sizeof(val));
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                char c;
                scanf("% ");
                scanf("%c",&c);
                int aux=(c>='0'&&c<='9'?c-'0':c-'a'+10);
                int pos=3;
                for(int k=0;k<4;k++){
                    if(aux&(1<<k)) g[i][j*4+pos]=1;
                    else g[i][j*4+pos] = 0;
                    pos--;
                }
            }
        }
        w = w * 4;
        for(int i=0;i<h;i++) for(int j=0;j<w;j++){
            if(i==0 || i==h-1 || j==0 || j==w-1)
                fill(i,j,0,-1);
        }
        int counter = 2;
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(g[i][j]==1) {
                    fill(i,j,1,counter);
                    counter++;
                }
                else if(g[i][j]==0){
                    val[g[i][j-1]]++;
                    fill(i,j,0,-1);
                }
            }
        }
        string ans="";
        for(int i=2;i<counter;i++){
            if(val[i]==0) ans+="W";
            else if(val[i]==1) ans+="A";
            else if(val[i]==2) ans+="K";
            else if(val[i]==3) ans+="J";
            else if(val[i]==4) ans+="S";
            else if(val[i]==5) ans+="D";
        }
        sort(ans.begin(),ans.end());
        printf("Case %d: %s\n",tc,ans.c_str());
    }
    return EXIT_SUCCESS;
}
