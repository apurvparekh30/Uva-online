#include <bits/stdc++.h>
using namespace std;

int ST[1<<18];


void build(int k,int l,int r,int fArr[]) {
	if(l==r) {
		ST[k]=fArr[l];	
	}
	else {
		int m=(l+r)>>1;
		int leftIndex=k<<1;
		int rightIndex=k<<1|1;
		build(leftIndex,l,m,fArr);
		build(rightIndex,m+1,r,fArr);
		ST[k]=max(ST[leftIndex],ST[rightIndex]);
	}
}


int RMQ(int k,int L,int R,int i,int j) {
	if(i>R || j<L) 	
		return -1;
	if(L>=i && R<=j) {
		return ST[k];
	}
	int m=(L+R)>>1;
	int leftvalue=RMQ(k<<1,L,m,i,j);
	int rightvalue=RMQ(k<<1|1,m+1,R,i,j);
	
	if(leftvalue==-1) return rightvalue;
	if(rightvalue == -1) return leftvalue;
	
	return max(leftvalue,rightvalue);

}



int main() {
	
	while(1) {
		int n;
		cin>>n;	
		if(n==0) break;
		int q;
		cin>>q;
		memset(ST,0,sizeof(ST));
		int values[n+1];
		int start[n+1];
		int end[n+1];
		int fArr[n+1];
		int c,p=0,f=0;
		for(int i=1;i<=n;i++) {
			cin>>c;
			values[i]=c;
			if(i==1) {
				start[i]=i;
			}
			else if(p!=c) {
				for(int j=i-1;j>=start[i-1];j--) {
					fArr[j]=f;
					end[j]=i-1;
				}
				f=0;
				start[i]=i;
			}
			else {
				start[i]=start[i-1];
			}
			f++;
			p=c;
			if(i==n) {
				for(int j=i;j>=start[i];j--) {
					fArr[j]=f;
					end[j]=i;
				}
			}
		}
		build(1,1,n,fArr);

		for(int i=0;i<q;i++) {
			int p,f;
			cin>>p>>f;
			
			if(values[p]==values[f]) {
				cout<<f-p+1<<'\n';
			}
			else {
				int segment1=end[p]-p+1;
				int segment2=f-start[f]+1;
				if(start[f]-end[p]>1) {
					int segment3=RMQ(1,1,n,end[p]+1,start[f]-1);
					cout<< max(segment3,max(segment1,segment2))<<'\n';
				}
				else {
					cout<< max(segment1,segment2)<<'\n';
				}
			}
		}
	}	
	return 0;
}
