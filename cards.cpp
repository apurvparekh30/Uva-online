#include <bits/stdc++.h>

using namespace std;


bool possible(int money,int total_damage,int cost[],int damage[],int curr, int n){
    if(total_damage<=0) return true;

    if(curr==n || money==0) return false;

    if(cost[curr]>money) {
        return possible(money,total_damage,cost,damage,curr+1,n);
    }
    else {
        if(possible(money-cost[curr],total_damage-damage[curr],cost,damage,curr+1,n)){
            return true;
        }
        else if(possible(money,total_damage,cost,damage,curr+1,n)) {
            return true;
        }
        else 
            return false;
    }
}
int main(){
    int n;
    int money,total_damage;
    cin>>money>>total_damage;

    cin>>n;

    int cost[n],damage[n];
    for(int i=0;i<n;i++){
        cin>>cost[i];
    }
    for(int i=0;i<n;i++){
        cin>>damage[i];
    }

    if(possible(money,total_damage,cost,damage,0,n)){
        cout<<"true\n";
    }
    else {
        cout<<"false\n";
    }
    return 0;
}