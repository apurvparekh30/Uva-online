#include <bits/stdc++.h>

using namespace std;

int y,p;
vector<int> v;


int main(){
    while(scanf("%d",&y) != EOF){
        scanf("%d",&p);
        v.clear();
        for(int i=0;i<p;i++){
            int no;
            scanf("%d",&no);
            v.push_back(no);
        }
        int currYear = 0;
        int m = 0;
        auto newBegin = upper_bound(v.begin(),v.end(),currYear);
        int startYear,endYear;
        while(1){
            auto ub = upper_bound(newBegin,v.end(),currYear+y);
            if(ub == v.end()) break;
            int diff = distance(newBegin,ub);
            if(m < diff){
                m = diff;
                startYear = *newBegin;
                endYear = *(ub-1);
            }
            currYear++;
            newBegin=upper_bound(newBegin,v.end(),currYear);
        }
        printf("%d %d %d\n",m,startYear,endYear);
    }
}