// Apurv Parekh
// 10th Aug 2018

#include <algorithm>
#include <cstdio>
#include <cstdio>
#include <bitset>
#include <unordered_map>
#include <iostream>
#include <sstream>

using namespace std;

unordered_map<char,int> mp,pt;

int main() {
    mp.insert(make_pair('A',3));
    mp.insert(make_pair('K',2));
    mp.insert(make_pair('Q',1));
    mp.insert(make_pair('J',0));
    
    string line;
    while(getline(cin,line)){
        int stopped=0,sp=0,ht=0,cu=0,di=0;
        int scount=0,hcount=0,ccount=0,dcount=0;
        int mx=-1;
        int total=0,tmp=0;
        if(line.empty()) break;
        stringstream ss(line);
        string s;
        while(ss>>s){
            if(s[1]=='S'){
                scount++;
                mx=max(mx,scount);
                if(s[0]=='A'||s[0]=='K'||s[0]=='Q'||s[0]=='J'){
                    total+=mp[s[0]]+1;
                    sp|=(1<<mp[s[0]]);
                }  
            }
            else if(s[1]=='H'){
                hcount++;
                mx=max(mx,hcount);
                if(s[0]=='A'||s[0]=='K'||s[0]=='Q'||s[0]=='J'){
                    total+=mp[s[0]]+1;
                    ht|=(1<<mp[s[0]]);
                }
                
            }
            else if(s[1]=='C'){
                ccount++;
                mx=max(mx,ccount);
                if(s[0]=='A'||s[0]=='K'||s[0]=='Q'||s[0]=='J'){
                    total+=mp[s[0]]+1;
                    cu|=(1<<mp[s[0]]);
                }
            }
            else if(s[1]=='D'){
                dcount++;
                mx=max(mx,dcount);
                if(s[0]=='A'||s[0]=='K'||s[0]=='Q'||s[0]=='J'){
                    total+=mp[s[0]]+1;
                    di|=(1<<mp[s[0]]);
                }
            }
        }

        if(sp&(1<<mp['K']) && scount==1) total-=1;
        if(ht&(1<<mp['K']) && hcount==1) total-=1;
        if(cu&(1<<mp['K']) && ccount==1) total-=1;
        if(di&(1<<mp['K']) && dcount==1) total-=1;

        if(sp&(1<<mp['Q']) && scount<=2) total-=1;
        if(ht&(1<<mp['Q']) && hcount<=2) total-=1;
        if(cu&(1<<mp['Q']) && ccount<=2) total-=1;
        if(di&(1<<mp['Q']) && dcount<=2) total-=1;

        if(sp&(1<<mp['J']) && scount<=3) total-=1;
        if(ht&(1<<mp['J']) && hcount<=3) total-=1;
        if(cu&(1<<mp['J']) && ccount<=3) total-=1;
        if(di&(1<<mp['J']) && dcount<=3) total-=1;

        if(scount==2) tmp+=1;
        if(hcount==2) tmp+=1;
        if(ccount==2) tmp+=1;
        if(dcount==2) tmp+=1;

        if(scount==1) tmp+=2;
        if(hcount==1) tmp+=2;
        if(ccount==1) tmp+=2;
        if(dcount==1) tmp+=2;

        if(scount==0) tmp+=2;
        if(hcount==0) tmp+=2;
        if(ccount==0) tmp+=2;
        if(dcount==0) tmp+=2;

        if((sp&(1<<mp['A'])) || (sp&(1<<mp['K']) && scount>1) || (sp&(1<<mp['Q']) && scount>2))
             stopped|=(1<<0);
        if((ht&(1<<mp['A'])) || (ht&(1<<mp['K']) && hcount>1) || (ht&(1<<mp['Q']) && hcount>2))
             stopped|=(1<<1);
        if((cu&(1<<mp['A'])) || (cu&(1<<mp['K']) && ccount>1) || (cu&(1<<mp['Q']) && ccount>2))
             stopped|=(1<<2);
        if((di&(1<<mp['A'])) || (di&(1<<mp['K']) && dcount>1) || (di&(1<<mp['Q']) && dcount>2))
             stopped|=(1<<3);


        if(total+tmp < 14) 
            printf("PASS\n");
        else if(total>=16 && stopped==15)
            printf("BID NO-TRUMP\n");
        else {
            if(scount == mx) printf("BID S\n");
            else if(hcount == mx) printf("BID H\n");
            else if(dcount == mx) printf("BID D\n");
            else if(ccount == mx) printf("BID C\n");
        }
    }
    return 0;
}   