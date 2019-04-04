// Apurv Parekh

#include <cstdio>
#include <algorithm>
#include <cstring>

using namespace std;

char ques[1000];
char ans[1000];
int v[150];
bool vis[150];

int main(){
    int r;
    while(scanf("%d",&r),r>0){
        fill(v,v+150,0);
        fill(vis,vis+150,false);
        int draw=7;
        scanf("%s%s",ques,ans);
        int count=0;
        for(int i=0;ques[i]!='\0';i++) v[ques[i]]++;
        for(int i=0;ans[i]!='\0' && draw ;i++){
            if(vis[ans[i]]) continue;
            vis[ans[i]]=true;
            if(v[ans[i]]) {
                count+=v[ans[i]];
            }
            else draw--;
        }
        printf("Round %d\n",r);
        if(count == strlen(ques)){
            printf("You win.\n");
        }
        else if(draw==0){
            printf("You lose.\n");
        }
        else{
            printf("You chickened out.\n");
        }   
    }
    return 0;
}