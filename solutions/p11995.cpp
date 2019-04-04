#include <bits/stdc++.h>

using namespace std;

int main() {
    int n;
    while(scanf("%d",&n)!=EOF){
        bool s,q,p;
        stack<int> st;
        queue<int> qe;
        priority_queue<int> pq;
        p=q=s=true;
        while(n--){
            int c,v;
            scanf("%d %d",&c,&v);
            if(c==1){
                if(s) st.push(v);
                if(q) qe.push(v);
                if(p) pq.push(v);
            }
            else {
                int myVal;
                if(s){
                    if(st.empty() || st.top()!=v ) 
                        s=false;
                    else
                        st.pop();
                }
                if(q){
                    if(qe.empty() || qe.front()!=v)
                        q=false;
                    else
                        qe.pop();
                }
                if(p){
                    if(pq.empty() || pq.top()!=v)
                        p=false;
                    else        
                        pq.pop();
                }
            }
        }
        if(s && !q && !p)
            printf("stack\n");
        else if(!s && q && !p)
            printf("queue\n");
        else if(!s && !q && p)
            printf("priority queue\n");
        else if(!s && !q && !p)
            printf("impossible\n");
        else    
            printf("not sure\n");
    }
    return 0;
}