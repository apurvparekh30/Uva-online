// Apurv Parekh

#include <algorithm>
#include <cstdio>
#include <string>

using namespace std;

char brd[8][8];
bool att[8][8];
bool v[10][10];

void up(int r,int c){
    if(c<0||c>=8||r>=8||r<0) return;
    if(brd[r][c]!='.') return;
    att[r][c]=true;
    up(r+1,c); 
}
void down(int r,int c){
    if(c<0||c>=8||r>=8||r<0) return;
    if(brd[r][c]!='.') return;
    att[r][c]=true;
    down(r-1,c);
}
void left(int r,int c){
    if(c<0||c>=8||r>=8||r<0) return;
    if(brd[r][c]!='.') return;
    att[r][c]=true;
    left(r,c-1);
}
void right(int r,int c){
    if(c<0||c>=8||r>=8||r<0) return;
    if(brd[r][c]!='.') return;
    att[r][c]=true;
    right(r,c+1);
}
void ul(int r, int c){
    if(c<0||c>=8||r>=8||r<0) return;
    if(brd[r][c]!='.') return;
    att[r][c]=true;
    ul(r-1,c-1);
}
void ur(int r,int c){
    if(c<0||c>=8||r>=8||r<0) return;
    if(brd[r][c]!='.') return;
    att[r][c]=true;
    ur(r-1,c+1);
}
void dl(int r,int c){
    if(c<0||c>=8||r>=8||r<0) return;
    if(brd[r][c]!='.') return;
    att[r][c]=true;
    dl(r+1,c-1);
}
void dr(int r,int c){
    if(c<0||c>=8||r>=8||r<0) return;
    if(brd[r][c]!='.') return;
    att[r][c]=true;
    dr(r+1,c+1);
}
void pwn(int r,int c){
    if(c<0||c>=8||r>=8||r<0) return;
    if(brd[r][c]!='.') return;
    att[r][c]=true;
}
void kn(int r,int c){
    int dr[]={-1,-2,-2,-1,1,2,2,1};
    int dc[]={2,1,-1,-2,-2,-1,1,2};
    for(int i=0;i<8;i++){
        int nr=r+dr[i]; int nc=c+dc[i];
        if(nr<0||nr>=8||nc<0||nc>=8) continue;
        if(brd[nr][nc]!='.') continue;
        att[nr][nc]=true;
    }
}

void king(int r,int c){
    int dr[]={1,1,0,-1,-1,-1,0,1};
    int dc[]={0,-1,-1,-1,0,1,1,1};
    for(int i=0;i<8;i++){
        int nr=r+dr[i]; int nc=c+dc[i];
        if(nr<0||nr>=8||nc<0||nc>=8) continue;
        if(brd[nr][nc]!='.') continue;
        att[nr][nc]=true;
    }
}

int main(){
    char in[100];
    while(scanf("%s",in)==1){
        fill(&brd[0][0],&brd[8][0],'.');
        fill(&att[0][0],&att[8][0],false);
        string s(in);
        int i=0; int j=0;
        for(char c:s){
            if(c=='/'){
                i++; j=0;
                continue;
            }
            if(isdigit(c)){
                for(int k=0;k<c-'0';k++){
                    brd[i][j++]='.';
                }
            }
            else{
                brd[i][j++]=c;
            }
        }
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(brd[i][j]=='.') continue;
                if(brd[i][j]=='r' || brd[i][j]=='R'){
                    up(i+1,j);
                    down(i-1,j);
                    left(i,j-1);
                    right(i,j+1);
                }
                else if(brd[i][j]=='n' || brd[i][j]=='N'){
                    kn(i,j);
                }
                else if(brd[i][j]=='b' || brd[i][j]=='B'){
                    ul(i-1,j-1);
                    ur(i-1,j+1);
                    dl(i+1,j-1);
                    dr(i+1,j+1);
                }
                else if(brd[i][j]=='q' || brd[i][j]=='Q'){
                    up(i+1,j);
                    down(i-1,j);
                    left(i,j-1);
                    right(i,j+1);
                    ul(i-1,j-1);
                    ur(i-1,j+1);
                    dl(i+1,j-1);
                    dr(i+1,j+1);
                }
                else if(brd[i][j]=='p'){
                    pwn(i+1,j-1);
                    pwn(i+1,j+1);
                }
                else if(brd[i][j]=='P'){
                    pwn(i-1,j-1);
                    pwn(i-1,j+1);
                }
                else if(brd[i][j]=='K' || brd[i][j]=='k'){
                    king(i,j);
                }       
            }
        }
        int cnt=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(brd[i][j]=='.' && !att[i][j]) cnt++;
            }
        }
        printf("%d\n",cnt);
    }
    return 0;
}





   /*  kn(r-1,c+2);
    kn(r-2,c+1);
    kn(r-2,c-1);
    kn(r-1,c-2);
    kn(r+1,c-2);
    kn(r+2,c-1);
    kn(r+2,c+1);
    kn(r+1,c+2); */