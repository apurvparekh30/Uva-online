// Apurv Parekh
// 10th Aug 2018

#include <iostream>
#include <algorithm>
#include <cstdio>

using namespace std;


int main(){
    int rfp,prop;
    int tc=0;
    bool flag=false;
    while(scanf("%d%d",&rfp,&prop), (rfp||prop)){
        scanf("% ");
        tc++;
        string line;
        for(int i=0;i<rfp;i++){
            getline(cin,line);
        }
        float p; int met;
        string nm;
        string ans;
        float ans_score=0.0;
        float ans_price=1.0*1e9;
        float score;
        string x;
        while(prop--){
            getline(cin,nm);
            scanf("%f%d",&p,&met);
            scanf("% ");
            score = ((met*1.0)/rfp);
            if(score > ans_score){
                ans_score=score;
                ans=nm;
                ans_price=p;
            }
            else if(score == ans_score){
                if(ans_price>p){
                    ans_price=p;
                    ans=nm;
                }
            }
            for(int i=0;i<met;i++){
                getline(cin,x);
            }
        }
        if(flag) printf("\n"); flag=true;
        printf("RFP #%d\n",tc);
        printf("%s\n",ans.c_str());
    }
    return 0;
}