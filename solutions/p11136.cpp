#include <bits/stdc++.h>

using namespace std;

int main() {
    int n;
    while(scanf("%d",&n) && n!=0){
        long long total=0LL;
        multiset<int> amount;
        while(n--){
            
            int k;
            scanf("%d",&k);
            while(k--){
                int no;
                scanf("%d",&no);
                amount.insert(no);
            }
            int paid=*amount.rbegin() - *amount.begin();
            amount.erase(amount.begin());
            amount.erase(amount.find(*amount.rbegin()));
            total+=paid;
        }
        printf("%lld\n",total);
    }
    return 0;
}