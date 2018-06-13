#include <bits/stdc++.h>

using namespace std;

int r,c;
string s="";
int bm[201][201];


void toD(int rs,int re,int cs,int ce,int &p){
    if(rs == re || cs == ce) return ;
    int sum=0;
    for(int i=rs;i<re;i++){
        for(int j=cs;j<ce;j++){
            sum+=bm[i][j];
        }
    }
    if(p > 0 && p%50==0) printf("\n");

    p++;
    if(sum==(re-rs)*(ce-cs)){
        printf("1");
    }
    else if(sum==0){
        printf("0");
    }
    else{
        printf("D");
        int rHalf = (re + rs + 1) >> 1;
        int cHalf = (ce + cs + 1) >> 1;
        toD(rs,rHalf,cs,cHalf,p);
        toD(rs,rHalf,cHalf,ce,p);
        toD(rHalf,re,cs,cHalf,p);
        toD(rHalf,re,cHalf,ce,p);
    }
}

void toB(int rs,int re,int cs,int ce){

    if(rs == re || cs == ce) return;

    char ch = getchar();
    if(ch == '\n')
        ch = getchar();
    if(ch == '1' || ch =='0'){
        for(int i=rs;i<re;i++){
            for(int j=cs;j<ce;j++){
                bm[i][j]=ch-'0';
            }
        }
        return ;
    }
    int rHalf = (re + rs + 1) >> 1;
    int cHalf = (ce + cs + 1) >> 1;
    toB(rs,rHalf,cs,cHalf);
    toB(rs,rHalf,cHalf,ce);
    toB(rHalf,re,cs,cHalf);
    toB(rHalf,re,cHalf,ce);
}

int main() {

    char ch;
    while(scanf("%c",&ch), ch!='#'){
        if(ch=='\n') scanf("%c",&ch);
        if(ch == '#') break;
        scanf("%d %d",&r,&c);
        if(ch == 'B'){
            char line[50];
            s = "";
            while(s.size() < r * c ){
                scanf("%s",&line);
                s=s+line;
            }
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    bm[i][j]=s[i*c+j]-'0';
                }
            }
            printf("%c%4d%4d\n",'D',r,c);
            int count=0;
            toD(0,r,0,c,count);
            printf("\n");
        }
        else {
            toB(0,r,0,c);
            printf("%c%4d%4d\n",'B',r,c);
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    if(i+j>0 && (i*c+j)%50 == 0) printf("\n");
                    printf("%d",bm[i][j]);
                }
            }
            printf("\n");
        }
    }
    return 0;
}