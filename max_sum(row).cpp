#include <iostream>
#include <vector>
#include <climits>
using namespace std;

pair<long long, long long> getFSmax(vector<vector<long long>>& dp, int row)
{
    long long fmax = LLONG_MIN;
    long long smax = LLONG_MIN;

    for (int j = 0; j < dp[row].size(); j++)
    {
        if (dp[row][j] > fmax)
        {
            smax = fmax;
            fmax = dp[row][j];
        }
        else if (dp[row][j] > smax)
        {
            smax = dp[row][j];
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

    for (int j = 0; j < m; j++)
    {
        dp[0][j] = a[0][j];
    }

    for (int i = 1; i < n; i++)
    {
        pair<long long, long long> mx = getFSmax(dp, i - 1);

        long long fmax = mx.first;
        long long smax = mx.second;

        for (int j = 0; j < m; j++)
        {
            if (dp[i - 1][j] == fmax)
            {
                dp[i][j] = a[i][j] + smax;
            }
            else
            {
                dp[i][j] = a[i][j] + fmax;
            }
        }
    }

    long long ans = LLONG_MIN;

    for (int j = 0; j < m; j++)
    {
        ans = max(ans, dp[n - 1][j]);
    }

    cout << ans << endl;

    return 0;
}
