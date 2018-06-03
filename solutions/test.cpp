#include <bits/stdc++.h>
using namespace std;
int main()
{
  std::set< std::vector<int> > conjunto;
  std::vector<int> v0 = std::vector<int>(3);
  v0[0]=0;
  v0[1]=10;
  v0[2]=20;
  std::cout << v0[0] << endl;
  conjunto.insert(v0);
  v0[0]=1;
  v0[1]=11;
  v0[2]=22;
  conjunto.insert(v0);
  std::set< std::vector<int> >::iterator it;
  std::cout << "size = " << conjunto.size() << endl;
  for( it = conjunto.begin(); it != conjunto.end(); it++) {
    const std::vector<int>& i = (*it); // HERE we get the vector
    std::cout << i[0] << endl;  // NOW we output the first item.

    return 0;
  }