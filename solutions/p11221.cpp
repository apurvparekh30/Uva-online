// Apurv Parekh

#include <algorithm>
#include <iostream>
#include <cstdio>
#include <cmath>
#include <string>
#include <vector>

using namespace std;

bool isPerf(int n){
    int root(round(sqrt(n)));
    return n==(root*root);
} 

bool ispln(string s){
    string tmp = s;
    reverse(s.begin(),s.end());
    return s==tmp;
}

int main() {
    int tc; scanf("%d",&tc);
    scanf("% ");
    for(int t=1;t<=tc;t++){
        string s;
        string str="";
        
        getline(cin,s);
        for(char c:s){
            if(isalpha(c)){
                str+=c;
            }
        }
        int l=str.length();
        printf("Case #%d:\n",t);
        if(isPerf(l)){
            int root = sqrt(l);
            char arr[root][root];
            int i,j;
            for(int k=0;k<l;k++){
                i=k/root;
                j=k%root;
                arr[i][j]=str[k];
            }
            bool pln=true;
            string tmp;
            tmp = str;
            pln &= ispln(tmp);
            tmp="";
            for(int i=0;i<root;i++){
                for(int j=0;j<root;j++){
                    tmp+=arr[j][i];
                }
            }
            pln &= ispln(tmp);
            tmp="";
            for(int i=root-1;i>=0;i--){
                for(int j=root-1;j>=0;j--){
                    tmp+=arr[i][j];
                }
            }
            pln &= ispln(tmp);
            for(int i=root-1;i>=0;i--){
                for(int j=root-1;j>=0;j--){
                    tmp+=arr[j][i];
                }
            }
            pln &= ispln(tmp);
            if(pln){
                printf("%d\n",root);
            }
            else{
                printf("No magic :(\n");
            }
        }
        else{
            printf("No magic :(\n");
        }
    }
    return 0;
}