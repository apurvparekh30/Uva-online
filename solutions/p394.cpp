#include <bits/stdc++.h>
using namespace std;

struct Array {
	string name;
	int base;
	int Cd;
	int dim;
	int L[11];
	int R[11];
	int C[11];
};

int main(){
	int n,r;
	cin>>n>>r;
	
	Array arr[n];
	map<string,int> mp; // name to index
	for(int i=0;i<n;i++){
		cin>>arr[i].name;
		cin>>arr[i].base;
		cin>>arr[i].Cd;
		cin>>arr[i].dim;
		mp[arr[i].name]=i;
		for(int j=1;j<=arr[i].dim;j++){
			cin>>arr[i].L[j];
			cin>>arr[i].R[j];
		}
		arr[i].C[arr[i].dim]=arr[i].Cd;
		for(int d=arr[i].dim-1;d>0;d--) {
			arr[i].C[d]=arr[i].C[d+1]*(arr[i].R[d+1] - arr[i].L[d+1] + 1);
		}
		arr[i].C[0]=arr[i].base;
		for(int k=1;k<=arr[i].dim;k++) {
			arr[i].C[0]-=arr[i].C[k]*arr[i].L[k];
		}
	}
	for(int i=0;i<r;i++) {
		string arrName;
		cin>>arrName;
		int index=mp[arrName];
		int d=arr[index].dim;
		vector<int> ref(d+1);
		for(int j=1;j<=d;j++) {
			cin>>ref[j];
		}
		int result=arr[index].C[0];
		for(int j=1;j<=d;j++){
			result+=arr[index].C[j]*ref[j];
		} 
		cout<< arrName << "[";
		for(int j=1;j<=d;j++) {
			cout<< ref[j];
			if(j!=d) {
				cout<<", ";
			}
		}	
		cout<< "] = " << result<<'\n';
	}
	
	return 0;
}
