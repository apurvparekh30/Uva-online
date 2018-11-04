// Apurv Parekh
// 8th Aug 2018

#include <cstdio>
#include <algorithm>
#include <iostream>
#include <cmath>

using namespace std;

int main(){
    int tc;
    scanf("%d",&tc);
    scanf("% ");
    while(tc--){
        string ip;
        int x1,y1,x2,y2;
        double dist=0.0;
        getline(cin,ip);
        while(getline(cin,ip) && !ip.empty()){
            sscanf(ip.c_str(),"%d %d %d %d",&x1,&y1,&x2,&y2);
            dist+=sqrt((double)(x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
        }
        int time = round((dist*60*2)/20000);
        //int time = round(dist/1000/20*2*60);
        printf("%d:%02d\n", time/60, time%60);
        printf(tc ? "\n" : "");

    }
    return 0;
}