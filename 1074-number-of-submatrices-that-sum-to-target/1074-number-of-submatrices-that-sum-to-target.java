class Solution {
     public int countMatrix(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int sum = 0;
        map.put(0, 1);
        for (int x : arr) {
            sum += x;
            if (map.containsKey(sum - k))
                ans += map.get(sum - k);
            map.put(sum,map.getOrDefault(sum, 0)+1);
        }

        return ans;
    }

    public int numSubmatrixSumTarget(int[][] arr, int k) {
        int cnt = 0;
        int n = arr.length, m = arr[0].length;

        for (int fixed = 0; fixed < n; fixed++) {
            int[] temp = new int[m];
            for (int row = fixed; row < n; row++) {
                for (int col = 0; col < m; col++)
                    temp[col] += arr[row][col];
                cnt += countMatrix(temp, k);
            }
        }

        return cnt;
    }

}