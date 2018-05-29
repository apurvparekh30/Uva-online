#include <bits/stdc++.h>

using namespace std;

struct query {
    int qNum,period;
    bool operator < (const query& other) const {
        if(period == other.period)
            return qNum > other.qNum;
        return period>other.period;
    }
};

int main(){
    string s;
    priority_queue<query> pq;
    int periods[3000+1];
    while(cin>>s, s!="#"){
        int qNum,period;
        scanf("%d %d",&qNum,&period);
        periods[qNum]=period;
        pq.push(query{qNum,period});
    }
    int k;
    scanf("%d",&k);
    while(k--){
        query myQ = pq.top();
        pq.pop();
        pq.push(query{myQ.qNum,myQ.period+periods[myQ.qNum]});
        printf("%d\n",myQ.qNum);
    }
    return 0;
}