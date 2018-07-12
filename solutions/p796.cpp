// Apurv Parekh
// 12th July 2018

#include <bits/stdc++.h>

using namespace std;

static const int UNVISITED = -1;

vector<vector<int> > network;

vector<int> dfsParent;
vector<int> dfsNum;
vector<int> dfsLow;
int dfsCounter = 1;
// Articulation bridge
vector<pair<int, int> > bridge;

void DFS(int u)
{
    dfsNum[u] = dfsLow[u] = dfsCounter++;
    for (auto v: network[u])
    {
        if (dfsNum[v] == UNVISITED)
        {
            dfsParent[v] = u;
            DFS(v);
            if (dfsLow[v] > dfsNum[u])
                bridge.push_back(make_pair(min(u, v), max(u, v)));

            dfsLow[u] = min(dfsLow[u], dfsLow[v]);
        }
        else if (v != dfsParent[u])
            dfsLow[u] = min(dfsLow[u], dfsNum[v]);
    }
}

int main()
{  
    int N;
    while (cin >> N)
    {
        network.clear();
        network.resize(N);
        dfsParent.clear();
        dfsParent.resize(N, UNVISITED);
        dfsNum.clear();
        dfsNum.resize(N, UNVISITED);
        dfsLow.clear();
        dfsLow.resize(N, UNVISITED);

        bridge.clear();

        for (int i = 0; i < N; ++i)
        {
            int u, n, v;
            char c;
            cin >> u;
            cin >> c >> n >> c;
            for (int j = 0; j < n; ++j)
            {
                cin >> v;
                network[u].push_back(v);
                network[v].push_back(u);
            }
        }
        for (int u = 0; u < N; ++u)
            if (dfsNum[u] == UNVISITED)
                DFS(u);

        sort(bridge.begin(), bridge.end());

        cout << bridge.size() << " critical links" << endl;
        for (int i = 0; i < bridge.size(); ++i)
            cout << bridge[i].first 
                 << " - "
                 << bridge[i].second
                 << endl;
        cout << endl;
    }
    return 0;
}