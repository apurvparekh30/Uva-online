#include <bits/stdc++.h>
#define eps 1e-7

using namespace std;

double x;
double p,q,r,s,t,u;

double can(double mi){
    return p*exp(-mi)+q*sin(mi)+r*cos(mi)+s*tan(mi)+t*mi*mi+u;
}

bool bianrySearch(double low,double high){
    if(low<high){
        double mid = (low+high)/2.0;
        double f;
        f = can(mid);

        if(fabs(f) <= eps){
            x = mid;
            return true;
        }
        if(f > 0){
            return bianrySearch(mid,high);
        }
        else return bianrySearch(low,mid);
    }
    return false;
}   

int main() {
    while(scanf("%lf %lf %lf %lf %lf %lf",&p,&q,&r,&s,&t,&u)!=EOF){
        if(!p && !q && !r && !s && !t && !u)
        {
            printf("0.0000\n");
            continue;
        }
        if(bianrySearch(0.0,1.0)){
            printf("%.4lf\n",x);
        }
        else {
            printf("No solution\n");
        }
    }
    return 0;
}