#include <bits/stdc++.h>

using namespace std;

int main() {
    int cases;
    scanf("%d",&cases);
    while(cases--){
        int b,sg,sb;
        scanf("%d %d %d",&b,&sg,&sb);
        multiset<int,greater<int>>gSet,bSet;
        for(int i=0;i<sg;i++){
            int no;
            scanf("%d",&no);
            gSet.insert(no);
        }
        for(int i=0;i<sb;i++){
            int no;
            scanf("%d",&no);
            bSet.insert(no);
        }

        while(1){
            if(bSet.empty() && gSet.empty()) {
                printf("green and blue died\n");
                break;
            }
            if(gSet.empty()){
                printf("blue wins\n");
                for(auto i:bSet)
                    printf("%d\n",i);
                break;
            }
            if(bSet.empty()){
                printf("green wins\n");
                for(auto i:gSet)
                    printf("%d\n",i);
                break;
            }

            int g1=gSet.size();
            int b1=bSet.size();

            int n=min(b,min(g1,b1));
            g1=0;
            b1=0;

            vector<int> gForce(n),bForce(n);
            multiset<int>::iterator bit=bSet.begin(),git=gSet.begin();
            for(int i=0;i<n;i++){
                gForce[i]=*git;
                gSet.erase(git++);
            }
            for(int i=0;i<n;i++){
                bForce[i]=*bit;
                bSet.erase(bit++);
            }
            for(int i=0;i<n;i++){
                if(bForce[i]>gForce[i]){
                    bForce[i]=bForce[i]-gForce[i];
                    gForce[i]=0;
                }
                else if(gForce[i]>bForce[i]){
                    gForce[i]=gForce[i]-bForce[i];
                    bForce[i]=0;
                }
                else {
                    bForce[i]=gForce[i]=0;
                }
            }
            for(int i=0;i<n;i++){
                if(bForce[i]!=0) bSet.insert(bForce[i]);
                if(gForce[i]!=0) gSet.insert(gForce[i]);
            }
        }
        if(cases>0) printf("\n");
    }
    return 0;
}