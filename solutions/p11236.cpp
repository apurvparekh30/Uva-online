#include <bits/stdc++.h>

using namespace std;

const int m = 1e6;

int main() {
    for(int a=1; 4*a<=2000; a++){
        for(int b=a; a+3*b<=2000; b++){ 
            for(int c=b; a+b+2*c<=2000; c++){
                
                long long s=a+b+c;
                long long p=a*b*c;
                //if(a==50 && b==100 && c==250) 
                //    printf("hello\n");
                if(p <= m) continue;

                long long d = m*s;
                long long e = p - m;
                //if(!e) continue;
                if(d % e != 0) continue;

                d = d / e;

                if(c > d) continue;

                if(s + d > 2000 || p*d > 2*1e9) continue;

                if((s+d)*m == p*d) printf("%0.2lf %0.2lf %0.2lf %0.2lf\n",a/100.0,b/100.0,c/100.0,d/100.0);

            }
        }
    }
    return 0;
}