// Apurv Parekh
// 24th July 2018

#include <cstdio>
#include <algorithm>

using namespace std;

int n;
int youngs[26][26],olds[26][26];
int dist[26];

struct ans{
    int m;
    char loc;
    ans(){}
    ans(int m,char loc): m(m),loc(loc){}
};

int main(){
    while(scanf("%d",&n), n){
        fill(&youngs[0][0],&youngs[26][0],1e9);
        fill(&olds[0][0],&olds[26][0],1e9);
        fill(dist,dist+26,1e9);
        
        while(n--){
            char a,b,c,d;
            int e;
            scanf("% ");
            scanf("%c %c %c %c %d",&a,&b,&c,&d,&e);

            if(a=='Y'){
                youngs[c-'A'][d-'A']=e;
                if(b=='B'){
                    youngs[d-'A'][c-'A']=e;
                }
            }
            else{
                olds[c-'A'][d-'A']=e;
                if(b=='B'){
                    olds[d-'A'][c-'A']=e;
                }
            }
        }
        char p1,p2;
        scanf("% ");
        scanf("%c %c",&p1,&p2);
        p1=p1-'A'; p2=p2-'A';
        for(int i=0;i<26;i++) {
            youngs[i][i]=0;
            olds[i][i]=0;
        }
        for(int k=0;k<26;k++)
            for(int i=0;i<26;i++)
                for(int j=0;j<26;j++){
                    youngs[i][j]=min(youngs[i][j],youngs[i][k]+youngs[k][j]);
                    olds[i][j]=min(olds[i][j],olds[i][k]+olds[k][j]);
                }

        for(int i=0;i<26;i++){
            if(youngs[p1][i] == 1e9) continue;
            if(olds[p2][i] == 1e9) continue;
            dist[i]=youngs[p1][i]+olds[p2][i];
        }
        ans arr[26];
        int index=0;
        int m=1e9;
        for(int i=0;i<26;i++){
            if(dist[i]<m){
                m=dist[i];
                index=0;
                arr[index++]=ans(m,i+'A');
            }
            else if(dist[i]==m){
                arr[index++]=ans(m,i+'A');
            }
        }

        if(m==1e9)
            printf("You will never meet.\n");
        else{
            for(int i=0;i<index;i++){
                if(i==0)
                    printf("%d %c",arr[i].m,arr[i].loc);
                else
                    printf(" %c",arr[i].loc);
            }
            printf("\n");
        }
    }
    return 0;
}