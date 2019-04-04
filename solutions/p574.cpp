#include <bits/stdc++.h>

using namespace std;

int t,n;

int arr[13];



set<vector<int>> s;

void recur(int i,int currSum,int mask){
    if(currSum > t) return;
    if(currSum == t){
        vector<int> temp;
        for(int i=1;i<=n;i++){
            if(mask&(1<<i)){
               temp.push_back(arr[i]);
            }   
        }
        s.insert(temp);
    }
    if(i>n) return;
    recur(i+1,currSum+arr[i],mask|(1<<i));
    recur(i+1,currSum,mask);
}

int main() {
    while(scanf("%d %d",&t,&n),n){

        s.clear();
        for(int i=1;i<=n;i++){
            scanf("%d",&arr[i]);
        }
        printf("Sums of %d:\n",t);
        recur(0,0,0);
        if(s.empty()){
            printf("NONE\n");
        }
        else {

            std::set<vector<int>>::reverse_iterator rit;
            for(rit =s.rbegin();rit!=s.rend();++rit){
                const vector<int>& v=(*rit);
                for(int j=0;j<v.size();j++){
                    printf(j==0? "%d":"+%d",v[j]);
                }
                printf("\n");
            }
            
        }
    }
    return 0;
}