class feb {

    // =============================== leetcode 121
    public int maxProfit(int[] arr) {
        int ans = 0;
        int minPrice = arr[0];
        for (int i = 0; i < arr.length; i++) {
            ans = Math.max(ans, arr[i] - minPrice);
            minPrice = Math.min(arr[i], minPrice);
        }

        return ans;

    }

    

}