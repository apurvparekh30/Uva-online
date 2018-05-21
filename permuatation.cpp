#include <bits/stdc++.h>

using namespace std;

string s;

void permute(int low,int high){
    if(low<high){
        for(int i=low;i<=high;i++){
            swap(s[i],s[low]);
            permute(low+1,high);
            swap(s[i],s[low]);
        }
    }
    else {
         cout<<s<<'\n';
    }
}

int main()
{
    s="0011";
    permute(0,s.length()-1);
    return 0;
}
