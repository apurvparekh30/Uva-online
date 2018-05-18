#include <algorithm>
#include <iostream>
#include <bitset>

using namespace std;

int main() {

	while(1) {
		int n;
		cin>>n;
		if(cin.eof()){
			break;
		}
		bitset<32> bits(n);
		string bitstring=bits.to_string();
		//cout<< " bits string : " << bitstring << '\n';
		string newbitstring="";
		int len=bitstring.length();
		for(int i=8;i<=32;i=i+8){
			newbitstring+=bitstring.substr(len-i,8);
		}
		//cout<< " new bit string " << newbitstring << '\n';
		bitset<32> newbits(newbitstring);
		int result=(int) (newbits.to_ulong());
		cout<<n<<" converts to " << result<<'\n';
	 }
	return 0;
}
