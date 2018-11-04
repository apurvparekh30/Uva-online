#include <bits/stdc++.h>

using namespace std;

int main() {
    int n;
    while(scanf("%d",&n),n){
        priority_queue<int, vector<int>, greater<int> > pq;
        while(n--){
            int no;
            scanf("%d",&no);
            pq.push(no);
        }
        long long cost=0;
        while(pq.size() > 1){
            int a=pq.top(); pq.pop();
            int b=pq.top(); pq.pop();
            int add=a+b;
            cost+=add;
            pq.push(add);
        }
        printf("%lld\n",cost);
    }
    return 0;
}
