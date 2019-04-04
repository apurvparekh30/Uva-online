#include <bits/stdc++.h>
using namespace std;

int main()  {
	while(1){
		int m,n;
		cin>>m;
		if(cin.eof())
			break;
		
		cin>>n;
		cin.ignore(numeric_limits<streamsize>::max(),'\n');

		vector<pair<int,int>> trans[n+1];
		for(int i=1;i<=m;i++) {
			vector<int> index;
			string input;
			getline(cin,input);
			stringstream line(input);
			int no_ele;
			line>>no_ele;
			int no;
			while(line>>no){
				index.push_back(no);
			}
			getline(cin,input);
			vector<int> :: iterator vi=index.begin();
			stringstream line_1(input);
			while(line_1>>no) {
				trans[*vi].push_back(make_pair(i,no));
				vi++;
			}
		}
		cout<<n<<" "<<m<<'\n';
		for(int i=1;i<=n;i++) {
			int row_size=trans[i].size();
			if(row_size==0){
				cout<< "0\n\n";
			}
			else{
				cout<<row_size;
				for(auto j:trans[i]){
					cout<< " " << j.first;
				}
				cout<<'\n';
				int count=0;
				for(auto j:trans[i]){
					if(count>0) {
						cout<<" ";
					}
					cout<<j.second;
					count++;
				}
				cout<<'\n';
			}
		}
	}
	return 0;
}
