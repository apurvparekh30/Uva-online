#include <bits/stdc++.h>

using namespace std;

struct rose {
    bool bloom=false;
    int myGroupSize=0;
};

int ans=-1;

int *sizes;
int *p;
int k;

int main() {
    int n;
    cin>>n;
    sizes=new int[n+1]();
    rose r[n+1];
    p=new int[n+1];
    for(int i=1;i<=n;i++){
        cin>>p[i];
    }

    cin>>k;
    for(int day=1;day<=n;day++){
        int index=p[day];
        r[index].bloom=true;

        int i=index-1;
        int leftgroup=0;
        while(i>=1 && r[i].bloom){
            r[i].myGroupSize++;
            leftgroup++;
            i--;
        }
        sizes[leftgroup]--;
        i=index+1;
        int rightgroup=0;
        while(i<=n && r[i].bloom){
            r[i].myGroupSize++;
            rightgroup++;
            i++;
        }
        sizes[rightgroup]--;

        r[index].myGroupSize=leftgroup+rightgroup+1;
        sizes[r[index].myGroupSize]++;
        if(sizes[k]>0){
            ans=day;
        }
    }
    cout<< ans << '\n';
    return 0;
}