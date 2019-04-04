#include <bits/stdc++.h>

using namespace std;



unsigned long long  x,y,rx,ry,lx,ly;


void init() {
	x=y=rx=ly=1;
	ry=lx=0;
}

void left() {
	rx=x;
	ry=y;
	x=lx+rx;
	y=ly+ry;
}

void right() {
	lx=x;
	ly=y;
	x=lx+rx;
	y=ly+ry;
}

void print(){
	cout<< x << "/" << y << '\n';
}

int main() {
	int cases;
	cin>>cases;
	while(cases--){
		string s;
		cin>>s;
		init();
		for(char c:s) {
			if(c=='L')
				left();
			else 
				right();
		}	
		print();
	}
	return 0;
}
