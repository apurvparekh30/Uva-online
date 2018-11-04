#include <bits/stdc++.h>
using namespace std;

const int len=32;
int mat[len][len];
int cnt;

void build(int r,int c,int w) {
	char q;
	cin>>q;
	if(q=='p') {
		build(r,c+w/2,w/2);
		build(r,c,+w/2);
		build(r+w/2,c,w/2);
		build(r+w/2,c+w/2,w/2);
	}
	else if(q=='f') {
		for(int i=r;i<(r+w);i++){
			for(int j=c;j<(c+w);j++) {
				if(!mat[i][j]){
					mat[i][j]=1;
					cnt++;
				}
			}	
		}
	}
		
}


int main() {
	int cases;
	cin>>cases;
	while(cases--) {
		cnt=0;
		memset(mat, 0, sizeof(mat));	
		build(0,0,32);
		build(0,0,32);
		cout<< "There are " << cnt << " black pixels." << '\n';
	}
	return 0;
}
