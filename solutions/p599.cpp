#include <bits/stdc++.h>
using namespace std;

int main() {
	int n;
	cin>>n;
	while(n--) {
		string edge;
		//set<pair<char,char>> pairs;
		cin>>edge;
		cin.ignore(numeric_limits<streamsize>::max(),'\n');
		bitset<26>b(0);
                int e_count=0;
                int c_comp=0;
                int acorns=0;

		while(edge[0]!='*'){
			if(edge[1]==edge[3]){
				cin>>edge;
				cin.ignore(numeric_limits<streamsize>::max(),'\n');
				continue;
			}	
			/*if(edge[1]<edge[3]){
				pairs.insert(make_pair(edge[1],edge[3]));
			}
			else {
				pairs.insert(make_pair(edge[3],edge[1]));
			}*/
			e_count++;
                        b|=(1<<edge[1]-'A');
                        b|=(1<<edge[3]-'A');
			cin>>edge;
			cin.ignore(numeric_limits<streamsize>::max(),'\n');
		}		
				
			//e_count=pairs.size();
			string vertex;
			getline(cin,vertex);
			//replace(vertex.begin(),vertex.end(),',','');
			int no=vertex.length();
			//cout<<no<<endl;
			int v_count=(no-(no/2));
			c_comp=v_count-e_count;
			acorns=v_count-b.count();
		
	        cout<< "There are " << c_comp-acorns << " tree(s) and " << acorns<< " acorn(s)."<<'\n';				
	}
}
