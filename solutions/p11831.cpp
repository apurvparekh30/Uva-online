#include <bits/stdc++.h>

using namespace std;

char ar[101][101];
char ins[5*10000];

int n,m,s;

int u,v;

int orient;

int dr[] = {-1,0,1,0};
int dc[] = {0,1,0,-1};

int check(int r,int c){
    if(r<0 || r>=n || c<0 || c>=m) return 0;
    if(ar[r][c] =='#') return 0;
    if(ar[r][c] == '*') {
        ar[r][c] = '.';
        return 2;
    }
    return 1;
}

int process(){
    int count=0;
    for(int i=0;ins[i]!='\0';i++){
        if(ins[i] == 'D'){
            orient++;
            if(orient == 4) orient = 0;
        }
        else if(ins[i]=='E'){
            orient--;
            if(orient==-1) orient = 3;
        }
        else{
            int res = check(u+dr[orient],v+dc[orient]);
            if(res!=0){
                if(res == 2) count++;
                u = u + dr[orient];
                v = v + dc[orient];
            }
        }
    }
    return count;
}

int main(){ 
    while(scanf("%d%d%d",&n,&m,&s), (n||m||s)){
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                scanf("% ");
                scanf("%c",&ar[i][j]);
                if(ar[i][j]!='.' && ar[i][j]!='#' && ar[i][j]!='*'){
                    u = i;
                    v = j;
                }
                if(ar[i][j]=='N') orient = 0;
                else if(ar[i][j]=='S') orient = 2; 
                else if(ar[i][j]=='L') orient = 1;
                else if(ar[i][j]=='O') orient = 3;
            }
        }
        scanf("% ");
        scanf("%s",&ins);
        printf("%d\n",process());
    }
    return 0;
}