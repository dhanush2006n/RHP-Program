#include <iostream>
#include <vector>
#include <climits>
using namespace std;

pair<long long, long long> getFSmax(vector<vector<long long>>& dp,
                                    int col,
                                    int n)
{
    long long fmax = LLONG_MIN;
    long long smax = LLONG_MIN;

    for (int i = 0; i < n; i++)
    {
        if (dp[i][col] > fmax)
        {
            smax = fmax;
            fmax = dp[i][col];
        }
        else if (dp[i][col] > smax)
        {
            smax = dp[i][col];
        }
    }

    return {fmax, smax};
}

int main()
{
    int n, m;
    cin >> n >> m;

    vector<vector<int>> a(n, vector<int>(m));

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> a[i][j];
        }
    }

    vector<vector<long long>> dp(n, vector<long long>(m));

    for (int i = 0; i < n; i++)
    {
        dp[i][0] = a[i][0];
    }

    for (int j = 1; j < m; j++)
    {
        auto [fmax, smax] = getFSmax(dp, j - 1, n);

        for (int i = 0; i < n; i++)
        {
            dp[i][j] = a[i][j]
                     + (dp[i][j - 1] == fmax ? smax : fmax);
        }
    }

    long long ans = LLONG_MIN;

    for (int i = 0; i < n; i++)
    {
        ans = max(ans, dp[i][m - 1]);
    }

    cout << ans << '\n';

    return 0;
}
