// Apurv Parekh

#include <algorithm>
#include <bitset>
#include <cstdio>
#include <vector>

using namespace std;

const int numSecInMin = 60;
const int numSecInHr = 60 * numSecInMin;

int a;
bitset<100> bt;
vector<int> v,vd;


int main(){
    while(scanf("%d",&a),a){
        v.clear(); vd.clear(); bt.reset();
        v.push_back(a); vd.push_back(a*2);
        int mn = a;
        while(scanf("%d",&a),a){
            v.push_back(a);
            vd.push_back(a*2);
            mn = min(mn,a);
        }
            
        bool flag=false;
        int t;
        for(t=(2*mn);t<=18000;t++){
            for(int i=0;i<v.size();i++){
                if((t%vd[i])<v[i]-5){
                    bt.set(i);
                }
                else{
                    bt.reset(i);
                    break;
                }
            }
            if(bt.count()==v.size()){
                flag=true;
                break;
            }
        }
        //printf("%d\n",t);
        if(flag){
            int hr = t / numSecInHr;
            printf("0%d:%02d:%02d\n",hr,(t-hr*numSecInHr)/numSecInMin,t%numSecInMin);
        }
        else {
            printf("Signals fail to synchronise in 5 hours\n");
        }
    }
    return 0;
}