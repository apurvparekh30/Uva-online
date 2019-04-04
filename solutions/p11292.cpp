#include <bits/stdc++.h>

using namespace std;

int main() {
    int n,m;
    while( scanf("%d %d",&n,&m),n||m){
        int diameters[n];
        int heights[m];

        for(int i=0;i<n;i++){
            scanf("%d",&diameters[i]);
        }

        for(int i=0;i<m;i++){
            scanf("%d",&heights[i]);
        }


        if(m < n){
            printf("Loowater is doomed!\n");
            continue;
        }
        sort(diameters,diameters+n);
        sort(heights,heights+m);

        bool flag = true;
        int money=0;
        for(int i=0,j=0;i<n;i++){
            while(heights[j] < diameters[i] && j<m){
                j++;
            }
            if(j == m){
                flag = false;
                break;
            }
            money+=heights[j];
            j++;
        }
        if(!flag){
            printf("Loowater is doomed!\n");
        }
        else{
            printf("%d\n",money);
        }
    }
    return EXIT_SUCCESS;
}