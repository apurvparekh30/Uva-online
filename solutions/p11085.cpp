#include <bits/stdc++.h>

using namespace std;

int x[9],sol=1;
int solutions[93][9];
int mysol[9];


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
            if(queen == 8){
               for(int i=1;i<=8;i++){
                   solutions[sol][i]=x[i];
               }
               sol++;
            }
            else{
                solve(queen+1);
            }
        }
    }
}

int main() {
    solve(1);
    int tc = 1;
    while(scanf("%d",&mysol[1])!= EOF){
        int m=64;
        for(int i=2;i<=8;i++){
            scanf("%d",&mysol[i]);
        }
        for(int i=1;i<=92;i++){
            int diff=0;
            for(int j=1;j<=8;j++){
                if(solutions[i][j]-mysol[j])
                    diff++;
            }
            m = min (m,diff);
        }

        printf("Case %d: %d\n",tc,m);
        tc++;
    }
    return 0;
}