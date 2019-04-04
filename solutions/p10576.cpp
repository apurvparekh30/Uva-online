#include <bits/stdc++.h>

using namespace std;

int solve(){
    int s,d;
    while(scanf("%d %d",&s,&d)!=EOF){
        int maxPositives=5;
        while(maxPositives > 0 && s * maxPositives - d * (5-maxPositives) >= 0){
            maxPositives--;
        }

        int minNegatives = 5-maxPositives;

        if(maxPositives == 0){
            printf("Deficit\n");
            continue;
        }

        int sum=0;
        int position=0;

        while(position < 12){
            int numPos = min(12-position,maxPositives);
            sum+=numPos * s;

            position+=numPos;

            int numNeg = min(12-position,minNegatives);
            sum-=numNeg * d;
            
            position+=numNeg;
        }
        if(sum>0){
            printf("%d\n",sum);
        }
        else {
            printf("Deficit\n");
        }
        

    }
}
int main() {
    solve();
    return 0;
}