#include <bits/stdc++.h>

using namespace std;

int main() {
    int B,S;
    int tc = 0;
    while(scanf("%d %d",&B,&S), B||S) {
        tc++;
        int minBoy = INT_MAX;
        for(int i=0;i<B;i++){
            int newBoy;
            scanf("%d",&newBoy);
            minBoy = min(minBoy,newBoy);
        }
        for(int i=0;i<S;i++){
            int newGirl;
            scanf("%d",&newGirl);
        }
        if(B <= S){
            printf("Case %d: 0\n",tc);
        }
        else {
            printf("Case %d: %d %d\n",tc,B-S,minBoy);
        }
    }
    return 0;
}