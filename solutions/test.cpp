// Apurv Parekh

#include <algorithm>
#include <cstdio>
#include <unordered_map>

using namespace std;

const int maxx = 1e6+1;

int a,b,c;
unordered_map <int,int> mp;

int score[maxx];

int main(){
    int tc; scanf("%d",&tc);
    while(tc--){
        fill(score,score+maxx,1);
        mp.clear();
        scanf("%d%d%d",&a,&b,&c);
        for(int i=1;i<=106;i++) mp[i]=i;
        while(b--){
            int x,y;
            scanf("%d%d",&x,&y);
            mp[x]=y;
        }
        if(c!=0){
            bool flag=false;
            for(int i=1;i<=a;i++){
                score[i]=mp[score[i]];
                if(score[i]>=100){
                    flag=true;
                    break;
                }
            }
            int i=1;
            while(c--){
                int roll; scanf("%d",&roll);
                if(flag) continue;
                score[i]+=roll;
                score[i]=mp[score[i]];
                if(score[i]>=100){
                    flag=true;
                    continue;
                }
                i=i+1;
				i=(i%(a+1))+1;
            }
        }
        
        for(int i=1;i<=a;i++){
            printf("Position of player %d is %d.\n",i,min(score[i],100));
        }
    }
    return 0;
}