#include <bits/stdc++.h>

using namespace std;

int ans=-1;

int *parent;
int *p;
int k;
int *sizes;
int *groupSize;
int *myrank;
int n;
int findSet(int i){
    return (parent[i]==i)? i:(parent[i]=findSet(parent[i]));
}

void unionSet(int x,int y){
    if(y>n || y<1)
        return;
    if(parent[y]==0){
        return ;
    }
    else {
        int px=findSet(x);
        int py=findSet(y);
        sizes[groupSize[px]]--;
        sizes[groupSize[py]]--;
        if(myrank[px]>myrank[py]){
            parent[py]=px;
            groupSize[px]+=groupSize[py];
            sizes[groupSize[px]]++;
        }
        else {
            parent[px]=py;
            groupSize[py]+=groupSize[px];
            sizes[groupSize[py]]++;
            
            if(myrank[px]==myrank[py]){
                myrank[py]++;
            }
        }
    }
}


int main() {
    cin>>n;

    parent=new int[n+1]();

    p=new int[n+1];
    sizes=new int[n+1]();
    groupSize=new int[n+1]();
    myrank=new int[n+1]();
    for(int i=1;i<=n;i++){
        cin>>p[i];
    }
    cin>>k;
    for(int day=1;day<=n;day++){
        int index=p[day];
        parent[index]=index;
        sizes[1]++;
        groupSize[index]=1;
        unionSet(index,index-1);
        unionSet(index,index+1);
        if(sizes[k]>0)
            ans=day;
    }
    cout<<ans<<'\n';
    return 0;
}