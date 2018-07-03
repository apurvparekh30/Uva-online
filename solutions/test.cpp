// UVa 11517 - Exact Change

#include <stdio.h>
#include <string.h>

int main() {
	int t;
	for (scanf("%d", &t); t; t--) {
		int to_pay;
		scanf("%d", &to_pay);
		int n;
		scanf("%d", &n);
		int T[10001];
		memset(T, 127, sizeof(T));
		int oo = T[0];
		T[0] = 0;
		for (int i = 0; i < n; i++) {
			int coin;
			scanf("%d", &coin);
			for (int j = 10000 - coin; j >= 0; j--)
				if (T[j] != oo && T[j] + 1 < T[j + coin])
					T[j + coin] = T[j] + 1;
		}
		while (T[to_pay] == oo)
			to_pay++;
		printf("%d %d\n", to_pay, T[to_pay]);
	}

	return 0;
}
