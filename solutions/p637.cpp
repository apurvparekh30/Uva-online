// Apurv Parekh

#include <algorithm>
#include <cstdio>
#include <cmath>

using namespace std;

int pg,sht;

int main(){
    while(scanf("%d",&pg),pg){
        printf("Printing order for %d pages:\n",pg);
        if(pg==1){
            printf("Sheet 1, front: Blank, 1\n");
            continue;
        }
        sht=ceil(pg/4.0);
        int blnk = 4 - (pg/4);
       
        int s=1,e=sht*4;
        for(int i=1;i<=sht;i++){
            printf("Sheet %d, front: ",i);
            if(e>pg) {
                printf("Blank, ");
            } 
            else{
                printf("%d, ",e);
            } 
            printf("%d\n",s);
            e--;
            s++;
            printf("Sheet %d, back : ",i);
            printf("%d, ",s);
            if(e>pg) {
                printf("Blank\n");
            } 
            else{
                printf("%d\n",e);
            } 
            s++;
            e--;
        }
    }
}