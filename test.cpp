#include <climits>
#include <cstdio>
#include <cstring>

const int max_n = 50;
const int max_k = 20;

int deps[max_n];

int max (int x, int y) {
  return x > y ? x : y;
}

int min (int x, int y) {
  return x < y ? x : y;
}

int sum (int a[], int start, int end) {
  int res = 0;
  for (int i = start; i <= end; ++i) res += a[i];

  return res;
}

int k_partitioning(int k, int n, int deps[]) {
  int res = INT_MAX;
  // consider all possible rotations/shifts
  for(int offset = 0; offset < n; ++offset) {
    for(int l_min = 0; l_min < n; ++l_min) {
      for(int r_min = l_min; r_min < n; ++r_min) {
        // check minimal sum subarray
        int min_sum = sum (deps, l_min, r_min);

        int dp[k][n];
        for (int s = 0; s < k; ++s) {
          for (int q = 0; q < n; ++q) {
            dp[s][q] = 0;
          }
        }
        // assuming that current sum is a target sum
        dp[0][r_min-l_min] = min_sum;

        for(int p = 1; p < k; ++p) {
          for(int l_max = 0; l_max < n; ++l_max) {
            for(int r_max = 0; r_max < n; ++r_max) {
              int max_sum = sum(deps, l_max, r_max);

              if (max_sum >= min_sum) dp[p][r_max] = max(dp[p-1][l_max], max_sum);
            } // l_maxs
          } // r_maxs
        } // partitions
        // printing dp

        // skip incorrect partitioning, when not all K partitions were used
        if (dp[k-1][n-1] == 0) continue;

        // update difference
        res = min (res, dp[k-1][n-1] - min_sum);
      } // end min sum seg
    } // start min sum seg
    //break;
  } // cuts
  return res;
}

int main(int argc, char* argv[]) {
  int k = 4;
//   scanf("%d", &k);

  int n = 7;
//   scanf("%d", &n);

  int arr[]{ 3,2,11,12,5,5,9};
  printf ("%d\n", k_partitioning(k, n, deps));

  return 0;
}