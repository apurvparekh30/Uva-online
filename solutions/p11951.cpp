#include <bits/stdc++.h>

using namespace std;

int main() {
    int tc;
    scanf("%d",&tc);
    for(int t=1;t<=tc;t++){
        int n,m;
        long long k;
        scanf("%d%d%lld",&n,&m,&k);
        long long arr[n][m];
        for(int i=0;i<n;i++) for(int j=0;j<m;j++){
            long long no;
            scanf("%lld",&no);
            if(i>0) no+=arr[i-1][j];
            if(j>0) no+=arr[i][j-1];
            if(i>0 && j>0) no-=arr[i-1][j-1];
            arr[i][j]=no;
        }
        int r1,r2,c1,c2;
        int max_area=0;
        long long  total_cost=0;
        for(r1=0;r1<n;r1++) for(c1=0;c1<m;c1++)
        for(r2=r1;r2<n;r2++) for(c2=c1;c2<m;c2++){
            int tmp_area = (r2-r1+1) * (c2-c1+1);
            long long tmp_cost = arr[r2][c2];
            if(r1>0) tmp_cost-=arr[r1-1][c2];
            if(c1>0) tmp_cost-=arr[r2][c1-1];
            if(r1>0 && c1>0) tmp_cost+=arr[r1-1][c1-1];
            if(tmp_cost>k) break;
            if(tmp_area > max_area){
                //printf("arr[%d][%d]=%d\n",r2,c2,arr[r2][c2]);
                //printf("max area %d starting at %d %d ending at %d %d with cost %d\n",tmp_area,r1,c1,r2,c2,tmp_cost);
                max_area = tmp_area;
                total_cost = tmp_cost;
            } 
            else if(tmp_area == max_area && total_cost>tmp_cost)
                total_cost=tmp_cost;       
        }
        printf("Case #%d: %d %lld\n",t,max_area,total_cost);
    }
    return 0;
}