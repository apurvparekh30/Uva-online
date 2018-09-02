// UVa 10812 - Beat the Spread!

#include <iostream>
using namespace std;

#define type signed long long

int main() {
	int cases;
	for (cin >> cases; cases; cases--) {
		type s, d;
		cin >> s >> d;
		type x, y;
		x = (s + d) / 2;
		y = x - d;
		if ((s + d) % 2 == 1 || x < 0 || y < 0)
			cout << "impossible" << endl;
		else
			cout << x << " " << y << endl;
	}
	return 0;
}