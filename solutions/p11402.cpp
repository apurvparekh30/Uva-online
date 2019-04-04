#include <bits/stdc++.h>

using namespace std;

long long ST[5024000];
char lazy[5024000];
long long A[5024000];

void build(long long k,long long l,long long  r) {
	ST[k]=0;
	lazy[k]='X';
	if(l==r){
		ST[k]=A[l];
		
	}
	else {
		long long m=(l+r)>>1;
		long long leftIndex=k<<1;
		long long rightIndex=k<<1|1;

		build(leftIndex,l,m);
		build(rightIndex,m+1,r);

		ST[k]=ST[leftIndex]+ST[rightIndex];
	}
}  


void changeState(long long k) {
	if(lazy[k]=='F'){
		lazy[k]='E';
		return;
	}
	if(lazy[k]=='E'){
		lazy[k]='F';
		return;
	}
	if(lazy[k]=='I') {
		lazy[k]='X';
		return;
	}
	if(lazy[k]=='X') {
		lazy[k]='I';
		return;
	}
}

void propogate(long long  k,long long L,long long R) {
	if(lazy[k]=='F') {
		ST[k]=(R-L)+1;
	}
	else if(lazy[k]=='E') {
		ST[k]=0;
	}
	else{
		int count=(R-L) + 1;
		ST[k]=count-ST[k];
	}

	if(L!=R) {
		if(lazy[k]=='I') {
			changeState(k<<1);
			changeState(k<<1|1);
		}
		else {
			lazy[k<<1]=lazy[k];
			lazy[k<<1|1]=lazy[k];
		}
	}
	lazy[k]='X';
}

void update(long long k,long long L,long long R, long long a,long long b, char op) {
	if(lazy[k]!='X') {
		propogate(k,L,R);
	}
	if( a>R || b<L ) return ;
	if( a<=L && R<=b ) {
		if(op=='E') {
			ST[k]=0;
		}
		if(op=='F') {
			ST[k]=(R-L)+1;
		}
		if(op=='I'){
			int count=(R-L) + 1;
			ST[k]=count-ST[k];
		}
		if(L!=R) {
			if(op!='I'){
				lazy[k<<1]=op;
				lazy[k<<1|1]=op;
			}
			else {
				changeState(k<<1);
				changeState(k<<1|1);
			}
		}
		return;
	}
	long long m=(L+R)>>1;
	update(k<<1,L,m,a,b,op);
	update(k<<1|1,m+1,R,a,b,op);
	ST[k]=ST[k<<1]+ST[k<<1|1];
}


long long query(int k, int L, int R, int a, int b) {
	if(lazy[k]!='X') {
		propogate(k,L,R);
	}
	if(a>R || b<L) {
		return 0;
	}	
	if(a<=L && R<=b) {
		return ST[k];
	} 
	int m=(L+R)>>1;
	int leftValue=query(k<<1,L,m,a,b);
	int rightValue=query(k<<1|1,m+1,R,a,b);
	return (leftValue+rightValue);
}

/*void init(long long n) {
	ST.resize(4*n,0);
	lazy.resize(4*n,0);
}*/	
int main() {
	int cases;
	cin>>cases;
	for(int i=1;i<=cases;i++) {
		cout<< "Case "<<i<<":"<<'\n';
		int m;
		cin>>m;	
		string str="";
		long long idx=0;
		memset(A,0,sizeof(A));
		while(m--) {
			int t;
			cin>>t;
			cin>>str;
			for(long long k=0;k<t;k++) {
				for(long long r=0;r<str.size();r++){
					if(str[r]=='0') 
						A[idx++]=0;
					else
						A[idx++]=1;			
				}
			}
		}	
		//int n=str.length();
		//init(n);
		build(1,0,idx-1);

		int q;
		cin>>q;
		long long ask=0;
		while(q--){
			
			char ch;
			cin>>ch;
			long long a,b;
			cin>>a>>b;
			if(ch=='F' || ch=='E' || ch=='I'){
				update(1,0,idx-1,a,b,ch);
			}
			else {
				cout<<"Q"<<++ask<<": "<<+query(1,0,idx-1,a,b)<<'\n';	
			}
		}
	}
	return 0;
}
