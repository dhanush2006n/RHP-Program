#include <iostream>
using namespace std;

int main() {
    string text;
    cin >> text;

    int lowerMask = 0;
    int upperMask = 0;

    for (int index = 0; text[index]; index++) {

        if (text[index] >= 'a' && text[index] <= 'z') {
            lowerMask |= (1 << (text[index] - 'a'));
        }

        if (text[index] >= 'A' && text[index] <= 'Z') {
            upperMask |= (1 << (text[index] - 'A'));
        }
    }

    int completeSet = (1 << 26) - 1;

    if (lowerMask == completeSet && upperMask == completeSet) {
        cout << "YES";
    } else {
        cout << "NO";
    }

    return 0;
}
