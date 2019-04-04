#include <bits/stdc++.h>
using namespace std;

int *parent,*compRank;

int findSet(int p) {
    return (p==parent[p])? p : (parent[p]=findSet(parent[p]));
}

bool inSame(int a,int b){
    return findSet(a)==findSet(b);
}

int main() {
    int cases;
    cin>>cases;
    string line;
    getline(cin,line);
    while(cases--){
       
        int computers;
        cin>>computers;
        cin.ignore(numeric_limits<streamsize>::max(),'\n');
        parent=new int[computers+1];
        compRank=new int[computers+1];
        for(int i=1;i<=computers;i++){
            parent[i]=i;
        }
        int success=0,fail=0;
        while(getline(cin,line)){
            if(line.empty())
                break;
            stringstream myline(line);
            char ch; int a,b;
            myline>>ch>>a>>b;
            if(ch=='c'){
                if(!inSame(a,b)){
                    int x=findSet(a);
                    int y=findSet(b);

                    if(compRank[x]>compRank[y]){
                        parent[y]=x;
                    }
                    else {
                        parent[x]=y;
                        if(compRank[x]==compRank[y])
                            compRank[y]++;
                    }
                }
            }
            else {
                if(inSame(a,b)){
                    success++;
                }
                else {
                    fail++;
                }
            }
        }
        cout<< success << "," << fail<<'\n';
        if(cases)
            cout<<'\n';
    }

    return 0;
}