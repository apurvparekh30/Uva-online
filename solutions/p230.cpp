#include <bits/stdc++.h>

using namespace std;

struct book {
	string author="";
	string title;
};

bool compare(book a,book b) {
	
	if(a.author==b.author)
		return a.title<b.title;
	return a.author<b.author;
}

int main() {
	vector<book> v;
		map<string,int> position;
	while(1) {
		string input;
		string delim="by";
		getline(cin,input);
		if(input=="END")
			break;
		book b;
		int pos=input.find(delim);
		b.title=input.substr(0,pos-1);
		b.author=input.substr(pos+delim.length()+1);
		v.push_back(b);
	}	
	sort(v.begin(),v.end(),compare);
	int count=0;
	for(auto i:v) {
		position[i.title]=count++;
	}
	int nobooks=v.size();
	vector<bool> borrowed(nobooks,false);
	vector<bool> returned(nobooks,false);

	while(1){
		string input;	
		getline(cin,input);
		if(input=="END")
			break;
		if(input=="SHELVE"){
			int previous=-1;	
			for(int i=0;i<nobooks;i++) {
				if(!borrowed[i])
					previous=i;
				if(returned[i]){
					if(previous==-1) {
						cout<<"Put "<<v[i].title<<" first\n";
					}
					else{
						cout<<"Put "<<v[i].title<<" after " << v[previous].title << '\n';
					}
						returned[i]=false;
						borrowed[i]=false;
						previous=i;
					
				}
			}
			cout<<"END\n";
		}
		else{
			int pos=input.find(" ");
			string ins=input.substr(0,pos);
			string bname=input.substr(pos+1);

			if(ins=="BORROW") {
				borrowed[position[bname]]=true;
				returned[position[bname]]=false;
			}
			else if(ins=="RETURN") {
				returned[position[bname]]=true;
			}
		}
	}
	return 0;
}
