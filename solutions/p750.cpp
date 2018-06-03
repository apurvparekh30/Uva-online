#include <bits/stdc++.h>

using namespace std;

int n,r,c,x[9],counter;

bool place(int r,int c){
    for(int i=1;i<=c-1;i++){
        if(x[i]==r || abs(x[i]-r)==abs(i-c))
            return false;
    }
    return true;
}


void solve(int queen){
    for(int row=1;row<=8;row++){
        if(place(row,queen)){
            x[queen]=row;
            if(queen == 8 && x[c]==r){
                printf("%2d      %d", ++counter, x[1]);
                for(int j = 2; j <= 8; j++)
                    printf(" %d", x[j]);
                printf("\n");
            }
            else{
                solve(queen+1);
            }
        }
    }
}

int main() {
    scanf("%d",&n);
    while(n--){
        scanf("%d %d",&r,&c);
        memset(x,0,sizeof(x));
        x[c]=r;
        counter=0;
        printf("SOLN       COLUMN\n");
        printf(" #      1 2 3 4 5 6 7 8\n\n");
        solve(1);
        if(n) printf("\n");
    }
    return 0;
}