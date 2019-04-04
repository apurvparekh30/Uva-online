// Apurv Parekh
// 11th Aug

#include <algorithm>
#include <cstdio>
#include <string>
#include <iostream>
#include <vector>

using namespace std;

int main(){
    int tc; scanf("%d",&tc);
    for(int t=1;t<=tc;t++){
        vector<string> v(53);
        for(int i=1;i<=52;i++){
            cin>>v[i];
        }
        int curr = 27;
        int y=0;
        for(int i=0;i<3;i++){
            int x;
            string tmp=v[curr];
            if(isdigit(tmp[0])) x=tmp[0]-'0';
            else x=10;
            y+=x;
            curr-=((10-x)+1);
        }
        printf("Case %d: %s\n",t,y<=curr?v[y].c_str():v[27+(y-curr)].c_str());
    }
    return 0;
}