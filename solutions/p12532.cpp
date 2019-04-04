#include <bits/stdc++.h>

using namespace std;

int input[100000+1];
int ST[4 * 100001];


void build(int k,int L,int R) {
	if(L==R){
		ST[k]=input[L];	
		return;
	}
	int m=(L+R)>>1;
	int leftIndex=k<<1;
	int rightIndex=k<<1|1;
	build(leftIndex,L,m);
	build(rightIndex,m+1,R);
	ST[k]=ST[leftIndex]*ST[rightIndex];
}


void update(int k,int L,int R,int i,int v) {
	if(i<L || i>R)
		return;
	if(L==R){
		ST[k]=v;
		return;
	}
	int m=(L+R)>>1;
	update(k<<1,L,m,i,v);
	update(k<<1|1,m+1,R,i,v);
	ST[k]=ST[k<<1]*ST[k<<1|1];
}

int query(int k,int L,int R,int a,int b) {
	if(a>R || b<L) {
		return 1;
	}
	if(a<=L && R<=b) {
		return ST[k];
	}
	int m=(L+R)>>1;
	return (query(k<<1,L,m,a,b) * query(k<<1|1,m+1,R,a,b));
}
int main() {
	while(1) {
		int n,k;
		cin>>n;
		if(cin.eof()) 
			break;
		cin>>k;
		//memset(input,0,sizeof(input));
		for(int i=1;i<=n;i++) {
			cin>>input[i];
			if(input[i]<0)
				input[i]=-1;
			else if(input[i]>0)
				input[i]=1;
		}
		build(1,1,n);		
		for(int i=1;i<=k;i++) {
			char ch;
			int a,b;
			cin>>ch>>a>>b;
			if(ch=='C') {
				if(b>0)
					b=1;
				else if(b<0)
					b=-1;
				else
					b=0;
				if(input[a]!=b){
					update(1,1,n,a,b);
					input[a]=b;
				}
				
			}
			else {
				int result=query(1,1,n,a,b);
				if(result==1){
					cout<<'+';
				}
				else if(result==-1){
					cout<<'-';
				}
				else {
					cout<<'0';
				}
			}
		}
		cout<< '\n';
	}	
	return 0;
}
