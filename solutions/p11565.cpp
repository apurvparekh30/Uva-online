#include <bits/stdc++.h>

using namespace std;

bool solved(int a,int b,int c){
    int x,y,z;
    for(x=-100;x<=100;x++){
        for(y=-100;y<=100;y++){
            if(x == y) continue;
            int s=x+y;
            int p=x*y;
            if(p == 0) continue;
            if(b%p != 0) continue;

            z = b/p;
            if(x!=z && y!=z){
                if(x+y+z == a && x*y*z==b && (x*x+y*y+z*z) == c){
                    printf("%d %d %d\n",x,y,z);
                    return true;
                }
            }
        }   
    }
    return false;
}

int main() {
    int n;
    scanf("%d",&n);
    while(n--){
        int a,b,c;
        scanf("%d %d %d",&a,&b,&c);
        
        if(!solved(a,b,c)){
            printf("No solution.\n");
        }
    }
    return 0;
}