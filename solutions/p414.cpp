#include <bits/stdc++.h>

using namespace std;

int main() {
	while(1) {
		int n;	
		cin>>n;
		if(n==0)
			break;
		vector<string> v(n);
		vector<int> blanks(n);
		cin.ignore();
		for(int i=0;i<n;i++) {
			getline(cin,v[i]);
			size_t occ=count(v[i].begin(),v[i].end(),' ');
			blanks[i]=occ;
		}
		int m=*min_element(blanks.begin(),blanks.end());
		int result=0;
		for(auto i:blanks)
			result+=i-m;
		cout<<result<<'\n';
	}
	return 0;
}
