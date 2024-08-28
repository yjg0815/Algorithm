#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main() {
    string a, b;
    cin >> a >> b;

    int n = max(a.length(), b.length());
    string res(n + 1, '0');
    int before = 0;

    reverse(a.begin(), a.end());
    reverse(b.begin(), b.end());

    for (int i = 0; i < n; i++) {
        int numA = (i < a.length()) ? a[i] - '0' : 0;
        int numB = (i < b.length()) ? b[i] - '0' : 0;

        int sum = numA + numB + before;
        res[i] = (sum % 10) + '0';
        before = sum / 10;
    }

    if (before != 0) {
        res[n] = before + '0';
    }

    reverse(res.begin(), res.end());

    if (res[0] == '0') {
        res.erase(0, 1);
    }

    cout << res << endl;

    return 0;
}
