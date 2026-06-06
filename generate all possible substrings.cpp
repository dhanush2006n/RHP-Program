#include <iostream>
using namespace std;

int main() {
    string word;

    cout << "Enter a string: ";
    cin >> word;

    int len = word.size();
    int limit = (1 << len);

    for (int mask = 0; mask < limit; mask++) {
        string subset = "";

        for (int pos = 0; pos < len; pos++) {
            if (mask & (1 << pos)) {
                subset += word[pos];
            }
        }

        cout << subset << endl;
    }

    return 0;
}
