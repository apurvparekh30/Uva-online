#include <bits/stdc++.h>

using namespace std;

struct node{
	int mn,mx,label;
};

node ST[1<<18];
long total;


void update(int k) {
	ST[k].mx=max(ST[k<<1].mx,ST[k<<1|1].mx);
	ST[k].mn=min(ST[k<<1].mn,ST[k<<1|1].mn);
}

void updateChild(int k) {
	if(ST[k].label) {
		ST[k<<1].mn=ST[k<<1].mn=ST[k<<1].label=ST[k].label;
		ST[k<<1|1].mn=ST[k<<1|1].mn=ST[k<<1|1].label=ST[k].label;
		ST[k].label=0;
	}
}

void build( int k, int l, int r, int x, int y, int h){
	if(l>r) 
		return;
	if(h<ST[k].mn)
		return; 
	if(x<=l && r<=y) {
		if(h>=ST[k].mx) {
			ST[k].mn=ST[k].mx=ST[k].label=h;
			total+=r-l+1;
			return;
		}
	}
	if(l!=r)
		updateChild(k);
	int m=(l+r)>>1;
	if(y<=m) {
		build(k<<1,l,m,x,y,h);
	}
	else if(x>m){
		build(k<<1|1,m+1,r,x,y,h);
	}
	else {
		build(k<<1,l,m,x,y,h);
		build(k<<1|1,m+1,r,x,y,h);	
	}
	update(k);
}
	
int main() {
	int cases;
	cin>>cases;
	while(cases--){
		int n;
		total=0;
		memset(ST,0,sizeof(ST));
		cin>>n;
		for(int i=0;i<n;i++) {
			int x,y,h;	
			cin>>x>>y>>h;
			y--;
			build(1,1,100000,x,y,h);
		}
		cout<< total << '\n';
	}
}
