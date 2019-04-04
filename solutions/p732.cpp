#include <iostream>
#include <stack>
#include <vector>
using namespace std;

string src, dst;
vector<string> V;

void f(string v = "", string s = "", stack<char> S = stack<char>())
{
    int in = S.size() + s.size();
    if (s.size() == dst.size() && s == dst)
        V.push_back(v);
    if (in < dst.size())
    {
        S.push(src[in]);
        f(v + 'i', s, S);
        S.pop();
    }
    if (!S.empty() && S.top() == dst[s.size()])
    {
        string t = s + S.top();
        S.pop();
        f(v + 'o', t, S);
    }
}

int main()
{
    while (cin >> src >> dst)
    {
        cout << "[\n";
        f();
        for (auto& s : V)
        {
            for (int i = 0; i < s.size(); ++i)
            {
                if (i) cout << ' ';
                cout << s[i];
            }
            cout << '\n';
        }
        cout << "]\n";
        V.clear();
    }
}
