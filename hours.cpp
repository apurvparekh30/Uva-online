#include <bits/stdc++.h>

using namespace std;
string newTime;
string myTime;

bool checkValid(){
    if(newTime[3]>'0' && newTime[2]<='5'){
        if(newTime[0]<'2'){
            return true;
        }
        if(newTime[0]=='2'){
            if(newTime[1]<='3'){
                return true;
            }
        }
    }
    return false;
}

bool first=true;

bool permute(int l,int h){
    if(l<h){
        for(int i=l;i<=h;i++){
            swap(newTime[i],newTime[l]);
            /*if(permute(l+1,h)) {
                return true;
            }*/
            permute(l+1,h);
            swap(newTime[i],newTime[l]);
        }
    }
    else {
       /* if(first){
            first=false;
            return false;
        }
        if(checkValid()){
            return true;
        }
        return false;*/
        cout<< newTime <<'\n';
    }
}


int main() {
    cin>>myTime;
    int pos=myTime.find(':');
    newTime=myTime.substr(0,pos);
    newTime+=myTime.substr(pos+1);
    if(permute(0,3)){
        newTime.insert(2,".");
    }
    return 0;
}