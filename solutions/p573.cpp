// Apurv Parekh
// 10th Aug 2018

#include <algorithm>
#include <cstdio>

using namespace std;

int h,u,d,f;

int main(){
    while(scanf("%d%d%d%d",&h,&u,&d,&f),h){
        double climb=u*1.0;
        double r = ((u*1.0)*(f*1.0/100.0));
        int day=1;
        double curr=0.0;
        while(1){
            curr+=climb;
            if(climb > 0)
                climb=climb-r;

            if(curr > h){
                printf("success on day %d\n",day);
                break;
            }
            curr-=d;
            if(curr < 0.0){
                printf("failure on day %d\n",day);
                break;
            } 
            day++;
        }
    }
    return 0;
}