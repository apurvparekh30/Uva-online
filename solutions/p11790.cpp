#include <bits/stdc++.h>

using namespace std;

int main() {
    int tc;
    scanf("%d",&tc);
    for(int t=1;t<=tc;t++){
        int n;
        scanf("%d",&n);
        int height[n],width[n];
        for(int i=0;i<n;i++){
            scanf("%d",&height[i]);
        }
        for(int i=0;i<n;i++){
            scanf("%d",&width[i]);
        }
        int lis[n],lds[n];
        int inc_ans=0,dec_ans=0;
        for(int i=0;i<n;i++){
            lis[i]=width[i];
            lds[i]=width[i];
            for(int j=0;j<i;j++){
                if(height[j] < height[i]){
                    lis[i] = max(lis[i],width[i]+lis[j]);
                }
                if(height[j] > height[i]){
                    lds[i] = max(lds[i],width[i]+lds[j]);
                }
            }
            inc_ans=max(inc_ans,lis[i]);
            dec_ans=max(dec_ans,lds[i]);
        }
        if(inc_ans >= dec_ans )
            printf("Case %d. Increasing (%d). Decreasing (%d).\n",t,inc_ans,dec_ans);
        else 
            printf("Case %d. Decreasing (%d). Increasing (%d).\n",t,dec_ans,inc_ans);
    }
    return 0;
}